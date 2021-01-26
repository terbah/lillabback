package fr.lillab.lillab.controller;


import fr.lillab.lillab.dto.ProjetDto;
import fr.lillab.lillab.model.Competence;
import fr.lillab.lillab.model.Domaine;
import fr.lillab.lillab.model.Projet;
import fr.lillab.lillab.repository.CompetenceRepository;
import fr.lillab.lillab.repository.DomaineRepository;
import fr.lillab.lillab.repository.ProjetRepository;
import fr.lillab.lillab.repository.UtilisateurRepository;
import fr.lillab.lillab.services.ProjetServiceChange;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProjetController {
    ProjetServiceChange projetDto = new ProjetServiceChange();
    @Autowired
    private ProjetRepository projetRepository;

    private static final Logger log = LogManager.getLogger(ProjetController.class);

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private CompetenceRepository competenceRepository;

    @Autowired
    private DomaineRepository domaineRepository;

    @GetMapping("/projets")

    public List<ProjetDto> getAllProjet() {
        return projetDto.changeListProjetVersDto(projetRepository.findAll());
    }

    @PostMapping(value = "/projet")
    public void addProject(@RequestBody Projet projet) {
        log.info(projet.toString());
        Projet projetNouveau = new Projet();
        projetNouveau.setUtilisateur(utilisateurRepository.findByIdutilisateur(projet.getUtilisateur().getIdutilisateur()));
        projetNouveau.setDateCreation(projet.getDateCreation());
        projetNouveau.setDateDebut(projet.getDateDebut());
        projetNouveau.setDateFin(projet.getDateFin());
        projetNouveau.setTitre(projet.getTitre());
        projetNouveau.setBudget(projet.getBudget());
        projetNouveau.setDescription(projet.getDescription());
        projetNouveau.setNbparticipants(projet.getNbparticipants());

        projet.getCompetencesList().stream().forEach(
                competence -> {
                    Competence competenceIdee = new Competence();
                    competenceIdee = competenceRepository.findByLibelle(competence.getLibelle());
                    projetNouveau.getCompetencesList().add(competenceIdee);

                }
        );
        projet.getDomainesList().stream().forEach(
                domaine -> {
                    Domaine domaineIdee = new Domaine();
                    domaineIdee = domaineRepository.findByLibelle(domaine.getLibelle());
                    projetNouveau.getDomainesList().add(domaineIdee);

                }
        );

        projetRepository.save(projetNouveau);
    }


    @PostMapping(value = "/uploadPhotoProjet")
    public void uploadImage(@RequestParam("image") MultipartFile file, @RequestParam String description) throws IOException {
        Projet addImageToProject = projetRepository.findByDescription(description);
        addImageToProject.setImage(file.getBytes());
        projetRepository.save(addImageToProject);
    }

    @GetMapping(value = "/projetDetail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProjetDto getDetailsProject(@RequestParam String idProjet) {
        return projetDto.changeProjetVersDto(projetRepository.findByIdProjet(Long.parseLong(idProjet)));
    }

    @PostMapping(value = "/modifyProjet")
    public void updateProject(@RequestBody Projet projetToModify) {
        Projet projetToUpdate = projetRepository.findByIdProjet(projetToModify.getIdProjet());
        projetToUpdate.setTitre(projetToModify.getTitre());
        projetToUpdate.setBudget(projetToModify.getBudget());
        projetToUpdate.setDescription(projetToModify.getDescription());
        projetToUpdate.setNbparticipants(projetToModify.getNbparticipants());
        projetToUpdate.setDateDebut(projetToModify.getDateDebut());
        projetToUpdate.setDateFin(projetToModify.getDateFin());
        projetToUpdate.setUtilisateur(utilisateurRepository.findByIdutilisateur(projetToModify.getUtilisateur().getIdutilisateur()));

        if (projetToUpdate.getCompetencesList().size() != 0) {
            projetToModify.getCompetencesList().stream().forEach(
                    competence -> {
                        Competence competenceIdee = new Competence();
                        competenceIdee = competenceRepository.findByLibelle(competence.getLibelle());
                        if (!projetToUpdate.getCompetencesList().contains(competenceIdee)) {
                            projetToUpdate.getCompetencesList().add(competenceIdee);
                        }

                    }
            );
        }
        projetRepository.save(projetToUpdate);

    }

    @Transactional
    @PostMapping(value = "/deleteProjet")
    public void deleteProject(@RequestBody String id) {
        projetRepository.deleteByIdProjet(Long.parseLong(id));
    }


}
