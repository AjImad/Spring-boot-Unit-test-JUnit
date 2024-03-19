package com.example.studentservice.controller;

import com.example.studentservice.model.Course;
import com.example.studentservice.model.Student;
import com.example.studentservice.service.StudentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{studentId}/courses")
    public List<Course> retrieveCoursesForStudent(@PathVariable String studentId){
        return studentService.retrieveCourses(studentId);
    }

    @GetMapping("/{studentId}/courses/{courseId}")
    public Course retrieveDetailsForCourse(@PathVariable String studentId, @PathVariable String courseId){
        return studentService.retrieveCourse(studentId, courseId);
    }

    @PostMapping("/{studentId}/courses")
    public ResponseEntity<Void> registerStudentForCourse(
            @PathVariable String studentId, @RequestBody Course course
    ){
        Course newCourse = studentService.addCourse(studentId, course);

        if(newCourse == null)
            return ResponseEntity.noContent().build();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(newCourse.getId())
                .toUri();

        return ResponseEntity.created(location)
                .build();
    }
}
