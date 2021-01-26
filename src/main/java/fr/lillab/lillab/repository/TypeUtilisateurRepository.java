package fr.lillab.lillab.repository;

import fr.lillab.lillab.model.TypeUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeUtilisateurRepository extends JpaRepository<TypeUtilisateur, Integer> {
    TypeUtilisateur findByLibelle(String libelle);
}

