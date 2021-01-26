package fr.lillab.lillab.repository;

import fr.lillab.lillab.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

//import javax.rmi.CORBA.Util;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    public Utilisateur findByEmail(String email);
    public  Utilisateur findByEmailAndMotdepasse(String email, String motdepasse);
    public Utilisateur findByIdutilisateur(Long idUtilisateur);
}
