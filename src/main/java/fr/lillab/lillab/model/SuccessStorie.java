package fr.lillab.lillab.model;

import javax.persistence.*;
import java.io.File;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class SuccessStorie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idsuccessstorie;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String titre;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Date dateDebut;

    @Column(nullable = false)
    private Date dateFin;

    @Column(nullable = false)
    private String budget;

    @Column(nullable = false)
    private String etat;

    @Column(nullable = false)
    private Integer nbconcernees;

    @Column(nullable = true)
    private File File;

    @ManyToOne
    private Utilisateur utilisateur;

    @OneToOne
    @JoinColumn(name="ididee")
    private Idee ideesuccessstorie;

    public SuccessStorie() {
    }

    public SuccessStorie(String titre, String description, Date dateDebut, Date dateFin, String budget, String etat, Integer nbconcernees, java.io.File file, Utilisateur utilisateur, Idee ideesuccessstorie) {
        this.titre = titre;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.budget = budget;
        this.etat = etat;
        this.nbconcernees = nbconcernees;
        File = file;
        this.utilisateur = utilisateur;
        this.ideesuccessstorie = ideesuccessstorie;
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

    public Long getIdsuccessstorie() {
        return idsuccessstorie;
    }

    public void setIdsuccessstorie(Long idsuccessstorie) {
        this.idsuccessstorie = idsuccessstorie;
    }

    public Idee getIdeesuccessstorie() {
        return ideesuccessstorie;
    }

    public void setIdeesuccessstorie(Idee ideesuccessstorie) {
        this.ideesuccessstorie = ideesuccessstorie;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SuccessStorie)) return false;
        return idsuccessstorie != null && idsuccessstorie.equals(((SuccessStorie) o).getIdsuccessstorie());
    }

    @Override
    public String toString() {
        return "SuccessStorie{" +
                "idSuccessStorie=" + ideesuccessstorie +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", budget='" + budget + '\'' +
                ", etat='" + etat + '\'' +
                ", nbconcernees=" + nbconcernees +
                ", File=" + File +
                ", utilisateur=" + utilisateur +
                ", ideeSuccessStorie=" + ideesuccessstorie +
                '}';
    }
}
