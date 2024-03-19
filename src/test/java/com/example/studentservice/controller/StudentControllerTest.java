package com.example.studentservice.controller;

import com.example.studentservice.model.Course;
import com.example.studentservice.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    Course mockCourse = new Course("Course1", "Spring", "10 steps",
            Arrays.asList("Learn Maven", "First example", "Second example"));


    @Test
    public void retrieveCoursesForStudent() throws Exception {
        Mockito.when(
                studentService.retrieveCourse(Mockito.anyString(), Mockito.anyString())
        ).thenReturn(mockCourse);

        // Prepare Http get request for /students/Student1/courses/Course1 endpoint
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/students/stu1/courses/Course1")
                .accept(MediaType.APPLICATION_JSON);

        // Perform the Http get request
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println("result: " + result.getResponse().getContentAsString());

        // the expected result
//        String expected = "{\"id\":\"Course1\",\"name\":\"Spring\",\"description\":\"10 steps\"}";
        String expected = "{\"id\":\"Course1\",\"name\":\"Spring\",\"description\":\"10 steps\",\"steps\":[\"Learn Maven\",\"First example\",\"Second example\"]}";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
        // the false argument indicate the comparison should be lenient, meaning that the order of elements in arrays in not significant.
    }

}
