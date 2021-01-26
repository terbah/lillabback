package fr.lillab.lillab.controller;

import fr.lillab.lillab.dto.TypeUtilisateurDto;
import fr.lillab.lillab.repository.TypeUtilisateurRepository;
import fr.lillab.lillab.services.TypeUtilisateurServiceChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TypeUtilisateurController {
    TypeUtilisateurServiceChange typeUtilisateurServiceChange = new TypeUtilisateurServiceChange();
    @Autowired
    private TypeUtilisateurRepository typeUtilisateurRepository;

    @GetMapping("/types_utilisateurs")

    public List<TypeUtilisateurDto> getAllTypeUtilisateurs() {
        List<TypeUtilisateurDto> listsType =typeUtilisateurServiceChange.changeListTypeUtilisateurVersDto(typeUtilisateurRepository.findAll());
        return listsType;
    }
}
