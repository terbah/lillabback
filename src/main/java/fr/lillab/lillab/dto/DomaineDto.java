package fr.lillab.lillab.dto;

import fr.lillab.lillab.model.Competence;

public class DomaineDto {
    private String libelle;

    public DomaineDto(String libelle) {
        this.libelle = libelle;
    }
    public DomaineDto() {

    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


}
