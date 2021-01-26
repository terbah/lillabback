package fr.lillab.lillab.dto;

import org.junit.Before;

public class DomaineDtoTest {

    private DomaineDto domaineDtoUnderTest;

    @Before
    public void setUp() {
        domaineDtoUnderTest = new DomaineDto("libelle");
    }
}
