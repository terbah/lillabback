package fr.lillab.lillab.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;


@Entity
public class Pouce implements Serializable {

    // Attributs
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPouce;

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="ididee")
    private Idee ideepouce;

    @ManyToOne
    private Utilisateur utilisateur;

	@Column(nullable = false)
    private Date dateCreation;


    // Constructeurs
    
	public Pouce(Idee idee, Utilisateur utilisateur, Date dateCreation) {
		super();
		this.ideepouce = idee;
		this.utilisateur = utilisateur;
		this.dateCreation = dateCreation;
	}

	public Pouce() {
	}

	public int getIdPouce() {
		return idPouce;
	}


	public void setIdPouce(int idPouce) {
		this.idPouce = idPouce;
	}


	public Idee getIdee() {
		return ideepouce;
	}


	public void setIdee(Idee idee) {
		this.ideepouce = idee;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	public Date getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pouce other = (Pouce) obj;
		if (ideepouce == null) {
			if (other.ideepouce != null)
				return false;
		} else if (!ideepouce.equals(other.ideepouce))
			return false;
		if (utilisateur == null) {
			if (other.utilisateur != null)
				return false;
		} else if (!utilisateur.equals(other.utilisateur))
			return false;
		return true;
	}

	
    
}
