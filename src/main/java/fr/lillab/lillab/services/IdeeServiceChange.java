package fr.lillab.lillab.services;

import fr.lillab.lillab.dto.IdeeDto;
import fr.lillab.lillab.model.Idee;
import java.util.ArrayList;
import java.util.List;

public class IdeeServiceChange {
    UtilisateurServiceChange utilisateurServiceChange= new UtilisateurServiceChange();
    CommentaireServiceChange commentaireServiceChange= new CommentaireServiceChange();
    DomaineServiceChange domaineServiceChange= new DomaineServiceChange();
    CompetenceServiceChange competenceServiceChange= new CompetenceServiceChange();
    PouceServiceChange pouceServiceChange= new PouceServiceChange();

    /*
    Changement d'une idee domaine vers une idee Dto
     */
    public IdeeDto changeIdeeVersDto (Idee idee){
        IdeeDto ideeDto =  new IdeeDto();
        ideeDto.setIdideeDto(idee.getIdidee());
        ideeDto.setDescription(idee.getDescription());
        ideeDto.setTitre(idee.getTitre());
        ideeDto.setDateCrea(idee.getDatecreation());
        ideeDto.setImage(idee.getImage());
        ideeDto.setCommentaireDtoList(commentaireServiceChange.changeListCommentaireVersDto(idee.getCommentaireList()));
        ideeDto.setCompetenceDtoList(competenceServiceChange.changeListCompetenceVersDto(idee.getCompetenceList()));
        ideeDto.setUser(utilisateurServiceChange.changeUtilisateurVersDto(idee.getUtilisateur()));
        ideeDto.setDomaineDtos(domaineServiceChange.changeListDomaineVersDto(idee.getDomaineList()));
        ideeDto.setUnpouce(pouceServiceChange.changeListPouceVersDto(idee.getPouceListe()));
        return ideeDto;
    }
    /*
   Changement d'une ideeDto vers une idee
    */
    public Idee changeDtoVersIdee (IdeeDto ideeDto){
        Idee idee =  new Idee();
        idee.setIdidee(ideeDto.getIdideeDto());
        idee.setDescription(ideeDto.getDescription());
        idee.setTitre(ideeDto.getTitre());
        ideeDto.setImage(idee.getImage());
      //  idee.setCommentaireList(commentaireServiceChange.changeListDtoComVersCommentaire(ideeDto.getCommentaireDtoList()));
        idee.setCompetenceList(competenceServiceChange.changeListCompetenceDtoVersComp(ideeDto.getCompetenceDtoList()));
        idee.setUtilisateur(utilisateurServiceChange.changeDtoVersUtilisateur(ideeDto.getUser()));
        idee.setDomaineList(domaineServiceChange.changeListDtoVersDomaine(ideeDto.getDomaineDtos()));
      //  idee.setLikeListe(pouceServiceChange.changeListDtoVersPouce(ideeDto.getUnpouce()));
        return idee;

    }
    /*
    Changement d'une liste d'idee Domaine vers une liste d'ideeDto
     */
    public List<IdeeDto> changeListIdeeVersDto (List<Idee> listIdee){
        List<IdeeDto> listIdeeDto = new ArrayList<IdeeDto>();
        for (Idee idee : listIdee) {
            listIdeeDto.add(changeIdeeVersDto(idee));
        }
        return listIdeeDto;
    }
    /*
  Changement d'une liste d'ideeDto vers une liste d'idee domaine
   */
    public List<Idee> changeListDtoVersIdee (List<IdeeDto> listIdeeDto){
        List<Idee> listIdee = new ArrayList<Idee>();
        for (IdeeDto idee : listIdeeDto) {
            listIdee.add(changeDtoVersIdee(idee));
        }
        return listIdee;
    }
}
