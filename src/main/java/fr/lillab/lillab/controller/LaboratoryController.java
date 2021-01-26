package fr.lillab.lillab.controller;

import fr.lillab.lillab.dto.LaboratoryDto;
import fr.lillab.lillab.repository.LaboratoryRepository;
import fr.lillab.lillab.services.LaboratoryServiceChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LaboratoryController {
    LaboratoryServiceChange laboratoryServiceChange = new LaboratoryServiceChange();

    @Autowired
    private LaboratoryRepository laboratoryRepository;

    @GetMapping("/get_laboratory")
    public List<LaboratoryDto> getAllLaboratory() {
        List<LaboratoryDto> listLaboratory =laboratoryServiceChange.changeListLaboratoryVersDto(laboratoryRepository.findAll());
        return listLaboratory;
    }
}
