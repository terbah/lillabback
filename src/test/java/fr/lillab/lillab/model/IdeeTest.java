package fr.lillab.lillab.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.sql.Date;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class IdeeTest {

    @Mock
    private Utilisateur mockUtilisateur;
    @Mock
    private Date mockDatecreation;
    @Mock
    private Date mockDatemodif;

    private Idee ideeUnderTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
        ideeUnderTest = new Idee(mockUtilisateur, "titre", "description", Arrays.asList(new Commentaire()), Arrays.asList(new Competence()), Arrays.asList(new Domaine()), mockDatecreation, mockDatemodif);
    }

    @Test
    void testGetImage() {
        // Setup

        // Run the test
        final byte[] result = ideeUnderTest.getImage();

        // Verify the results
        assertArrayEquals(new byte[]{(byte) 0b0}, result);
    }

    @Test
    void testToString() {
        // Setup
        when(mockUtilisateur.getEmail()).thenReturn("result");

        // Run the test
        final String result = ideeUnderTest.toString();

        // Verify the results
        assertEquals("result", result);
    }

    @Test
    void testEquals() {
        // Setup

        // Run the test
        final boolean result = ideeUnderTest.equals("o");

        // Verify the results
        assertTrue(result);
    }
}
