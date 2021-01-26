package fr.lillab.lillab.repository;

import fr.lillab.lillab.model.Competence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetenceRepository extends JpaRepository<Competence, Integer> {
    Competence findByLibelle(String libelle);
}

