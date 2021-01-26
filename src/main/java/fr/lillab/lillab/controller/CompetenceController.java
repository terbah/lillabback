package fr.lillab.lillab.controller;


import fr.lillab.lillab.dto.CompetenceDto;
import fr.lillab.lillab.repository.CompetenceRepository;
import fr.lillab.lillab.services.CompetenceServiceChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CompetenceController {
    @Autowired
    private CompetenceRepository competenceRepository;
    CompetenceServiceChange d = new CompetenceServiceChange();
    @GetMapping("/competences")

    public List<CompetenceDto> getAllCompetences() {
        return d.changeListCompetenceVersDto(competenceRepository.findAll());
    }
}
