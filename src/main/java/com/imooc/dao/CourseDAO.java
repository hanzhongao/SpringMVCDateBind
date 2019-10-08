package com.imooc.dao;

import com.imooc.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by hza
 * 2019-10-08 14:56
 */
@Repository
public class CourseDAO {
    Map<Integer,Course> map = new HashMap<>() ;
    public void add(Course course) {
        map.put(course.getId(), course) ;
    }

    public Collection<Course> getAll() {
        return this.map.values() ;
    }
}
