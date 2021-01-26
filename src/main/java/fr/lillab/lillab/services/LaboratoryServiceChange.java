package fr.lillab.lillab.services;

import fr.lillab.lillab.dto.LaboratoryDto;
import fr.lillab.lillab.model.Laboratory;

import java.util.ArrayList;
import java.util.List;

public class LaboratoryServiceChange {

    public LaboratoryDto changeLaboratoryVersDto(Laboratory l){
        LaboratoryDto laboratoryDto = new LaboratoryDto();
        laboratoryDto.setDesignation(l.getDesignation());
        return laboratoryDto;
    }

    public List<LaboratoryDto> changeListLaboratoryVersDto(List<Laboratory> listLaboratory){
        List<LaboratoryDto> listLaboratoryDto = new ArrayList<LaboratoryDto>();
        for (Laboratory l : listLaboratory) {
            LaboratoryDto laboratoryDto = new LaboratoryDto();
            laboratoryDto.setDesignation(l.getDesignation());
            listLaboratoryDto.add(laboratoryDto);
        }
        return listLaboratoryDto;
    }

    public List<Laboratory> changeListLaboratoryDtoVersLaboratory(List<LaboratoryDto> listLaboratoryDto){
        List<Laboratory> listLaboratory = new ArrayList<Laboratory>();
        for (LaboratoryDto c : listLaboratoryDto) {
            Laboratory laboratory = new Laboratory();
            laboratory.setDesignation(c.getDesignation());
            listLaboratory.add(laboratory);
        }
        return listLaboratory;
    }
}
