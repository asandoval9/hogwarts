package edu.hogwarts.app.controller;

import edu.hogwarts.app.persistence.model.StudentEntity;
import edu.hogwarts.app.service.StudentService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public StudentEntity get(@PathVariable Integer id) {
        return studentService.getStudentById(id);
    }

    @GetMapping(value = {"", "/"})
    public List<StudentEntity> list() {
        return studentService.getAll();
    }

    @PutMapping(value = "/{id}")
    public StudentEntity update(@RequestBody StudentEntity student, @PathVariable Integer id) {
        StudentEntity studentEntity = studentService.getStudentById(id);

        if (studentEntity != null) {
            studentEntity.setFirstName(student.getFirstName());
            studentEntity.setLastName(student.getLastName());

            return studentService.save(studentEntity);
        }

        return null;
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        studentService.delete(id);
    }

}
