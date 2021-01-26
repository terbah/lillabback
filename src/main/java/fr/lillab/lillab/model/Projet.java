package fr.lillab.lillab.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Projet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProjet;

    @ManyToOne
    private Utilisateur utilisateur;

    @ManyToMany
    private List<Competence> competencesList = new ArrayList<>();

    @ManyToMany
    private List<Domaine> domainesList = new ArrayList<>();

    @Column(nullable = false, columnDefinition = "TEXT")
    private String titre;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Date dateCreation;

    @Column(nullable = false)
    private String budget;

    @Column(nullable = false)
    private Integer nbparticipants;

    @Column(nullable = false)
    private Date dateDebut;

    @Column(nullable = false)
    private Date dateFin;

    private Date dateModif;

    private byte[] image;

    public Projet() {
    }

    public Long getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(Long idProjet) {
        this.idProjet = idProjet;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<Competence> getCompetencesList() {
        return competencesList;
    }

    public void setCompetencesList(List<Competence> competencesList) {
        this.competencesList = competencesList;
    }

    public List<Domaine> getDomainesList() {
        return domainesList;
    }

    public void setDomainesList(List<Domaine> domainesList) {
        this.domainesList = domainesList;
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

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public Integer getNbparticipants() {
        return nbparticipants;
    }

    public void setNbparticipants(Integer nbparticipants) {
        this.nbparticipants = nbparticipants;
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

    public Date getDateModif() {
        return dateModif;
    }

    public void setDateModif(Date dateModif) {
        this.dateModif = dateModif;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void addCompetence(Competence competence){
        competencesList.add(competence);
        // competence.set
    }

    public void removeCompetence(Competence competence){
        domainesList.remove(competence);
        //competence.setUtilisateur(null);
    }

    public void addDomaine(Domaine domaine){
        domainesList.add(domaine);
    }

    public void removeDomaine(Domaine domaine){
        domainesList.remove(domaine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Projet)) return false;
        return idProjet != null && idProjet.equals(((Projet) o).getIdProjet());
    }
}
