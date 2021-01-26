package fr.lillab.lillab.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class Commentaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IdCommentaire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idutilisateur")
    private Utilisateur user;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="ididee")
    // @Column(nullable = false)
    private Idee ideecomment;

    private String texteComment;

   // @Column(nullable = false)
    private Date dateCreation;

    private Date dateModif;


    public int getIdCommentaire() {
        return IdCommentaire;
    }

    public void setIdCommentaire(int idCommentaire) {
        IdCommentaire = idCommentaire;
    }

    public Utilisateur getUtilisateur() {
        return user;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.user = utilisateur;
    }

    public Idee getIdee() {
        return ideecomment;
    }

    public void setIdee(Idee idee) {
        this.ideecomment = idee;
    }

    public String getTexteComment() {
        return texteComment;
    }

    public void setTexteComment(String texteComment) {
        this.texteComment = texteComment;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateModif() {
        return dateModif;
    }

    @Override
    public String toString() {
        return "Commentaire{" +
                "IdCommentaire=" + IdCommentaire +
                ", user=" + user.getEmail() +
                ", idee=" + ideecomment.getIdidee() +
                ", texteComment='" + texteComment + '\'' +
                ", dateCreation=" + dateCreation +
                ", dateModif=" + dateModif +
                '}';
    }

    public void setDateModif(Date dateModif) {
        this.dateModif = dateModif;
    }
}
