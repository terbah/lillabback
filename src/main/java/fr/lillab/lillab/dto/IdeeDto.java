package fr.lillab.lillab.dto;

import fr.lillab.lillab.model.Idee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IdeeDto {
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    private Long idideeDto;
    private String description,titre;
    private Date dateCrea;
    private byte[] image;
    UtilisateurDto utilisateurDto = new UtilisateurDto();
    List<CommentaireDto> commentaireDtoList ;
    List<CompetenceDto> competenceDtoList ;
    List<DomaineDto> domaineDtos;
    List<PouceDto> unpouce;
    PouceDto pouceDto=new PouceDto();
    DomaineDto domaineDto = new DomaineDto() ;
    CompetenceDto competenceDto = new CompetenceDto() ;
    CommentaireDto commentaireDto = new CommentaireDto() ;


    public IdeeDto(String description, String titre,Date dateCrea, UtilisateurDto utilisateurDto
            ,List<CompetenceDto> competenceDtoList,List<DomaineDto> domaineDtos, byte[] image
            , List<CommentaireDto> commentaireDtoList
            , List<PouceDto> unpouce, Long idideeDto ) {
        this.description = description;
        this.titre = titre;
        this.utilisateurDto = utilisateurDto;
        this.competenceDtoList=competenceDtoList;
        this.domaineDtos=domaineDtos;
        this.dateCrea=dateCrea;
        this.idideeDto=idideeDto;
        this.commentaireDtoList=commentaireDtoList;
        this.unpouce=unpouce;
        this.image = image;
    }

    public IdeeDto() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public UtilisateurDto getUtilisateurDto() {
        return utilisateurDto;
    }

    public void setUtilisateurDto(UtilisateurDto utilisateurDto) {
        this.utilisateurDto = utilisateurDto;
    }

    public UtilisateurDto getUser() {
        return utilisateurDto;
    }

    public void setUser(UtilisateurDto user) {
        utilisateurDto = user;
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

    public Date getDateCrea() {
        return dateCrea;
    }

    public void setDateCrea(Date dateCrea) {
        this.dateCrea = dateCrea;
    }

    public List<CommentaireDto> getCommentaireDtoList() {
        return commentaireDtoList;
    }

    public void setCommentaireDtoList(List<CommentaireDto> commentaireDtoList) {
        this.commentaireDtoList = commentaireDtoList;
    }

    public List<PouceDto> getUnpouce() {
        return unpouce;
    }

    public void setUnpouce(List<PouceDto> unpouce) {
        this.unpouce = unpouce;
    }

    @Override
    public String toString() {
        return "IdeeDto{" +
                "description='" + description + '\'' +
                ", titre='" + titre + '\'' +
                ", dateCrea=" + dateCrea +
                ", utilisateurDto=" + utilisateurDto +
                ", commentaireDtoList=" + commentaireDtoList +
                ", competenceDtoList=" + competenceDtoList +
                ", domaineDtos=" + domaineDtos +
                ", unpouce=" + unpouce +
                ", pouceDto=" + pouceDto +
                ", domaineDto=" + domaineDto +
                ", competenceDto=" + competenceDto +
                ", commentaireDto=" + commentaireDto +
                '}';
    }

    public Long getIdideeDto() {
        return idideeDto;
    }

    public void setIdideeDto(Long idideeDto) {
        this.idideeDto = idideeDto;
    }
}
