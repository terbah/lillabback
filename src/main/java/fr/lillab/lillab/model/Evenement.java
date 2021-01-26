package fr.lillab.lillab.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Evenement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEvent;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String lieu;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String titre;

    private String description;
    @Column(nullable = false, columnDefinition = "TEXT")
    private Date date;

    private Long cptParticipe;
    private Long cptParticipePas;
    private Long cptInteresse;

    private Byte[] image;

    @ManyToOne
    // @JoinColumn(name = "id_evenement_utilisateur",referencedColumnName = "idutilisateur")

    private Utilisateur utilisateur;

    public Long getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Long idEvent) {
        this.idEvent = idEvent;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Long getCptParticipe() {
        return cptParticipe;
    }

    public void setCptParticipe(Long cptParticipe) {
        this.cptParticipe = cptParticipe;
    }

    public Long getCptParticipePas() {
        return cptParticipePas;
    }

    public void setCptParticipePas(Long cptParticipePas) {
        this.cptParticipePas = cptParticipePas;
    }

    public Long getCptInteresse() {
        return cptInteresse;
    }

    public void setCptInteresse(Long cptInteresse) {
        this.cptInteresse = cptInteresse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Evenement)) return false;
        return idEvent != null && idEvent.equals(((Evenement) o).getIdEvent());
    }

}
