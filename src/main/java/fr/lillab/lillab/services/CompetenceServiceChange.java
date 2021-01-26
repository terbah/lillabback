package fr.lillab.lillab.services;

import fr.lillab.lillab.dto.CompetenceDto;
import fr.lillab.lillab.model.Competence;

import java.util.ArrayList;
import java.util.List;

public class CompetenceServiceChange {


    public CompetenceServiceChange() {
    }

    /*
      Changement d'une liste de competenceDto vers une liste de competence
       */
    public List<Competence> changeListCompetenceDtoVersComp (List<CompetenceDto> listCompetenceDto){
        List<Competence> listCompetence = new ArrayList<Competence>();
        for (CompetenceDto c : listCompetenceDto) {
            Competence competence = new Competence();
            competence.setLibelle(c.getLibelle());
            listCompetence.add(competence);
        }
        return listCompetence;
    }
    /*
    Changement d'une liste de competence vers une liste de competenceDto
     */
    public List<CompetenceDto> changeListCompetenceVersDto (List<Competence> listCompetence){
        List<CompetenceDto> listCompetenceDto = new ArrayList<CompetenceDto>();
        for (Competence c : listCompetence) {
            CompetenceDto competenceDto = new CompetenceDto();
            competenceDto.setLibelle(c.getLibelle());
            listCompetenceDto.add(competenceDto);
        }
        return listCompetenceDto;
    }

    /*
    Changement d'un CompDto vers une competence
     */
    public Competence changeCompetenceDtoVersComp (CompetenceDto c){
        Competence competence = new Competence();
        competence.setLibelle(c.getLibelle());

        return competence;
    }
    /*
    Changement d'une competence vers un Dto
     */
    public CompetenceDto changeCompetenceVersDto (Competence c){
        CompetenceDto competenceDto = new CompetenceDto();
        competenceDto.setLibelle(c.getLibelle());

        return competenceDto;
    }
}
