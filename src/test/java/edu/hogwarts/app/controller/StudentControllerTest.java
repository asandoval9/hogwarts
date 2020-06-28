package edu.hogwarts.app.controller;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import edu.hogwarts.app.persistence.model.StudentEntity;
import edu.hogwarts.app.service.StudentService;
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
@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private StudentService service;

    @Test
    public void canRetrieveByIdWhenExists() throws Exception {

        StudentEntity studentEntity = new StudentEntity("Harry", "Potter");

        given(service.getStudentById(2))
                .willReturn(new StudentEntity("Harry", "Potter"));

        mvc.perform(get("/student/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("firstName", is(studentEntity.getFirstName())))
                .andExpect(jsonPath("lastName", is(studentEntity.getLastName())));

    }
    @Test
    public void canRetrieveAllStudents() throws Exception {

        StudentEntity studentEntity = new StudentEntity("Harry", "Potter");

        List<StudentEntity> allStudents = Collections.singletonList(studentEntity);

        given(service.getAll()).willReturn(allStudents);

        mvc.perform(get("/student")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].firstName", is(studentEntity.getFirstName())))
                .andExpect(jsonPath("$[0].lastName", is(studentEntity.getLastName())));
    }

}
