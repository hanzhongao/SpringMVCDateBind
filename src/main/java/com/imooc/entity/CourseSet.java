package com.imooc.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Create by hza
 * 2019-10-08 15:07
 */
public class CourseSet {

    private Set<Course> courses = new HashSet<>();

    public CourseSet() {
        this.courses.add(new Course()) ;
        this.courses.add(new Course()) ;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
