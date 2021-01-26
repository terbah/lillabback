package fr.lillab.lillab.controller;

import fr.lillab.lillab.dto.UtilisateurDto;
import fr.lillab.lillab.model.Competence;
import fr.lillab.lillab.model.Domaine;
import fr.lillab.lillab.model.Idee;
import fr.lillab.lillab.model.Utilisateur;
import fr.lillab.lillab.repository.*;
import fr.lillab.lillab.services.UtilisateurServiceChange;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UtilisateurController {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    UtilisateurServiceChange User = new UtilisateurServiceChange();
    @Autowired
    private LaboratoryRepository laboratoryRepository;

    @Autowired
    private DomaineRepository domaineRepository;

    @Autowired
    private CompetenceRepository competenceRepository;

    @Autowired
    private TypeUtilisateurRepository typeUtilisateurRepository;

    private static final Logger log = LogManager.getLogger(UtilisateurController.class);

   /* @Autowired
    private final PasswordE
    ncoder passwordEncoder;*/

    @GetMapping(value ="/utilisateurs", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UtilisateurDto> getAllTypeUtilisateurs() {

        return User.changeListUtilisateurVersDto(utilisateurRepository.findAll());
    }

    @PostMapping(value = "/utilisateur_authentification", produces = "application/json")
    public Utilisateur getUtilisateur(@RequestBody Utilisateur newUtilisateur) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] encryptedPassword = md.digest(newUtilisateur.getMotdepasse().getBytes());
        newUtilisateur.setMotdepasse(Base64.getEncoder().encodeToString(encryptedPassword));
        Utilisateur utilisateur = utilisateurRepository.findByEmailAndMotdepasse(newUtilisateur.getEmail(), newUtilisateur.getMotdepasse());
        return utilisateur;
    }

    @PostMapping(value = "/utilisateur", produces = "text/plain")
    public String newUtilisateur(@RequestBody Utilisateur newUtilisateur) throws NoSuchAlgorithmException {
        Utilisateur checkUser = utilisateurRepository.findByEmail(newUtilisateur.getEmail());
        if (checkUser != null) {

            return "error";
        } else {
            log.info(newUtilisateur.toString());
            Utilisateur nouvelUtilisateur = new Utilisateur();
            nouvelUtilisateur.setNom(newUtilisateur.getNom());
            nouvelUtilisateur.setPrenom(newUtilisateur.getPrenom());
            nouvelUtilisateur.setEmail(newUtilisateur.getEmail());
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] encryptedPassword = md.digest(newUtilisateur.getMotdepasse().getBytes());
            nouvelUtilisateur.setMotdepasse(Base64.getEncoder().encodeToString(encryptedPassword));
            nouvelUtilisateur.setType(typeUtilisateurRepository.findByLibelle(newUtilisateur.getType().getLibelle()));
            newUtilisateur.getDomaines().stream().forEach(
                    domaine -> {
                        Domaine domaineUtilisateur = new Domaine();
                        domaineUtilisateur = domaineRepository.findByLibelle(domaine.getLibelle());
                        nouvelUtilisateur.getDomaines().add(domaineUtilisateur);
                    }
            );
            newUtilisateur.getCompetenceList().stream().forEach(
                    competence -> {
                        log.info(competence.getLibelle());
                        Competence competenceUtilisateur = new Competence();
                        competenceRepository.save(competence);
                        competenceUtilisateur = competenceRepository.findByLibelle(competence.getLibelle());
                        nouvelUtilisateur.getCompetenceList().add(competenceUtilisateur);
                    }
            );
            //nouvelUtilisateur.setTypeUtilisateur(typeUtilisateurRepository.findByLibelle(newUtilisateur.getTypeUtilisateur().getLibelle()));
            nouvelUtilisateur.setLaboratory(laboratoryRepository.findByDesignation(newUtilisateur.getLaboratory().getDesignation()));
            utilisateurRepository.save(nouvelUtilisateur);

                   /* utilisateurRepository.save(new Utilisateur(newUtilisateur.getIdutilisateur(), newUtilisateur.getNom(), newUtilisateur.getPrenom(), newUtilisateur.getEmail(), newUtilisateur.getMotdepasse(),
                    newUtilisateur.getDomaines(),newUtilisateur.getCommentaireList(),newUtilisateur.getIdeeList(),newUtilisateur.getCompetenceList(),newUtilisateur.getIdeeList(),newUtilisateur.getLikeList()));
           */
            return "success";
        }

    }
    @GetMapping(value = "/profilDetail", produces = MediaType.APPLICATION_JSON_VALUE)
    public UtilisateurDto getDetailsUtilisateur(@RequestParam String idutilisateur) {
        return User.changeUtilisateurVersDto(utilisateurRepository.findByIdutilisateur(Long.parseLong(idutilisateur)));
    }
    @PostMapping(value = "/profilmodify", produces = "text/plain")
    public void updateUser(@RequestBody Utilisateur userTomodify) throws NoSuchAlgorithmException {
        Utilisateur userToUpdate = utilisateurRepository.findByEmail(userTomodify.getEmail());
        userToUpdate.setIdutilisateur(userToUpdate.getIdutilisateur());
        userToUpdate.setNom(userTomodify.getNom());
        userToUpdate.setDescription(userTomodify.getDescription());
        userToUpdate.setPrenom(userTomodify.getPrenom());
        userToUpdate.setLiens(userTomodify.getLiens());
        userToUpdate.setEmail(userTomodify.getEmail());
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] encryptedPassword = md.digest(userToUpdate.getMotdepasse().getBytes());
        userToUpdate.setMotdepasse(Base64.getEncoder().encodeToString(encryptedPassword));
        userToUpdate.setType(typeUtilisateurRepository.findByLibelle(userToUpdate.getType().getLibelle()));
        userToUpdate.setLaboratory(laboratoryRepository.findByDesignation(userTomodify.getLaboratory().getDesignation()));
        // userToUpdate.getCompetenceList().add(competenceRepository.findByLibelle(userTomodify.getCompetenceList().get(0).getLibelle()));
        // userToUpdate.setLaboratory(userTomodify.getLaboratory());
        //   userToUpdate.getCompetenceList().set(0,competenceRepository.findByLibelle(userTomodify.getCompetenceList().get(0).getLibelle()));
        if (userTomodify.getDomaines().size() != 0) {
            userToUpdate.setDomaines(new ArrayList<Domaine>());
            userTomodify.getDomaines().stream().forEach(
                    domaine -> {
                        Domaine domaineUser = new Domaine();
                        domaineUser = domaineRepository.findByLibelle(domaine.getLibelle());
                        userToUpdate.getDomaines().add(domaineUser);
                    }
            );
        }
        //    if (userTomodify.getCompetenceList().size() != 0) {
        userTomodify.getCompetenceList().stream().forEach(
                competence -> {

                    Competence comp = new Competence();
                    //comp.setLibelle(competence.getLibelle());
                    comp = competenceRepository.findByLibelle(competence.getLibelle());
                    userToUpdate.getCompetenceList().add(comp);
                }
        );
        // }

        utilisateurRepository.save(userToUpdate);

    }

    @PostMapping(value = "/uploadPhotoUser")
    public void uploadImage(@RequestParam("image") MultipartFile file, @RequestParam("imagecouverture") MultipartFile fileC, @RequestParam String idutilisateur) throws IOException {
        Utilisateur addImageToUser = utilisateurRepository.findByIdutilisateur(Long.parseLong(idutilisateur));
        addImageToUser.setImage(file.getBytes());
        addImageToUser.setImagecouverture(fileC.getBytes());
        utilisateurRepository.save(addImageToUser);
    }
}
