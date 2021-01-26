package fr.lillab.lillab.controller;

import fr.lillab.lillab.dto.PouceDto;
import fr.lillab.lillab.model.Idee;
import fr.lillab.lillab.model.Pouce;
import fr.lillab.lillab.model.Utilisateur;
import fr.lillab.lillab.repository.IdeeRepository;
import fr.lillab.lillab.repository.PouceRepository;
import fr.lillab.lillab.repository.UtilisateurRepository;
import fr.lillab.lillab.services.PouceServiceChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PouceController {
	@Autowired
	private PouceRepository pouceRepository;

	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Autowired
	private IdeeRepository ideeRepository;
	PouceServiceChange d = new PouceServiceChange();

	@GetMapping("/pouces")
	public List<PouceDto> getAllPouces() {
		return d.changeListPouceVersDto(pouceRepository.findAll());
	}

	@GetMapping("/pouces/idee")
	public List<PouceDto> getAllPoucesByIdee(@RequestParam String idIdee) {
		Idee idee = ideeRepository.findAllByIdidee(Long.parseLong(idIdee));
		return d.changeListPouceVersDto(pouceRepository.findAllByIdeepouce(idee));
	}

	@PostMapping(value = "/pouce")
	public void addPouce(@RequestBody Pouce pouce) {
		Pouce pouceNouveau = new Pouce();
		Idee idee = new Idee();
		idee = ideeRepository.findAllByIdidee(pouce.getIdee().getIdidee());
		Utilisateur u = utilisateurRepository.findByIdutilisateur(pouce.getUtilisateur().getIdutilisateur());
		// pouceNouveau.setUtilisateur(pouce.getUtilisateur());
		if (!idee.getPouceListe().contains(pouce)) {
			pouceNouveau.setUtilisateur(u);
			pouceNouveau.setIdee(idee);
			pouceNouveau.setDateCreation(pouce.getDateCreation());
			pouceRepository.save(pouceNouveau);
		}
	}
}
