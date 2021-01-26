package fr.lillab.lillab.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilisateurTest {

    private Utilisateur utilisateurUnderTest;

    @BeforeEach
    void setUp() {
        utilisateurUnderTest = new Utilisateur();
    }

    @Test
    void testToString() {
        // Setup

        // Run the test
        final String result = utilisateurUnderTest.toString();

        // Verify the results
        assertEquals("result", result);
    }
}
