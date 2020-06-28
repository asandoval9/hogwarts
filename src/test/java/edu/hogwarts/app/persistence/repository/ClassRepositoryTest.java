package edu.hogwarts.app.persistence.repository;

import static org.assertj.core.api.Assertions.assertThat;

import edu.hogwarts.app.persistence.model.ClassEntity;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ClassRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ClassRepository classRepository;

    @BeforeEach
    public void setup() {
        ClassEntity classEntity = new ClassEntity("MAGIC-101", "Intro to Magic", "History of Magic");

        testEntityManager.persistAndFlush(classEntity);
    }

    @Test
    public void whenFindById_thenReturnClass() {

        ClassEntity foundClass = classRepository.findById(1).orElse(null);

        assertThat(foundClass).isNotNull();
        assertThat(foundClass.getCode()).isEqualTo("MAGIC-101");
        assertThat(foundClass.getTitle()).isEqualTo("Intro to Magic");
        assertThat(foundClass.getDescription()).isEqualTo("History of Magic");
    }

    @Test
    public void whenFindAll_thenReturnClasses() {
        List<ClassEntity> classes = classRepository.findAll();

        assertThat(classes).hasSize(1);
    }

}
