package edu.hogwarts.app.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import edu.hogwarts.app.persistence.model.ClassEntity;
import edu.hogwarts.app.service.ClassService;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ClassController.class)
public class ClassControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ClassService service;

    @Test
    public void canRetrieveByIdWhenExists() throws Exception {

        ClassEntity classEntity = new ClassEntity("MAGIC-101", "Intro to Magic", "History of Magic");

        given(service.getClassById(2))
                .willReturn(classEntity);

        mvc.perform(get("/class/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("code", is(classEntity.getCode())))
                .andExpect(jsonPath("title", is(classEntity.getTitle())))
                .andExpect(jsonPath("description", is(classEntity.getDescription())));

    }
    @Test
    public void canRetrieveAllClasses() throws Exception {

        ClassEntity classEntity = new ClassEntity("MAGIC-101", "Intro to Magic", "History of Magic");

        List<ClassEntity> allClasses = Collections.singletonList(classEntity);

        given(service.getAll()).willReturn(allClasses);

        mvc.perform(get("/class")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].code", is(classEntity.getCode())))
                .andExpect(jsonPath("$[0].title", is(classEntity.getTitle())))
                .andExpect(jsonPath("$[0].description", is(classEntity.getDescription())));
    }
}
