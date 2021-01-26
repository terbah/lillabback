package fr.lillab.lillab.controller;

import fr.lillab.lillab.dto.IdeeDto;
import fr.lillab.lillab.model.*;
import fr.lillab.lillab.repository.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class IdeeControllerTest {

    @Mock
    private IdeeRepository mockIdeeRepository;
    @Mock
    private CompetenceRepository mockCompetenceRepository;
    @Mock
    private DomaineRepository mockDomaineRepository;
    @Mock
    private LaboratoryRepository mockLaboratoryRepository;
    @Mock
    private UtilisateurRepository mockUtilisateurRepository;

    @InjectMocks
    private IdeeController ideeControllerUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void testGetAllIdees() {
        // Setup

        // Configure IdeeRepository.findAllByOrderByDatecreationDesc(...).
        final List<Idee> idees = Arrays.asList(new Idee(new Utilisateur(), "titre", "description", Arrays.asList(new Commentaire()), Arrays.asList(new Competence()), Arrays.asList(new Domaine()), new Date(0L), new Date(0L)));
        when(mockIdeeRepository.findAllByOrderByDatecreationDesc()).thenReturn(idees);

        // Run the test
        final List<IdeeDto> result = ideeControllerUnderTest.getAllIdees();

        // Verify the results
    }

    @Test
    public void testGetAllIdeesByUtilisateur() {
        // Setup
        when(mockUtilisateurRepository.findByEmail("email")).thenReturn(new Utilisateur());

        // Configure IdeeRepository.findAllByUtilisateur(...).
        final List<Idee> idees = Arrays.asList(new Idee(new Utilisateur(), "titre", "description", Arrays.asList(new Commentaire()),
                Arrays.asList(new Competence()), Arrays.asList(new Domaine()), new Date(0L), new Date(0L)));
        when(mockIdeeRepository.findAllByUtilisateur(any(Utilisateur.class))).thenReturn(idees);

        // Run the test
        final List<IdeeDto> result = ideeControllerUnderTest.getAllIdeesByUtilisateur("email");

        // Verify the results
    }

    @Test
    public void testGetIdeesByCompetenceOrDomaine() {
        // Setup
        when(mockCompetenceRepository.findByLibelle("libelle")).thenReturn(new Competence());
        when(mockDomaineRepository.findByLibelle("libelle")).thenReturn(new Domaine());

        // Configure IdeeRepository.findAllByCompetenceListContainsOrDomaineListContains(...).
        final List<Idee> idees = Arrays.asList(new Idee(new Utilisateur(), "titre", "description", Arrays.asList(new Commentaire()), Arrays.asList(new Competence()), Arrays.asList(new Domaine()), new Date(0L), new Date(0L)));
        when(mockIdeeRepository.findAllByCompetenceListContainsOrDomaineListContains(eq(new Competence()), any(Domaine.class))).thenReturn(idees);

        // Run the test
        final List<IdeeDto> result = ideeControllerUnderTest.getIdeesByCompetenceOrDomaine("competence", "domaine");

        // Verify the results
    }

    @Test
    public void testGetDetailsIdee() {
        // Setup

        // Configure IdeeRepository.findAllByIdidee(...).
        final Idee idee = new Idee(new Utilisateur(), "titre", "description", Arrays.asList(new Commentaire()), Arrays.asList(new Competence()), Arrays.asList(new Domaine()), new Date(0L), new Date(0L));
        when(mockIdeeRepository.findAllByIdidee(0L)).thenReturn(idee);

        // Run the test
        final IdeeDto result = ideeControllerUnderTest.getDetailsIdee("idIdee");

        // Verify the results
    }

    @Test
    public void testAddIdea() {
        // Setup
        final Idee idea = new Idee(new Utilisateur(), "titre", "description", Arrays.asList(new Commentaire()), Arrays.asList(new Competence()), Arrays.asList(new Domaine()), new Date(0L), new Date(0L));
        when(mockCompetenceRepository.findByLibelle("libelle")).thenReturn(new Competence());
        when(mockDomaineRepository.findByLibelle("libelle")).thenReturn(new Domaine());

        // Configure IdeeRepository.save(...).
        final Idee idee = new Idee(new Utilisateur(), "titre", "description", Arrays.asList(new Commentaire()), Arrays.asList(new Competence()), Arrays.asList(new Domaine()), new Date(0L), new Date(0L));
        when(mockIdeeRepository.save(new Idee(new Utilisateur(), "titre", "description", Arrays.asList(new Commentaire()), Arrays.asList(new Competence()), Arrays.asList(new Domaine()), new Date(0L), new Date(0L)))).thenReturn(idee);

        // Run the test
        ideeControllerUnderTest.addIdea(idea);

        // Verify the results
    }

    @Test
    public void testUpdateIdeaPerUser() {
        // Setup
        final Idee ideaTomodify = new Idee(new Utilisateur(), "titre", "description", Arrays.asList(new Commentaire()), Arrays.asList(new Competence()), Arrays.asList(new Domaine()), new Date(0L), new Date(0L));

        // Configure IdeeRepository.findAllByIdidee(...).
        final Idee idee = new Idee(new Utilisateur(), "titre", "description", Arrays.asList(new Commentaire()), Arrays.asList(new Competence()), Arrays.asList(new Domaine()), new Date(0L), new Date(0L));
        when(mockIdeeRepository.findAllByIdidee(0L)).thenReturn(idee);

        when(mockCompetenceRepository.findByLibelle("libelle")).thenReturn(new Competence());
        when(mockDomaineRepository.findByLibelle("libelle")).thenReturn(new Domaine());

        // Configure IdeeRepository.save(...).
        final Idee idee1 = new Idee(new Utilisateur(), "titre", "description", Arrays.asList(new Commentaire()), Arrays.asList(new Competence()), Arrays.asList(new Domaine()), new Date(0L), new Date(0L));
        when(mockIdeeRepository.save(new Idee(new Utilisateur(), "titre", "description", Arrays.asList(new Commentaire()), Arrays.asList(new Competence()), Arrays.asList(new Domaine()), new Date(0L), new Date(0L)))).thenReturn(idee1);

        // Run the test
        ideeControllerUnderTest.updateIdeaPerUser(ideaTomodify);

        // Verify the results
    }

    @Test
    public void testDeleteIdeePerUser() {
        // Setup

        // Run the test
        ideeControllerUnderTest.deleteIdeePerUser("id");

        // Verify the results
        verify(mockIdeeRepository).deleteByIdidee(0L);
    }
}
