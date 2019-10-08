package com.imooc.entity;

import java.util.List;
import java.util.Map;

/**
 * Create by hza
 * 2019-10-08 15:07
 */
public class CourseMap {

    private Map<String,Course> courses ;

    public Map<String, Course> getCourses() {
        return courses;
    }

    public void setCourses(Map<String, Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "CourseMap{" +
                "courses=" + courses +
                '}';
    }
}
