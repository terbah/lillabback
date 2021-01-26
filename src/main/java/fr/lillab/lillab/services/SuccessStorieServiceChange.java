package fr.lillab.lillab.services;

import fr.lillab.lillab.dto.SuccessStorieDto;
import fr.lillab.lillab.model.SuccessStorie;

import java.util.ArrayList;
import java.util.List;

public class SuccessStorieServiceChange {
    UtilisateurServiceChange utilisateurServiceChange= new UtilisateurServiceChange();
    public SuccessStorie ChangeDtoversSuccessStorie (SuccessStorieDto ssd){
        SuccessStorie ss = new SuccessStorie();
        ss.setIdsuccessstorie(ssd.getIdSuccessStorie());
        ss.setBudget(ssd.getBudget());
        ss.setDateDebut(ssd.getDateDebut());
        ss.setDateFin(ssd.getDateFin());
        ss.setDescription(ssd.getDescription());
        ss.setEtat(ssd.getEtat());
        ss.setFile(ssd.getFile());
        ss.setTitre(ssd.getTitre());
        ss.setIdeesuccessstorie(ssd.getIdeeSuccessStorie());
        ss.setUtilisateur(utilisateurServiceChange.changeDtoVersUtilisateur(ssd.getUtilisateurDto()));
        return ss;
    }
    public SuccessStorieDto ChangeSuccessStorieVersDto (SuccessStorie ss){
        SuccessStorieDto ssd = new SuccessStorieDto();
        ssd.setIdSuccessStorie(ss.getIdsuccessstorie());
        ssd.setBudget(ss.getBudget());
        ssd.setDateDebut(ss.getDateDebut());
        ssd.setDateFin(ss.getDateFin());
        ssd.setDescription(ss.getDescription());
        ssd.setEtat(ss.getEtat());
        ssd.setFile(ss.getFile());
        ssd.setTitre(ss.getTitre());
        ssd.setIdeeSuccessStorie(ss.getIdeesuccessstorie());
        ssd.setUtilisateurDto(utilisateurServiceChange.changeUtilisateurVersDto(ss.getUtilisateur()));
        return ssd;

    }
    public List<SuccessStorie> ChangeListDtoVersSuccessStorie (List<SuccessStorieDto> lssd){
        List<SuccessStorie> lss = new ArrayList<SuccessStorie>();
        for (SuccessStorieDto ssd : lssd) {
            lss.add(ChangeDtoversSuccessStorie(ssd));
        }
        return lss;
    }

    public List<SuccessStorieDto> ChangeListSuccessStorieVersDto (List<SuccessStorie> lss){
        List<SuccessStorieDto> lssd = new ArrayList<SuccessStorieDto>();
        for (SuccessStorie ss : lss) {
            lssd.add(ChangeSuccessStorieVersDto(ss));
        }
        return lssd;
    }
}
