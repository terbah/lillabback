package fr.lillab.lillab.services;

import fr.lillab.lillab.dto.DomaineDto;
import fr.lillab.lillab.model.Domaine;

import java.util.ArrayList;
import java.util.List;

public class DomaineServiceChange {


    public DomaineServiceChange() {
    }
    /*
    Changement d'un domaine vers un domaineDto
     */
    public DomaineDto changeDomaineVersDomaineDto (Domaine domaine){
        DomaineDto domaineDto = new DomaineDto();
        domaineDto.setLibelle(domaine.getLibelle());
        return domaineDto;
    }

    /*
    Changement d'un domaineDto vers un domaine du package du Domaine de l'application
     */
    public Domaine changeDomaineDtoVersDomaine (DomaineDto domaineDto){
        Domaine domaine = new Domaine();
        domaine.setLibelle(domaineDto.getLibelle());
        return domaine;
    }
    /*
      Changement d'une liste de domaineDto vers une liste de domaine
         */
    public List<Domaine> changeListDtoVersDomaine (List<DomaineDto> listDomaineDto){
        List<Domaine> listDomaine = new ArrayList<Domaine>();
        for (DomaineDto c : listDomaineDto){
            Domaine domaine = new Domaine();
            domaine.setLibelle(c.getLibelle());
            listDomaine.add(domaine);
        }
        return listDomaine;
    }
    /*
    Changement d'une liste de domaine vers une liste de domaineDto
     */
    public List<DomaineDto> changeListDomaineVersDto (List<Domaine> listDomaine){
        List<DomaineDto> listDomainesDto = new ArrayList<DomaineDto>();
        for (Domaine c : listDomaine){
            DomaineDto domaineDto = new DomaineDto();
            domaineDto.setLibelle(c.getLibelle());
            listDomainesDto.add(domaineDto);
        }
        return listDomainesDto;
    }


}
