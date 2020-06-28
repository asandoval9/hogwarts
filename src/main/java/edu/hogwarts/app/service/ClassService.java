package edu.hogwarts.app.service;

import edu.hogwarts.app.persistence.model.ClassEntity;
import edu.hogwarts.app.persistence.repository.ClassRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ClassService {
    private final ClassRepository classRepository;

    public ClassService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    public ClassEntity getClassById(Integer id) {
        return classRepository.findById(id).orElse(null);
    }

    public List<ClassEntity> getAll() {
        return classRepository.findAll();
    }

    public ClassEntity save(ClassEntity classEntity) {
        return classRepository.save(classEntity);
    }

    public void delete(Integer id) {
        classRepository.deleteById(id);
    }

}
