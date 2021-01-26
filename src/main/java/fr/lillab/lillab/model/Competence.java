package fr.lillab.lillab.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Competence implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCompetence;

   // @Column(nullable = false, unique = true)
    private String libelle;

    @ManyToMany(mappedBy = "competenceList", cascade = CascadeType.PERSIST)
    private List<Idee> idees = new ArrayList<>();

    @ManyToMany(mappedBy = "competenceList")
    @JsonIgnore
    private List<Utilisateur> utilisateurs;

    @ManyToMany(mappedBy = "competencesList")
    private List<Projet> projets;
    
    public Long getIdCompetence() {
        return idCompetence;
    }

    public void setIdCompetence(Long idCompetence) {
        this.idCompetence = idCompetence;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Competence() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Idee)) return false;
        return idCompetence != null && idCompetence.equals(((Competence) o).getIdCompetence());
    }

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

	public List<Idee> getIdees() {
		return idees;
	}

	public void setIdees(List<Idee> idees) {
		this.idees = idees;
	}
    
    
}
