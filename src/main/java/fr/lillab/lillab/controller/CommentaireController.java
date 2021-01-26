package fr.lillab.lillab.controller;

import fr.lillab.lillab.dto.CommentaireDto;
import fr.lillab.lillab.model.Commentaire;
import fr.lillab.lillab.model.Idee;
import fr.lillab.lillab.model.Utilisateur;
import fr.lillab.lillab.repository.CommentaireRepository;
import fr.lillab.lillab.repository.IdeeRepository;
import fr.lillab.lillab.repository.UtilisateurRepository;
import fr.lillab.lillab.services.CommentaireServiceChange;
import fr.lillab.lillab.services.IdeeServiceChange;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CommentaireController {
    private static final Logger log = LogManager.getLogger(CommentaireController.class);
    @Autowired
    private CommentaireRepository commentaireRepository;

    @Autowired
    private IdeeRepository ideeRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    CommentaireServiceChange d = new CommentaireServiceChange();
    IdeeServiceChange ideeDto = new IdeeServiceChange();

    @GetMapping("/commentaires")
    public List<CommentaireDto> getAllCommentaires() {
        return d.changeListCommentaireVersDto(commentaireRepository.findAll());
    }

    @PostMapping(value = "/commentaire")
    public void addComment(@RequestBody Commentaire comment) {
        Commentaire nouveauCommentaire = new Commentaire();
        Utilisateur user = new Utilisateur();
        Idee idee = new Idee();

        idee = ideeRepository.findAllByIdidee(comment.getIdee().getIdidee());
      //  log.info("userretrievd"+ idee.toString());
        nouveauCommentaire.setIdee(idee);
        nouveauCommentaire.setDateCreation(comment.getDateCreation());
        nouveauCommentaire.setTexteComment(comment.getTexteComment());
        user = utilisateurRepository.findByEmail(comment.getUtilisateur().getEmail());
        nouveauCommentaire.setUtilisateur(user);
        log.info("userretrievd"+ comment.getIdee().getIdidee());

        nouveauCommentaire.setUtilisateur(utilisateurRepository.findByIdutilisateur(comment.getUtilisateur().getIdutilisateur()));
        commentaireRepository.save(nouveauCommentaire);
    }

    @GetMapping(value = "/commentsPerIdee", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CommentaireDto> getAllCommentPerIdea(@RequestParam String idIdee) {
        Idee ideeComment = ideeRepository.findAllByIdidee(Long.parseLong(idIdee));
        log.info(ideeComment.toString());
        return d.changeListCommentaireVersDto(commentaireRepository.findAllByIdeecomment(ideeComment));

    }

}
