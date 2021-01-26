package fr.lillab.lillab.services;

import fr.lillab.lillab.dto.TypeUtilisateurDto;
import fr.lillab.lillab.model.TypeUtilisateur;

import java.util.ArrayList;
import java.util.List;

public class TypeUtilisateurServiceChange {

    /*
          Changement d'une liste de typeDto vers une liste de type
           */
    public List<TypeUtilisateur> changeListDtoVersTypeUtilisateur(List<TypeUtilisateurDto> listTypeUtilisateurDto) {
        List<TypeUtilisateur> listTypeUtilisateur = new ArrayList<TypeUtilisateur>();
        for (TypeUtilisateurDto c : listTypeUtilisateurDto) {
            TypeUtilisateur tu = new TypeUtilisateur();
            tu.setIdtype(c.getIdtype());
            tu.setLibelle(c.getLibelle());
            listTypeUtilisateur.add(tu);
        }
        return listTypeUtilisateur;
    }

    /*
    Changement d'une liste de type vers une liste de typeDto
     */
    public List<TypeUtilisateurDto> changeListTypeUtilisateurVersDto(List<TypeUtilisateur> listTypeUtilisateur) {
        List<TypeUtilisateurDto> listTypeUtilisateurDto = new ArrayList<TypeUtilisateurDto>();
        for (TypeUtilisateur c : listTypeUtilisateur) {
            TypeUtilisateurDto typeUtilisateurDto = new TypeUtilisateurDto();
            typeUtilisateurDto.setLibelle(c.getLibelle());
            typeUtilisateurDto.setIdtype(c.getIdtype());
            listTypeUtilisateurDto.add(typeUtilisateurDto);
        }
        return listTypeUtilisateurDto;
    }

    /*
   Changement d'un typeDto vers un type
    */
    public TypeUtilisateur changeDtoVersTypeUtilisateur(TypeUtilisateurDto c) {

        TypeUtilisateur tu = new TypeUtilisateur();
        tu.setLibelle(c.getLibelle());
        tu.setIdtype(c.getIdtype());

        return tu;
    }

    /*
    Changement d'un type vers un typeDto
     */
    public TypeUtilisateurDto changeTypeUtilisateurVersDto(TypeUtilisateur c) {

        TypeUtilisateurDto typeUtilisateurDto = new TypeUtilisateurDto();
        typeUtilisateurDto.setLibelle(c.getLibelle());
        typeUtilisateurDto.setIdtype(c.getIdtype());

        return typeUtilisateurDto;
    }
}
