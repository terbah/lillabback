package fr.lillab.lillab.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Idee implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4909171384144734322L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ididee;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idutilisateur")

    private Utilisateur utilisateur;

    private String titre;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "ideecomment")
    private List<Commentaire> commentaireList = new ArrayList<>();

    @OneToMany(mappedBy = "ideepouce")
    private List<Pouce> likeList = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Competence> competenceList = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Domaine> domaineList = new ArrayList<>();

    @Column(nullable = false)
    private Date datecreation;
    
    @OneToOne(mappedBy = "ideesuccessstorie")
    private SuccessStorie successstorie;

    private Date datemodif;


    private byte[] image;

    public Idee(Utilisateur utilisateur, String titre, String description, List<Commentaire> commentaireList, List<Competence> competenceList, List<Domaine> domaineList, Date datecreation, Date datemodif) {
        this.utilisateur = utilisateur;
        this.titre = titre;
        this.description = description;
        this.commentaireList = commentaireList;
        this.competenceList = competenceList;
        this.domaineList = domaineList;
        this.datecreation = datecreation;
        this.datemodif = datemodif;
    }

    
    
    public SuccessStorie getSuccessStorie() {
		return successstorie;
	}



	public void setSuccessStorie(SuccessStorie successStorie) {
		this.successstorie = successStorie;
	}



	public Idee(){

    }
    public Long getIdidee() {
        return ididee;
    }

    public void setIdidee(Long ididee) {
        this.ididee = ididee;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Commentaire> getCommentaireList() {
        return commentaireList;
    }

    public void setCommentaireList(List<Commentaire> commentaireList) {
        this.commentaireList = commentaireList;
    }

    public List<Pouce> getPouceListe() {
        return likeList;
    }

    public void setLikeListe(List<Pouce> commentaireList) {
        this.likeList = commentaireList;
    }

    public List<Competence> getCompetenceList() {
        return competenceList;
    }

    public void setCompetenceList(List<Competence> competenceList) {
        this.competenceList = competenceList;
    }

    public List<Domaine> getDomaineList() {
        return domaineList;
    }

    public void setDomaineList(List<Domaine> domaineList) {
        this.domaineList = domaineList;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public Date getDatemodif() {
        return datemodif;
    }

    public void setDatemodif(Date datemodif) {
        this.datemodif = datemodif;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Idee{" +
                "ididee=" + ididee +
                ", utilisateur=" + utilisateur.getEmail() +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", commentaireList=" + commentaireList +
                ", likeList=" + likeList +
                ", competenceList=" + competenceList +
                ", domaineList=" + domaineList +
                ", datecreation=" + datecreation +
                ", datemodif=" + datemodif +
                ", image=" + Arrays.toString(image) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Idee)) return false;
        return ididee != null && ididee.equals(((Idee) o).getIdidee());
    }

}
