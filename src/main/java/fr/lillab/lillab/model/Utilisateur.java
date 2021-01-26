package fr.lillab.lillab.model;

import javax.persistence.*;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
//@Table(name = "utilisateur")
public class Utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idutilisateur;


    @OneToMany(mappedBy = "utilisateur",fetch =FetchType.LAZY)
    private List<Idee> ideeList = new ArrayList<>();

    @OneToMany(mappedBy = "utilisateur",fetch =FetchType.LAZY)
    private List<Projet> projets = new ArrayList<>();

    @ManyToMany
    private List<Competence> competenceList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Commentaire> commentairesList = new ArrayList<>();

    @OneToMany(mappedBy = "utilisateur")
    private List<Pouce> likeList = new ArrayList<>();

    @ManyToMany
    private List<Domaine> domaines = new ArrayList<>();

    @OneToMany(mappedBy = "utilisateur",fetch =FetchType.LAZY)
    private List<SuccessStorie> successstories = new ArrayList<>();

    @ManyToOne
    private Laboratory laboratory;

    public List<SuccessStorie> getSuccessStories() {
        return successstories;
    }

    public void setSuccessStories(List<SuccessStorie> successstories) {
        this.successstories = successstories;
    }

    @ManyToOne
    private TypeUtilisateur type;

    private String nom;
    private String prenom,description,liens;
    @Column(nullable = false)//, unique = true)
    private String email;
    @Column(nullable = false)
    private String motdepasse;
    private byte[] image;
    private byte[] imagecouverture;
    /*
    @Column(name = "libelle", nullable = false)
    private String libelle;
    @Column(name = "domaine", nullable = false)
    private String domaine;
     */

    public Long getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Long idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public List<Idee> getIdeeList() {
        return ideeList;
    }

    public void setIdeeList(List<Idee> ideeList) {
        this.ideeList = ideeList;
    }

    public List<Competence> getCompetenceList() {
        return competenceList;
    }

    public void setCompetenceList(List<Competence> competenceList) {
        this.competenceList = competenceList;
    }

    public List<Commentaire> getCommentaireList() {
        return commentairesList;
    }

    public void setCommentaireList(List<Commentaire> commentaireList) {
        this.commentairesList = commentaireList;
    }

    public List<Pouce> getLikeList() {
        return likeList;
    }

    public void setLikeList(List<Pouce> likeList) {
        this.likeList = likeList;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public TypeUtilisateur getType() {
        return type;
    }

    public void setType(TypeUtilisateur type) {
        this.type = type;
    }

    public List<Domaine> getDomaines() {
        return domaines;
    }

    public void setDomaines(List<Domaine> domaines) {
        this.domaines = domaines;
    }

    public Utilisateur() {
    }

    public List<Projet> getProjets() {
        return projets;
    }

    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }

    public Laboratory getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(Laboratory laboratory) {
        this.laboratory = laboratory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLiens() {
        return liens;
    }

    public void setLiens(String liens) {
        this.liens = liens;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public byte[] getImagecouverture() {
        return imagecouverture;
    }

    public void setImagecouverture(byte[] imagecouverture) {
        this.imagecouverture = imagecouverture;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "idutilisateur=" + idutilisateur +
                ", ideeList=" + ideeList +
                ", projets=" + projets +
                ", competenceList=" + competenceList +
                ", commentairesList=" + commentairesList +
                ", likeList=" + likeList +
                ", domaines=" + domaines +
                ", successstories=" + successstories +
                ", laboratory=" + laboratory +
                ", type=" + type +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", description='" + description + '\'' +
                ", liens='" + liens + '\'' +
                ", email='" + email + '\'' +
                ", motdepasse='" + motdepasse + '\'' +
                ", image=" + Arrays.toString(image) +
                ", imagecouverture=" + Arrays.toString(imagecouverture) +
                '}';
    }
}
