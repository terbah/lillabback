package fr.lillab.lillab.repository;

import fr.lillab.lillab.model.Laboratory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaboratoryRepository extends JpaRepository<Laboratory, Long> {
    Laboratory findByDesignation(String designation);
}
