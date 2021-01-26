package fr.lillab.lillab.repository;

import fr.lillab.lillab.model.SuccessStorie;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SuccessStorieRepository extends JpaRepository<SuccessStorie, Long> {

    //List<SuccessStorie> findAllByOrderByDateCreation() ;
}
