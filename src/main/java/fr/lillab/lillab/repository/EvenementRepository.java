package fr.lillab.lillab.repository;

import fr.lillab.lillab.model.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvenementRepository extends JpaRepository<Evenement, Integer> {
    Evenement findByIdEvent(Long id);
    void deleteByIdEvent(Long id);
}
