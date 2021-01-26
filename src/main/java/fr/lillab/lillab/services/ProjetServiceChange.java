package fr.lillab.lillab.services;

import fr.lillab.lillab.dto.ProjetDto;
import fr.lillab.lillab.model.Projet;

import java.util.ArrayList;
import java.util.List;

public class ProjetServiceChange {

    UtilisateurServiceChange utilisateurServiceChange = new UtilisateurServiceChange();
    CompetenceServiceChange competenceServiceChange = new CompetenceServiceChange();
    DomaineServiceChange domaineServiceChange = new DomaineServiceChange();

    /*
  Changement d'un projetDto vers un projet
   */
    public Projet changeDtoVersProjet(ProjetDto projetDto) {
        Projet projet = new Projet();
        projet.setUtilisateur(utilisateurServiceChange.changeDtoVersUtilisateur(projetDto.getUtilisateurDto()));
        projet.setCompetencesList(competenceServiceChange.changeListCompetenceDtoVersComp(projetDto.getCompetenceDtoList()));
        projet.setDomainesList(domaineServiceChange.changeListDtoVersDomaine(projetDto.getDomaineDtos()));
        projet.setDateCreation(projetDto.getDatecreation());
        projet.setDescription(projetDto.getDescription());
        projet.setImage(projetDto.getImage());
        projet.setDateDebut(projetDto.getDateDebut());
        projet.setDateFin(projetDto.getDateFin());
        projet.setBudget(projetDto.getBudget());
        return projet;

    }

    /*
    Changement d'un projet domaine vers un projetDto
     */
    public ProjetDto changeProjetVersDto(Projet projet) {
        ProjetDto projetDto = new ProjetDto();
        projetDto.setIdProjetDto(projet.getIdProjet());
        projetDto.setUtilisateurDto(utilisateurServiceChange.changeUtilisateurVersDto(projet.getUtilisateur()));
        projetDto.setCompetenceDtoList(competenceServiceChange.changeListCompetenceVersDto(projet.getCompetencesList()));
        projetDto.setDomaineDtos(domaineServiceChange.changeListDomaineVersDto(projet.getDomainesList()));
        projetDto.setDatecreation(projet.getDateCreation());
        projetDto.setDescription(projet.getDescription());
        projetDto.setImage(projet.getImage());
        projetDto.setTitre(projet.getTitre());
        projetDto.setBudget(projet.getBudget());
        projetDto.setDateDebut(projet.getDateDebut());
        projetDto.setDateFin(projet.getDateFin());
        projetDto.setDateModif(projet.getDateModif());
        projetDto.setNbparticipants(projet.getNbparticipants());
        return projetDto;

    }

    /*
   Changement d'une liste projet vers une liste projetDto
    */
    public List<Projet> changeListDtoVersProjet(List<ProjetDto> listProjetDto) {
        List<Projet> listProjet = new ArrayList<Projet>();
        for (ProjetDto projet : listProjetDto) {
            listProjet.add(changeDtoVersProjet(projet));
        }
        return listProjet;
    }

    /*
    Changement d'un projetDto vers un projet domaine
     */
    public List<ProjetDto> changeListProjetVersDto(List<Projet> listProjet) {
        List<ProjetDto> listProjetDto = new ArrayList<ProjetDto>();
        for (Projet projet : listProjet) {
            listProjetDto.add(changeProjetVersDto(projet));
        }
        return listProjetDto;
    }
}
