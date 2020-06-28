package edu.hogwarts.app.integration;

import static org.assertj.core.api.Assertions.assertThat;

import edu.hogwarts.app.persistence.model.ClassEntity;
import edu.hogwarts.app.persistence.model.StudentEntity;
import edu.hogwarts.app.service.ClassService;
import edu.hogwarts.app.service.StudentService;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureTestEntityManager
@Transactional
public class HogwartsIntegrationTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ClassService classService;

    @Autowired
    private StudentService studentService;

    @Test
    public void testClassStudentManyToManyRelationship() {

        ClassEntity classA = new ClassEntity("MAGIC-105", "Advanced Potions", "History of potions");
        classService.save(classA);

        ClassEntity classB = new ClassEntity("MAGIC-106", "Ancient Studies", "History of ancient studies");
        classService.save(classB);

        ClassEntity classC = new ClassEntity("MAGIC-107", "Defence Against the Dark Arts", "Dark art defences");
        classService.save(classC);

        Set<ClassEntity> classes = new HashSet<>();
        classes.add(classA);
        classes.add(classB);
        classes.add(classC);

        StudentEntity ron = new StudentEntity("Ron", "Weasley");
        ron.setClasses(classes);
        studentService.save(ron);

        testEntityManager.flush();
        testEntityManager.clear();

        StudentEntity ronFound = studentService.getStudentById(ron.getId());

        assertThat(ronFound.getClasses()).hasSize(3);

    }

}
