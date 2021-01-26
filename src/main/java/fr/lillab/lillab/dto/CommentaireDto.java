package fr.lillab.lillab.dto;

import fr.lillab.lillab.model.Commentaire;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentaireDto {
    private String textCom;
    private Date dateMODIF;
    private UtilisateurDto utilisateurDto;

    UtilisateurDto User = new UtilisateurDto();


    public CommentaireDto(String textCom, Date dateMODIF, UtilisateurDto utilisateurDto) {
        this.textCom = textCom;
        this.dateMODIF = dateMODIF;
        this.utilisateurDto = utilisateurDto;

    }

    public CommentaireDto() {
    }

    public String getTextCom() {
        return textCom;
    }

    public void setTextCom(String textCom) {
        this.textCom = textCom;
    }

    public Date getDateMODIF() {
        return dateMODIF;
    }

    public void setDateMODIF(Date dateMODIF) {
        this.dateMODIF = dateMODIF;
    }

    public UtilisateurDto getUtilisateurDto() {
        return utilisateurDto;
    }

    public void setUtilisateurDto(UtilisateurDto utilisateurDto) {
        this.utilisateurDto = utilisateurDto;
    }




}
