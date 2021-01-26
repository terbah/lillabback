package fr.lillab.lillab.controller;

import fr.lillab.lillab.dto.SuccessStorieDto;
import fr.lillab.lillab.model.SuccessStorie;
import fr.lillab.lillab.repository.IdeeRepository;
import fr.lillab.lillab.repository.SuccessStorieRepository;
import fr.lillab.lillab.repository.UtilisateurRepository;
import fr.lillab.lillab.services.SuccessStorieServiceChange;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SuccessStorieController {

    SuccessStorieServiceChange successStorieDto = new SuccessStorieServiceChange();
    private static final Logger log = LogManager.getLogger(SuccessStorieController.class);

    @Autowired
    private SuccessStorieRepository successStorieRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private IdeeRepository ideeRepository;

    @GetMapping(value = "/successStories",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SuccessStorieDto> getAllSuccessStorie() {
        return successStorieDto.ChangeListSuccessStorieVersDto(successStorieRepository.findAll());
    }

    @PostMapping(value = "/successStorie")
    public void addsuccessStorie(@RequestBody SuccessStorie successStorie) {
        log.info(successStorie.toString());
        SuccessStorie successStorieNouveau = new SuccessStorie();
        successStorieNouveau.setUtilisateur(utilisateurRepository.findByIdutilisateur(successStorie.getUtilisateur().getIdutilisateur()));
        successStorieNouveau.setDateDebut(successStorie.getDateDebut());
        successStorieNouveau.setDateFin(successStorie.getDateFin());
        successStorieNouveau.setTitre(successStorie.getTitre());
        successStorieNouveau.setBudget(successStorie.getBudget());
        successStorieNouveau.setDescription(successStorie.getDescription());
        successStorieNouveau.setNbconcernees(successStorie.getNbconcernees());
        successStorieNouveau.setFile(successStorie.getFile());
        successStorieNouveau.setEtat(successStorie.getEtat());
        successStorieNouveau.setIdeesuccessstorie(successStorie.getIdeesuccessstorie());
        successStorieRepository.save(successStorieNouveau);
    }
}

