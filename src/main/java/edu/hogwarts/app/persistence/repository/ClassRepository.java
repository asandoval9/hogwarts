package edu.hogwarts.app.persistence.repository;

import edu.hogwarts.app.persistence.model.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<ClassEntity, Integer> {

}
