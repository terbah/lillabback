package fr.lillab.lillab.services;

import fr.lillab.lillab.dto.DomaineDto;
import fr.lillab.lillab.dto.UtilisateurDto;
import fr.lillab.lillab.model.Domaine;
import fr.lillab.lillab.model.Utilisateur;
import fr.lillab.lillab.services.DomaineServiceChange;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurServiceChange {

    DomaineServiceChange domaineServiceChange= new DomaineServiceChange();
    CompetenceServiceChange competenceServiceChange=new CompetenceServiceChange();
    LaboratoryServiceChange laboratoryServiceChange = new LaboratoryServiceChange();
    TypeUtilisateurServiceChange typeUtilisateurServiceChange = new TypeUtilisateurServiceChange();
    public UtilisateurServiceChange() {
    }

    /*
        Changement d'un utilisateur vers un utilisateur DTO
         */
    public UtilisateurDto changeUtilisateurVersDto (Utilisateur c){
        return new UtilisateurDto(c.getIdutilisateur(),c.getPrenom(),c.getNom(),c.getEmail(),c.getDescription(),c.getLiens(),c.getMotdepasse(),domaineServiceChange.changeListDomaineVersDto(c.getDomaines())
                , competenceServiceChange.changeListCompetenceVersDto(c.getCompetenceList()),
                laboratoryServiceChange.changeLaboratoryVersDto(c.getLaboratory()),
                typeUtilisateurServiceChange.changeTypeUtilisateurVersDto(c.getType()),c.getImage(),c.getImagecouverture());
    }
    /*
    Changement d'un utilisateur DTO vers un Utilisateur Domaine
     */
    public Utilisateur changeDtoVersUtilisateur (UtilisateurDto c){
        Utilisateur user = new Utilisateur() ;
        //user.setDomaines((domaineServiceChange.changeListDtoVersDomaine(c.getDomaines())));
        user.setPrenom(c.getPrenom());
        user.setNom(c.getNom());
        return user;
    }

    /*
    Changement d'une liste d'utilisateur domaine vers une liste d'utilisateur Dto
     */
    public List<UtilisateurDto> changeListUtilisateurVersDto (List<Utilisateur> listUtilisateur){
        List<UtilisateurDto> listUtilisateurDto = new ArrayList<UtilisateurDto>();
        for (Utilisateur c : listUtilisateur)
            listUtilisateurDto.add(changeUtilisateurVersDto(c));
        return listUtilisateurDto;
    }

    public List<Utilisateur> changeListDtoVersUtilisateur (List<UtilisateurDto> listUtilisateurDto){
        List<Utilisateur> listUtilisateur = new ArrayList<Utilisateur>();
        for (UtilisateurDto c : listUtilisateurDto)
            listUtilisateur.add(changeDtoVersUtilisateur(c));
        return listUtilisateur;
    }


    public List<String> domainesToString(List<DomaineDto> ds){
        List<String> domainesString = new ArrayList<>();
        for (DomaineDto d : ds){
            domainesString.add(d.getLibelle());
        }
        return domainesString;
    }
}
