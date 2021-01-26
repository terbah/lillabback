package fr.lillab.lillab.repository;

import fr.lillab.lillab.model.Idee;
import fr.lillab.lillab.model.Pouce;
import fr.lillab.lillab.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PouceRepository extends JpaRepository<Pouce, Integer> {
    List<Pouce> findAllByIdeepouce(Idee idee);
    List<Pouce> findAllByUtilisateur(Utilisateur user);
}
