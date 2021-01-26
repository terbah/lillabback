package fr.lillab.lillab.controller;

import fr.lillab.lillab.dto.EvenementDto;
import fr.lillab.lillab.model.Evenement;
import fr.lillab.lillab.model.Idee;
import fr.lillab.lillab.repository.EvenementRepository;
import fr.lillab.lillab.services.EvenementServiceChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EvenementController {

    @Autowired
    private EvenementRepository evenementRepository ;

    EvenementServiceChange d = new EvenementServiceChange();

    @GetMapping("/events")
    public List<EvenementDto> getAllEvenements() {
        return d.changeListEventVersDto(evenementRepository.findAll());
    }

    @PostMapping(value = "/evenement")
    public void addEvent(@RequestBody Evenement event) {
        evenementRepository.save(event);
    }

    @PostMapping(value = "/modifyEvenementParticipe")
    public void updateEventParticipe(@RequestBody Long idEventFront) {
        Evenement myEvent = evenementRepository.findByIdEvent(idEventFront);
        myEvent.setCptParticipe(myEvent.getCptParticipe()+1);

        evenementRepository.save(myEvent);
    }

    @PostMapping(value = "/modifyEvenementParticipePas")
    public void updateEventParticipePas(@RequestBody Long idEventFront) {
        Evenement myEvent = evenementRepository.findByIdEvent(idEventFront);
        myEvent.setCptParticipePas(myEvent.getCptParticipePas()+1);

        evenementRepository.save(myEvent);
    }

    @PostMapping(value = "/modifyEvenementInteresse")
    public void updateEventInteresse(@RequestBody Long idEventFront) {
        Evenement myEvent = evenementRepository.findByIdEvent(idEventFront);
        myEvent.setCptInteresse(myEvent.getCptInteresse()+1);

        evenementRepository.save(myEvent);
    }

    @Transactional
    @PostMapping(value = "/deleteEventPerUser")
    public void deleteEventPerUser(@RequestBody Long idEventFront) {
        evenementRepository.deleteByIdEvent(idEventFront);
    }

}
