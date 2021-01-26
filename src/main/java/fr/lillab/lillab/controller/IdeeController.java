package fr.lillab.lillab.controller;


import fr.lillab.lillab.dto.IdeeDto;
import fr.lillab.lillab.model.Competence;
import fr.lillab.lillab.model.Domaine;
import fr.lillab.lillab.model.Idee;
import fr.lillab.lillab.model.Utilisateur;
import fr.lillab.lillab.repository.CompetenceRepository;
import fr.lillab.lillab.repository.DomaineRepository;
import fr.lillab.lillab.repository.IdeeRepository;
import fr.lillab.lillab.repository.UtilisateurRepository;
import fr.lillab.lillab.services.IdeeServiceChange;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class IdeeController {

    @Autowired
    private IdeeRepository ideeRepository;

    @Autowired
    private CompetenceRepository competenceRepository;

    @Autowired
    private DomaineRepository domaineRepository;


    @Autowired
    private UtilisateurRepository utilisateurRepository;

    IdeeServiceChange ideeDto = new IdeeServiceChange();
    private static final Logger log = LogManager.getLogger(IdeeController.class);

    @GetMapping(value = "/idees", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<IdeeDto> getAllIdees() {
        return ideeDto.changeListIdeeVersDto(ideeRepository.findAllByOrderByDatecreationDesc());
    }


    @GetMapping(value = "/ideesByUtilisateur", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<IdeeDto> getAllIdeesByUtilisateur(@RequestParam String email) {
        Utilisateur usersIdea = utilisateurRepository.findByEmail(email);
        // log.info(usersIdea.toString());
        //ideeRepository.findAllByUtilisateur(user.getIdutilisateur())
        return ideeDto.changeListIdeeVersDto(ideeRepository.findAllByUtilisateur(usersIdea));
    }

    @GetMapping(value = "/filterByCompetenceOrDomaine", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<IdeeDto> getIdeesByCompetenceOrDomaine(@RequestParam String competence, @RequestParam String domaine) {
        Competence competenceExist = competenceRepository.findByLibelle(competence);
        Domaine domaineExist = domaineRepository.findByLibelle(domaine);
       // Utilisateur usersIdea = utilisateurRepository.findByEmail(email);
        // log.info(usersIdea.toString());
        //ideeRepository.findAllByUtilisateur(user.getIdutilisateur())
        return ideeDto.changeListIdeeVersDto(ideeRepository.findAllByCompetenceListContainsOrDomaineListContains(competenceExist,domaineExist));
    }

    @GetMapping(value = "/ideeDetail", produces = MediaType.APPLICATION_JSON_VALUE)
    public IdeeDto getDetailsIdee(@RequestParam String idIdee) {
        return ideeDto.changeIdeeVersDto(ideeRepository.findAllByIdidee(Long.parseLong(idIdee)));
    }

    @PostMapping(value = "/idee")
    public void addIdea(@RequestBody Idee idea) {
        Idee ideeNouveau = new Idee();
        ideeNouveau.setIdidee(idea.getIdidee());
        ideeNouveau.setDatecreation(idea.getDatecreation());
        ideeNouveau.setDescription(idea.getDescription());
        ideeNouveau.setUtilisateur(idea.getUtilisateur());
        ideeNouveau.setTitre(idea.getTitre());
        idea.getCompetenceList().stream().forEach(
                competence -> {
                    Competence competenceIdee = new Competence();
                    competenceIdee = competenceRepository.findByLibelle(competence.getLibelle());
                    ideeNouveau.getCompetenceList().add(competenceIdee);

                }
        );
        idea.getDomaineList().stream().forEach(
                domaine -> {
                    Domaine domaineIdee = new Domaine();
                    domaineIdee = domaineRepository.findByLibelle(domaine.getLibelle());
                    ideeNouveau.getDomaineList().add(domaineIdee);

                }
        );

        log.info(ideeNouveau);
        ideeRepository.save(ideeNouveau);
    }

    @PostMapping(value = "/uploadPhoto")
    public void uploadImage(@RequestParam("image") MultipartFile file , @RequestParam String titre) throws IOException {
        Idee addImageToIdea = ideeRepository.findByTitre(titre);
        addImageToIdea.setImage(file.getBytes());
        ideeRepository.save(addImageToIdea);
    }

    @PostMapping(value = "/modifyIdeePerUser")
    public void updateIdeaPerUser(@RequestBody Idee ideaTomodify) {
        Idee ideeToUpdate = ideeRepository.findAllByIdidee(ideaTomodify.getIdidee());
        ideeToUpdate.setTitre(ideaTomodify.getTitre());
        ideeToUpdate.setDescription(ideaTomodify.getDescription());
        ideeToUpdate.setDatemodif(ideaTomodify.getDatemodif());
        if (ideaTomodify.getCompetenceList().size() != 0) {
            ideaTomodify.getCompetenceList().stream().forEach(
                    competence -> {
                        Competence competenceIdee = new Competence();
                        competenceIdee = competenceRepository.findByLibelle(competence.getLibelle());
                        if (!ideeToUpdate.getCompetenceList().contains(competenceIdee)) {
                            ideeToUpdate.getCompetenceList().add(competenceIdee);
                        }

                    }
            );
        }

        if (ideaTomodify.getDomaineList().size() != 0) {
            ideaTomodify.getDomaineList().stream().forEach(
                    domaine -> {
                        Domaine domaineIdee = new Domaine();
                        domaineIdee = domaineRepository.findByLibelle(domaine.getLibelle());
                        if (!ideeToUpdate.getDomaineList().contains(domaineIdee)) {
                            ideeToUpdate.getDomaineList().add(domaineIdee);
                        }
                    }
            );
        }


        ideeRepository.save(ideeToUpdate);

    }

    @Transactional
    @PostMapping(value = "/deleteIdeePerUser")
    public void deleteIdeePerUser(@RequestBody String id) {
        ideeRepository.deleteByIdidee(Long.parseLong(id));
    }

}
