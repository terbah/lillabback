package fr.lillab.lillab.services;

import fr.lillab.lillab.dto.CompetenceDto;
import fr.lillab.lillab.dto.DomaineDto;
import fr.lillab.lillab.dto.ProjetDto;
import fr.lillab.lillab.dto.UtilisateurDto;
import fr.lillab.lillab.model.Competence;
import fr.lillab.lillab.model.Domaine;
import fr.lillab.lillab.model.Projet;
import fr.lillab.lillab.model.Utilisateur;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProjetServiceChangeTest {

    private ProjetServiceChange projetServiceChangeUnderTest;

    @Before
    public void setUp() {
        projetServiceChangeUnderTest = new ProjetServiceChange();
        projetServiceChangeUnderTest.utilisateurServiceChange = mock(UtilisateurServiceChange.class);
        projetServiceChangeUnderTest.competenceServiceChange = mock(CompetenceServiceChange.class);
        projetServiceChangeUnderTest.domaineServiceChange = mock(DomaineServiceChange.class);
    }

    @Test
    public void testChangeDtoVersProjet() {
        // Setup
        final ProjetDto projetDto = null;
        //final ProjetDto projetDto = new ProjetDto(0L, new UtilisateurDto("prenom", "nom", "email", Arrays.asList(new DomaineDto("libelle"))), Arrays.asList(new CompetenceDto("libelle")), Arrays.asList(new DomaineDto("libelle")), "description", new Date(0L), new Date(0L), new Date(0L), new Date(0L), new Date(0L), 0, "budget", "titre");
        when(projetServiceChangeUnderTest.utilisateurServiceChange.changeDtoVersUtilisateur(any(UtilisateurDto.class))).thenReturn(new Utilisateur());
        when(projetServiceChangeUnderTest.competenceServiceChange.changeListCompetenceDtoVersComp(Arrays.asList(new CompetenceDto("libelle")))).thenReturn(Arrays.asList(new Competence()));
        when(projetServiceChangeUnderTest.domaineServiceChange.changeListDtoVersDomaine(Arrays.asList(new DomaineDto("libelle")))).thenReturn(Arrays.asList(new Domaine()));

        // Run the test
        final Projet result = projetServiceChangeUnderTest.changeDtoVersProjet(projetDto);
        final Projet expectedResult = result;

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testChangeProjetVersDto() {
        // Setup
        final Projet projet = new Projet();

        // Configure UtilisateurServiceChange.changeUtilisateurVersDto(...).
        //final UtilisateurDto utilisateurDto = new UtilisateurDto("prenom", "nom", "email", Arrays.asList(new DomaineDto("libelle")));
        final UtilisateurDto utilisateurDto = null;
        when(projetServiceChangeUnderTest.utilisateurServiceChange.changeUtilisateurVersDto(any(Utilisateur.class))).thenReturn(utilisateurDto);

        // Configure CompetenceServiceChange.changeListCompetenceVersDto(...).
        final List<CompetenceDto> competenceDtos = Arrays.asList(new CompetenceDto("libelle"));
        when(projetServiceChangeUnderTest.competenceServiceChange.changeListCompetenceVersDto(Arrays.asList(new Competence()))).thenReturn(competenceDtos);

        when(projetServiceChangeUnderTest.domaineServiceChange.changeListDomaineVersDto(Arrays.asList(new Domaine()))).thenReturn(Arrays.asList(new DomaineDto("libelle")));

        // Run the test
        final ProjetDto result = projetServiceChangeUnderTest.changeProjetVersDto(projet);

        // Verify the results
    }

    @Test
    public void testChangeListDtoVersProjet() {
        // Setup
       // final List<ProjetDto> listProjetDto = Arrays.asList(new ProjetDto(0L, new UtilisateurDto("prenom", "nom", "email", Arrays.asList(new DomaineDto("libelle"))), Arrays.asList(new CompetenceDto("libelle")), Arrays.asList(new DomaineDto("libelle")), "description", new Date(0L), new Date(0L), new Date(0L), new Date(0L), new Date(0L), 0, "budget", "titre"));
        final List<Projet> expectedResult = Arrays.asList(new Projet());
        when(projetServiceChangeUnderTest.utilisateurServiceChange.changeDtoVersUtilisateur(any(UtilisateurDto.class))).thenReturn(new Utilisateur());
        when(projetServiceChangeUnderTest.competenceServiceChange.changeListCompetenceDtoVersComp(Arrays.asList(new CompetenceDto("libelle")))).thenReturn(Arrays.asList(new Competence()));
        when(projetServiceChangeUnderTest.domaineServiceChange.changeListDtoVersDomaine(Arrays.asList(new DomaineDto("libelle")))).thenReturn(Arrays.asList(new Domaine()));

        // Run the test
        //final List<Projet> result = projetServiceChangeUnderTest.changeListDtoVersProjet(listProjetDto);
        final List<Projet> result = null;
        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testChangeListProjetVersDto() {
        // Setup
        final List<Projet> listProjet = Arrays.asList(new Projet());

        // Configure UtilisateurServiceChange.changeUtilisateurVersDto(...).
        //final UtilisateurDto utilisateurDto = new UtilisateurDto("prenom", "nom", "email", Arrays.asList(new DomaineDto("libelle")));
        final UtilisateurDto utilisateurDto = null;
        when(projetServiceChangeUnderTest.utilisateurServiceChange.changeUtilisateurVersDto(any(Utilisateur.class))).thenReturn(utilisateurDto);

        // Configure CompetenceServiceChange.changeListCompetenceVersDto(...).
        final List<CompetenceDto> competenceDtos = Arrays.asList(new CompetenceDto("libelle"));
        when(projetServiceChangeUnderTest.competenceServiceChange.changeListCompetenceVersDto(Arrays.asList(new Competence()))).thenReturn(competenceDtos);

        when(projetServiceChangeUnderTest.domaineServiceChange.changeListDomaineVersDto(Arrays.asList(new Domaine()))).thenReturn(Arrays.asList(new DomaineDto("libelle")));

        // Run the test
        final List<ProjetDto> result = projetServiceChangeUnderTest.changeListProjetVersDto(listProjet);

        // Verify the results
    }
}
