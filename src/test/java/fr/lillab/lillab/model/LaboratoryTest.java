package fr.lillab.lillab.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LaboratoryTest {

    private Laboratory laboratoryUnderTest;

    @BeforeEach
    void setUp() {
        laboratoryUnderTest = new Laboratory("designation");
    }

    @Test
    void testEquals() {
        // Setup

        // Run the test
        final boolean result = laboratoryUnderTest.equals("o");

        // Verify the results
        assertTrue(result);
    }
}
