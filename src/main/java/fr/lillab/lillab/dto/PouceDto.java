package fr.lillab.lillab.dto;


import fr.lillab.lillab.model.Pouce;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class PouceDto {

    private UtilisateurDto utilisateur=new UtilisateurDto();
    private Date dateCreation;


    public PouceDto( UtilisateurDto utilisateur, Date dateCreation) {

        this.utilisateur = utilisateur;
        this.dateCreation = dateCreation;
    }

    public PouceDto() {
    }



    public UtilisateurDto getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurDto utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

}
