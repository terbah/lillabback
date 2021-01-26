package fr.lillab.lillab.dto;

public class LaboratoryDto {

    private String designation;

    public LaboratoryDto(String designation) {
        this.designation = designation;
    }

    public LaboratoryDto() {
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
