package fr.lillab.lillab.dto;

import fr.lillab.lillab.model.Idee;

import java.sql.Date;

public class SuccessStorieDto {
    private Long idSuccessStorie;
    private String titre;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private String budget;
    private String etat;
    private Integer nbconcernees;
    private java.io.File File;
    private Idee ideeSuccessStorie;
    UtilisateurDto utilisateurDto = new UtilisateurDto();

    public SuccessStorieDto(Long idSuccessStorie, String titre, String description, Date dateDebut, Date dateFin, String budget, String etat, Integer nbconcernees, java.io.File file, Idee ideeSuccessStorie, UtilisateurDto utilisateurDto) {
        this.idSuccessStorie = idSuccessStorie;
        this.titre = titre;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.budget = budget;
        this.etat = etat;
        this.nbconcernees = nbconcernees;
        File = file;
        this.ideeSuccessStorie = ideeSuccessStorie;
        this.utilisateurDto = utilisateurDto;
    }

    public SuccessStorieDto() {
    }

    public Long getIdSuccessStorie() {
        return idSuccessStorie;
    }

    public void setIdSuccessStorie(Long idSuccessStorie) {
        this.idSuccessStorie = idSuccessStorie;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Integer getNbconcernees() {
        return nbconcernees;
    }

    public void setNbconcernees(Integer nbconcernees) {
        this.nbconcernees = nbconcernees;
    }

    public java.io.File getFile() {
        return File;
    }

    public void setFile(java.io.File file) {
        File = file;
    }

    public Idee getIdeeSuccessStorie() {
        return ideeSuccessStorie;
    }

    public void setIdeeSuccessStorie(Idee ideeSuccessStorie) {
        this.ideeSuccessStorie = ideeSuccessStorie;
    }

    public UtilisateurDto getUtilisateurDto() {
        return utilisateurDto;
    }

    public void setUtilisateurDto(UtilisateurDto utilisateurDto) {
        this.utilisateurDto = utilisateurDto;
    }
}
