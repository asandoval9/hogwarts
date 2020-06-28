package edu.hogwarts.app.service;

import edu.hogwarts.app.persistence.model.StudentEntity;
import edu.hogwarts.app.persistence.repository.StudentRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentEntity getStudentById(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    public List<StudentEntity> getAll() {
        return studentRepository.findAll();
    }

    public StudentEntity save(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }

}
