package fr.lillab.lillab.repository;

import fr.lillab.lillab.model.Domaine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomaineRepository extends JpaRepository<Domaine, Integer> {
    Domaine findByLibelle(String libelle);
}
