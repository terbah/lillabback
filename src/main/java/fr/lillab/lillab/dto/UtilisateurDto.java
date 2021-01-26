package fr.lillab.lillab.dto;


import java.util.List;

public class UtilisateurDto {
    private Long idutilisateur;
    private String prenom, nom,email,description,liens,motdepasse;
    private List<DomaineDto> domaines;
    private List<CompetenceDto> competenceList;
    private LaboratoryDto laboratory;
    private TypeUtilisateurDto type;
    private byte[] image;
    private byte[] imagecouverture;

    public UtilisateurDto(Long idutilisateur, String prenom, String nom, String email, String description, String liens, String motdepasse, List<DomaineDto> domaines, List<CompetenceDto> competenceList, LaboratoryDto laboratory, TypeUtilisateurDto type, byte[] image, byte[] imagecouverture) {
        this.idutilisateur = idutilisateur;
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.description = description;
        this.liens = liens;
        this.motdepasse = motdepasse;
        this.domaines = domaines;
        this.competenceList = competenceList;
        this.laboratory = laboratory;
        this.type = type;
        this.image = image;
        this.imagecouverture = imagecouverture;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public fr.lillab.lillab.dto.TypeUtilisateurDto getType() {
        return type;
    }

    public void setType(fr.lillab.lillab.dto.TypeUtilisateurDto type) {
        this.type = type;
    }

    public UtilisateurDto() {
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public byte[] getImagecouverture() {
        return imagecouverture;
    }

    public void setImagecouverture(byte[] imagecouverture) {
        this.imagecouverture = imagecouverture;
    }

    public Long getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Long idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<DomaineDto> getDomaines() {
        return domaines;
    }

    public void setDomaines(List<DomaineDto> domaines) {
        this.domaines = domaines;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<fr.lillab.lillab.dto.CompetenceDto> getCompetenceList() {
        return competenceList;
    }

    public void setCompetenceList(List<fr.lillab.lillab.dto.CompetenceDto> competenceList) {
        this.competenceList = competenceList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLiens() {
        return liens;
    }

    public void setLiens(String liens) {
        this.liens = liens;
    }

    public fr.lillab.lillab.dto.LaboratoryDto getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(fr.lillab.lillab.dto.LaboratoryDto laboratory) {
        this.laboratory = laboratory;
    }
}
