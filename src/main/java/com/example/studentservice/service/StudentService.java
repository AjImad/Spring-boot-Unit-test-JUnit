package com.example.studentservice.service;

import com.example.studentservice.model.Course;
import com.example.studentservice.model.Student;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    private static final List<Student> students = new ArrayList<>();
    private final SecureRandom random = new SecureRandom();

    static {
        // Initialize Data
        Course courseOne = new Course("Course1", "Spring", "10 steps", Arrays.asList(
                "Learn Maven", "Import project", "First example", "Second Example"
        ));
        Course courseTwo = new Course(
                "course2", "Spring MVC", "10 EXAMPLES", Arrays.asList(
                "Learn Maven", "Import project", "First example", "Second Example"
        ));
        Course courseThree = new Course("course3", "Spring boo", "6k students", Arrays.asList(
                "Learn Maven", "Import project", "First example", "Second Example"
        ));
        Course courseFour = new Course("Course4", "Maven",
                "Most popular maven course on internet!", Arrays.asList("Pom.xml", "Build Life Cycle", "Parent POM",
                "Importing into Eclipse"));
        Student studentOne = new Student("stu1", "Imad", "Software engineer",
                new ArrayList<>(Arrays.asList(courseOne, courseTwo, courseThree, courseFour)));

        Student studentTwo = new Student("stu2", "Adib", "Software engineer",
                new ArrayList<>(Arrays.asList(courseOne, courseTwo, courseThree, courseFour)));

        students.add(studentOne);
        students.add(studentTwo);
    }

    public Student retrieveStudent(String studentId){
        for(Student student: students){
            if(student.getId().equals(studentId)){
                return student;
            }
        }
        return null;
    }

    public List<Course> retrieveCourses(String studentId) {
        Student student = retrieveStudent(studentId);
        System.out.println("Student: " + student);
        return student == null ? null : student.getCourses();
    }
}
