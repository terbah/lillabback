package fr.lillab.lillab.repository;

import fr.lillab.lillab.model.Competence;
import fr.lillab.lillab.model.Domaine;
import fr.lillab.lillab.model.Idee;
import fr.lillab.lillab.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IdeeRepository extends JpaRepository<Idee, Integer> {
    List<Idee> findAllByUtilisateur(Utilisateur user);

    List<Idee> findAllByOrderByDatecreationDesc();
    Idee findAllByIdidee(Long id);
    Idee findByIdidee(Long id);
    Idee findByTitre(String titre);
    List <Idee> findAllByCompetenceListContainsOrDomaineListContains(Competence competence, Domaine domaine);


    void deleteByIdidee(Long id);
}
