package fr.lillab.lillab.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Laboratory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idLabo;

    private String designation;

    @OneToMany(mappedBy = "laboratory")
    @JsonIgnore
    private List<Utilisateur> utilisateurs;

   /* @ManyToMany(mappedBy = "laboratories", cascade = CascadeType.PERSIST)
    private List<Idee> idees = new ArrayList<>();*/

    public Laboratory(String designation) {
        this.designation = designation;
    }

    public Laboratory() {
    }

    public Long getIdLabo() {
        return idLabo;
    }

    public void setIdLabo(Long idLabo) {
        this.idLabo = idLabo;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

  /*  public List<Idee> getIdees() {
        return idees;
    }

    public void setIdees(List<Idee> idees) {
        this.idees = idees;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Laboratory)) return false;
        return idLabo != null && idLabo.equals(((Laboratory) o).getIdLabo());
    }
}
