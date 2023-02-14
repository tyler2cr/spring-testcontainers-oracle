package tyler2cr.spring.testcontainers.person;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tyler2cr.spring.testcontainers.TestContainersTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest extends TestContainersTest {

    @Autowired
    private PersonRepository personRepository;

    @BeforeEach
    void setUp() {
        personRepository.deleteAll();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createPerson() {
        Person expectedPerson = personRepository.save(Person
                .builder()
                .firstName("first_name")
                .lastName("last_name")
                .email("email")
                .build());

        Optional<Person> actualPersonOptional = personRepository.findById(expectedPerson.getId());
        assertTrue(actualPersonOptional.isPresent(),
                "Expected the person to exist in the database table");
        Person actualPerson = actualPersonOptional.get();
        assertEquals(expectedPerson.getFirstName(), actualPerson.getFirstName(),
                "Expected the person to have been created in the database table with a different first name");
    }
}