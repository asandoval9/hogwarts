package edu.hogwarts.app.persistence.repository;

import static org.assertj.core.api.Assertions.assertThat;

import edu.hogwarts.app.persistence.model.StudentEntity;
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
public class StudentRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    public void setup() {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setFirstName("Harry");
        studentEntity.setLastName("Potter");

        testEntityManager.persistAndFlush(studentEntity);
    }

    @Test
    public void whenFindById_thenReturnStudent() {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setFirstName("Harry");
        studentEntity.setLastName("Potter");

        testEntityManager.persistAndFlush(studentEntity);

        StudentEntity foundStudent = studentRepository.findById(1).orElse(null);

        assertThat(foundStudent).isNotNull();
        assertThat(foundStudent.getFirstName()).isEqualTo(studentEntity.getFirstName());
        assertThat(foundStudent.getLastName()).isEqualTo(studentEntity.getLastName());
    }

    @Test
    public void whenFindAll_thenReturnStudents() {
        List<StudentEntity> students = studentRepository.findAll();

        assertThat(students).hasSize(1);
    }

}
