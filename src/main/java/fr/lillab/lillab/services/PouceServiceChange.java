package fr.lillab.lillab.services;

import fr.lillab.lillab.dto.PouceDto;
import fr.lillab.lillab.model.Pouce;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class PouceServiceChange {

    UtilisateurServiceChange utilisateurServiceChange= new UtilisateurServiceChange();


    /*
       Chagement d'une liste de PouceDto vers une liste de pouce
        */
    public List<Pouce> changeListDtoVersPouce (List<PouceDto> listPouceDto){
        List<Pouce> listPouce = new ArrayList<Pouce>();
        for (PouceDto c : listPouceDto) {
            Pouce pouce =new Pouce();
            pouce.setDateCreation((java.sql.Date) c.getDateCreation());
            pouce.setUtilisateur(utilisateurServiceChange.changeDtoVersUtilisateur(c.getUtilisateur()));
            listPouce.add(pouce);
        }
        return listPouce;
    }
    /*
    Chagement d'une liste de Pouce vers une liste de pouceDto
     */
    public List<PouceDto> changeListPouceVersDto (List<Pouce> listPouce){
        List<PouceDto> listPouceDto = new ArrayList<PouceDto>();
        for (Pouce c : listPouce) {
            PouceDto pouceDto =new PouceDto();
            pouceDto.setUtilisateur(utilisateurServiceChange.changeUtilisateurVersDto(c.getUtilisateur()));
            pouceDto.setDateCreation(c.getDateCreation());
            listPouceDto.add(pouceDto);
        }
        return listPouceDto;
    }

    /*
   Changement d'un pouceDto vers un pouce
    */
    public Pouce changeDtoVersPouce (PouceDto c){

        Pouce pouce =new Pouce();
        pouce.setDateCreation((java.sql.Date) c.getDateCreation());
        pouce.setUtilisateur(utilisateurServiceChange.changeDtoVersUtilisateur(c.getUtilisateur()));

        return pouce;
    }
    /*
    Changement d'un pouce vers Dto
     */
    public PouceDto changePouceVersDto (Pouce c){

        PouceDto pouceDto =new PouceDto();
        pouceDto.setUtilisateur(utilisateurServiceChange.changeUtilisateurVersDto(c.getUtilisateur()));
        pouceDto.setDateCreation(c.getDateCreation());

        return pouceDto;
    }
}
