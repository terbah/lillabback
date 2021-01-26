package fr.lillab.lillab.repository;

import fr.lillab.lillab.model.Commentaire;
import fr.lillab.lillab.model.Idee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentaireRepository extends JpaRepository<Commentaire, Integer> {
    List<Commentaire> findAllByIdeecomment(Idee idee);
}
