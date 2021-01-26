package fr.lillab.lillab.dto;

import org.junit.Before;
import org.mockito.Mock;

import java.sql.Date;
import java.util.Arrays;

import static org.mockito.MockitoAnnotations.initMocks;

public class ProjetDtoTest {

    @Mock
    private UtilisateurDto mockUtilisateurDto;
    @Mock
    private Date mockDateModif;
    @Mock
    private Date mockDatecreation;
    @Mock
    private Date mockDatedebut;
    @Mock
    private Date mockDatefin;
    @Mock
    private Date mockDatemodif;

    private ProjetDto projetDtoUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
        //projetDtoUnderTest = new ProjetDto(0L, mockUtilisateurDto, Arrays.asList(new CompetenceDto("libelle")), Arrays.asList(new DomaineDto("libelle")), "description", mockDateModif, mockDatecreation, mockDatedebut, mockDatefin, mockDatemodif, 0, "budget", "titre");
    }
}
