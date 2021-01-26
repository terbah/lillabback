package fr.lillab.lillab.dto;

import fr.lillab.lillab.model.Competence;

import java.util.ArrayList;
import java.util.List;

public class CompetenceDto {
    private String libelle;



    public CompetenceDto(String libelle) {
        this.libelle = libelle;

    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public CompetenceDto() {
    }


}
