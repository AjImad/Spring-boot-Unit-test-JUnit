package com.example.studentservice.controller;

import com.example.studentservice.model.Course;
import com.example.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
