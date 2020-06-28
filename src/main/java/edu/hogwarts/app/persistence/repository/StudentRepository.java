package edu.hogwarts.app.persistence.repository;

import edu.hogwarts.app.persistence.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

}
