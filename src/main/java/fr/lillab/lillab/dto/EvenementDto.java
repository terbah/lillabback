package fr.lillab.lillab.dto;

import java.util.Date;
import java.util.List;

public class EvenementDto {
    private Long idEventDto;
    private String lieudto, titredto, descriptiondto;
    private Date datedto;
    UtilisateurDto utilisateurDto = new UtilisateurDto();

    private Long cptParticipeDto;
    private Long cptParticipePasDto;
    private Long cptInteresseDto;


    public EvenementDto(Long idEventDto, String lieudto, String titredto, String descriptiondto, Date datedto,  UtilisateurDto utilisateurDto,
                        Long cptParticipeDto, Long cptParticipePasDto, Long cptInteresseDto) {

        this.idEventDto = idEventDto;
        this.lieudto = lieudto;
        this.titredto = titredto;
        this.descriptiondto = descriptiondto;
        this.datedto = datedto;
        this.utilisateurDto=utilisateurDto;

        this.cptParticipeDto=cptParticipeDto;
        this.cptParticipePasDto=cptParticipePasDto;
        this.cptInteresseDto=cptInteresseDto;
    }

    public EvenementDto() {
    }

    public String getLieu() {
        return lieudto;
    }

    public void setLieu(String lieudto) {
        this.lieudto = lieudto;
    }

    public String getDescription() {
        return descriptiondto;
    }

    public void setDescription(String descriptiondto) {
        this.descriptiondto = descriptiondto;
    }

    public Date getDate() {
        return datedto;
    }

    public void setDate(Date datedto) {
        this.datedto = datedto;
    }

    public UtilisateurDto getUtilisateurDto() {
        return utilisateurDto;
    }

    public void setUtilisateurDto(UtilisateurDto utilisateurDto) {
        this.utilisateurDto = utilisateurDto;
    }

    public Long getIdEvent() {
        return idEventDto;
    }

    public void setIdEvent(Long idEventDto) {
        this.idEventDto = idEventDto;
    }

    public String getTitre() {
        return titredto;
    }

    public void setTitre(String titredto) {
        this.titredto = titredto;
    }

    public Long getCptParticipeDto() {
        return cptParticipeDto;
    }

    public void setCptParticipeDto(Long cptParticipeDto) {
        this.cptParticipeDto = cptParticipeDto;
    }

    public Long getCptParticipePasDto() {
        return cptParticipePasDto;
    }

    public void setCptParticipePasDto(Long cptParticipePasDto) {
        this.cptParticipePasDto = cptParticipePasDto;
    }

    public Long getCptInteresseDto() {
        return cptInteresseDto;
    }

    public void setCptInteresseDto(Long cptInteresseDto) {
        this.cptInteresseDto = cptInteresseDto;
    }
}
