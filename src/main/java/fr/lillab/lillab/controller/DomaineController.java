package fr.lillab.lillab.controller;

import fr.lillab.lillab.dto.DomaineDto;
import fr.lillab.lillab.repository.DomaineRepository;
import fr.lillab.lillab.services.DomaineServiceChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DomaineController {
    @Autowired
    private DomaineRepository domaineRepository;
    DomaineServiceChange d = new DomaineServiceChange();
    @GetMapping("/domaines")

    public List<DomaineDto> getAllDomaines() {

        return d.changeListDomaineVersDto(domaineRepository.findAll());
    }

    @PostMapping("/domaine")
    public DomaineDto findDomaineById(@RequestBody String id) {
        return d.changeDomaineVersDomaineDto(domaineRepository.findById(Integer.parseInt(id)).get());
    }
}
