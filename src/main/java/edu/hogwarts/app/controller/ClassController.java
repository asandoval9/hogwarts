package edu.hogwarts.app.controller;

import edu.hogwarts.app.persistence.model.ClassEntity;
import edu.hogwarts.app.service.ClassService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/class")
public class ClassController {

    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping("/{id}")
    public ClassEntity get(@PathVariable Integer id) {
        return classService.getClassById(id);
    }

    @GetMapping(value = {"", "/"})
    public List<ClassEntity> list() {
        return classService.getAll();
    }

    @PutMapping(value = "/{id}")
    public ClassEntity update(@RequestBody ClassEntity clazz, @PathVariable Integer id) {
        ClassEntity classEntity = classService.getClassById(id);

        if (classEntity != null) {
            classEntity.setCode(clazz.getCode());
            classEntity.setTitle(clazz.getTitle());
            classEntity.setDescription(clazz.getDescription());

            return classService.save(classEntity);
        }

        return null;
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        classService.delete(id);
    }

}
