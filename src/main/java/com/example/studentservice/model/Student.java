package com.example.studentservice.model;

import java.util.List;

public class Student {

    private String id;
    private String name;
    private String description;
    private List<Course> courses;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    @Override
    public String toString(){
        return String.format(
                "Student[id=%s, name=%s, description=%s, courses=%s]"
                        , id, name, description, courses
        );
    }
}
