package fr.lillab.lillab.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
//@Table(name = "domaine")
public class Domaine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iddomaine;
    //@Column(name = "libelle", columnDefinition = "VARCHAR")

    //@Column(nullable = false, unique = true)
    private String libelle;

    @ManyToMany(mappedBy = "domaines")
    @JsonIgnore
    private List<Utilisateur> utilisateurs;
    
    @ManyToMany(mappedBy = "domaineList")
    private List<Idee> idees;
    
    @ManyToMany(mappedBy = "domainesList")
    private List<Projet> projets;

    public Domaine() {
    }

    public Long getIddomaine() {
        return iddomaine;
    }

    public void setIddomaine(Long iddomaine) {
        this.iddomaine = iddomaine;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }
}
