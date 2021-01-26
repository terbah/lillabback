package fr.lillab.lillab.dto;

import java.sql.Date;
import java.util.List;

public class ProjetDto {

    List<CompetenceDto> competenceDtoList;
    List<DomaineDto> domaineDtos;
    private String description;
    private Date datecreation;
    private String titre;
    private byte[] image;
    private String budget;
    private Integer nbparticipants;
    private Date dateDebut;
    private Date dateFin;
    private Date dateModif;
    private Long idProjetDto;
    UtilisateurDto utilisateurDto = new UtilisateurDto();
    List<CommentaireDto> commentaireDtoList;
    CommentaireDto commentaireDto = new CommentaireDto();
    CompetenceDto competenceDto = new CompetenceDto();
    DomaineDto domaineDto = new DomaineDto();

    public ProjetDto(UtilisateurDto utilisateurDto, List<CompetenceDto> competenceDtoList,
                     List<DomaineDto> domaineDtos, String description, Date datecreation, byte[] image,Long idProjet) {
        this.utilisateurDto = utilisateurDto;
        this.competenceDtoList = competenceDtoList;
        this.domaineDtos = domaineDtos;
        this.description = description;
        this.datecreation = datecreation;
        this.image = image;
        this.idProjetDto = idProjet;
    }

    public ProjetDto() {
    }

    public UtilisateurDto getUtilisateurDto() {
        return utilisateurDto;
    }

    public void setUtilisateurDto(UtilisateurDto utilisateurDto) {
        this.utilisateurDto = utilisateurDto;
    }

    public List<CompetenceDto> getCompetenceDtoList() {
        return competenceDtoList;
    }

    public void setCompetenceDtoList(List<CompetenceDto> competenceDtoList) {
        this.competenceDtoList = competenceDtoList;
    }

    public List<DomaineDto> getDomaineDtos() {
        return domaineDtos;
    }

    public void setDomaineDtos(List<DomaineDto> domaineDtos) {
        this.domaineDtos = domaineDtos;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Long getIdProjetDto() {
        return idProjetDto;
    }

    public void setIdProjetDto(Long idProjetDto) {
        this.idProjetDto = idProjetDto;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public Integer getNbparticipants() {
        return nbparticipants;
    }

    public void setNbparticipants(Integer nbparticipants) {
        this.nbparticipants = nbparticipants;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Date getDateModif() {
        return dateModif;
    }

    public void setDateModif(Date dateModif) {
        this.dateModif = dateModif;
    }
}
