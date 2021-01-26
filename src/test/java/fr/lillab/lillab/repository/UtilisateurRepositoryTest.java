package fr.lillab.lillab.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import fr.lillab.lillab.model.Utilisateur;

@RunWith(SpringRunner.class)
@DataJpaTest
class UtilisateurRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Test
	public void whenFindByName_thenReturnEmployee() {
		// given
		Utilisateur u = new Utilisateur();
		u.setEmail("Hamadi@gmail.com");
		entityManager.persist(u);
		entityManager.flush();

		// when
		Utilisateur found = utilisateurRepository.findByEmail(u.getEmail());
		
		assertEquals(found.getEmail(), u.getEmail());

		// then
		assertThat(found.getEmail()).isEqualTo(u.getEmail());
	}

}
