package fr.lillab.lillab.repository;


import fr.lillab.lillab.model.Idee;
import fr.lillab.lillab.model.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetRepository extends JpaRepository<Projet, Integer> {
    Projet findByDescription(String description);
    Projet findByIdProjet(Long id);
    void deleteByIdProjet(Long id);
}
