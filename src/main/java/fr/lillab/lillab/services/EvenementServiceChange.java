package fr.lillab.lillab.services;

import fr.lillab.lillab.dto.EvenementDto;
import fr.lillab.lillab.model.Evenement;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class EvenementServiceChange {
    UtilisateurServiceChange utilisateurServiceChange = new UtilisateurServiceChange();

    public EvenementServiceChange() {
    }

    /*
      Changement d'un EvenementDto  vers un evenement domaine
       */
    public Evenement changeDtoVersEvent(EvenementDto event) {
        Evenement evenement = new Evenement();
        evenement.setIdEvent(event.getIdEvent());
        evenement.setLieu(event.getLieu());
        evenement.setTitre(event.getTitre());
        evenement.setDescription(event.getDescription());
        evenement.setDate((Date) event.getDate());
        evenement.setUtilisateur(utilisateurServiceChange.changeDtoVersUtilisateur(event.getUtilisateurDto()));

        evenement.setCptParticipe(event.getCptParticipeDto());
        evenement.setCptParticipePas(event.getCptParticipePasDto());
        evenement.setCptInteresse(event.getCptInteresseDto());

        return evenement;
    }

    /*
    Changement d'un Evenement domaine vers un evenementDto
     */
    public EvenementDto changeEventVersDto(Evenement event) {
        EvenementDto evenementDto = new EvenementDto();
        evenementDto.setIdEvent((event.getIdEvent()));
        evenementDto.setLieu(event.getLieu());
        evenementDto.setTitre(event.getTitre());
        evenementDto.setDescription(event.getDescription());
        evenementDto.setDate(event.getDate());
        evenementDto.setUtilisateurDto(utilisateurServiceChange.changeUtilisateurVersDto(event.getUtilisateur()));

        evenementDto.setCptParticipeDto(event.getCptParticipe());
        evenementDto.setCptParticipePasDto(event.getCptParticipePas());
        evenementDto.setCptInteresseDto(event.getCptInteresse());

        return evenementDto;
    }

    /*
   Changement d'une liste Evenement vers une liste EvenementDto
    */
    public List<Evenement> changeListDtoVersEvent(List<EvenementDto> listEventDto) {
        List<Evenement> listEvent = new ArrayList<Evenement>();
        for (EvenementDto event : listEventDto) {
            listEvent.add(changeDtoVersEvent(event));
        }
        return listEvent;
    }

    /*
Changement d'une liste EvenementDto vers une liste Evenement
 */
    public List<EvenementDto> changeListEventVersDto(List<Evenement> listEvent) {
        List<EvenementDto> listEventDto = new ArrayList<EvenementDto>();
        for (Evenement event : listEvent) {
            listEventDto.add(changeEventVersDto(event));
        }
        return listEventDto;
    }
}
