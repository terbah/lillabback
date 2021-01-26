package fr.lillab.lillab.services;

import fr.lillab.lillab.dto.CommentaireDto;
import fr.lillab.lillab.model.Commentaire;
import fr.lillab.lillab.services.UtilisateurServiceChange;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class CommentaireServiceChange {
    UtilisateurServiceChange utilservice= new UtilisateurServiceChange();

    /*
    Changement de la liste des commentaire domaine vers liste de commentaire Dto
     */
    public List<CommentaireDto> changeListCommentaireVersDto (List<Commentaire> listCommentaire){
        List<CommentaireDto> listCommentaireDto = new ArrayList<CommentaireDto>();
        for (Commentaire c : listCommentaire){
            CommentaireDto commentaireDto = new CommentaireDto();
            commentaireDto.setTextCom(c.getTexteComment());
            commentaireDto.setDateMODIF(c.getDateModif());
            commentaireDto.setUtilisateurDto(utilservice.changeUtilisateurVersDto(c.getUtilisateur()));
            listCommentaireDto.add(commentaireDto);
        }
        return listCommentaireDto;
    }

    /*
    Changement d'une liste de commentaireDTO vers une liste de commentaire domaine
     */
    public List<Commentaire> changeListDtoComVersCommentaire(List<CommentaireDto> listCommentaireDto) {
        List<Commentaire> listCommentaire = new ArrayList<Commentaire>();
        if (listCommentaireDto.size() == 0) {
            return null;
        } else {
            for (CommentaireDto c : listCommentaireDto) {
                Commentaire commentaire = new Commentaire();
                commentaire.setTexteComment(c.getTextCom());
                commentaire.setDateModif((Date) c.getDateMODIF());
                commentaire.setUtilisateur(utilservice.changeDtoVersUtilisateur(c.getUtilisateurDto()));
                listCommentaire.add(commentaire);
            }
            return listCommentaire;
        }
    }

    /*
  Changement d'un commentaire vers DTO
   */
    public CommentaireDto changeCommentaireVersDto (Commentaire c){
        CommentaireDto commentaireDto = new CommentaireDto();
        commentaireDto.setTextCom(c.getTexteComment());
        commentaireDto.setDateMODIF(c.getDateModif());
        commentaireDto.setUtilisateurDto(utilservice.changeUtilisateurVersDto(c.getUtilisateur()));
        return commentaireDto;
    }
    /*
    Changement d'un DTO vers un commentaire
     */
    public Commentaire changeDtoComVersCommentaire(CommentaireDto c) {
        Commentaire commentaire = new Commentaire();
        commentaire.setTexteComment(c.getTextCom());
        commentaire.setDateModif((Date) c.getDateMODIF());
        commentaire.setUtilisateur(utilservice.changeDtoVersUtilisateur(c.getUtilisateurDto()));

        return commentaire;

    }
}
