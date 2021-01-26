package fr.lillab.lillab.dto;

public class TypeUtilisateurDto {
    private String libelle;
    private int idtype;

    public TypeUtilisateurDto(String libelle) {
        this.libelle = libelle;
    }

    public TypeUtilisateurDto() {
    }

    public int getIdtype() {
        return idtype;
    }

    public void setIdtype(int idtype) {
        this.idtype = idtype;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
