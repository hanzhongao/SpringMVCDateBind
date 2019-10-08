package com.imooc.controller;

import com.imooc.dao.CourseDAO;
import com.imooc.entity.Course;
import com.imooc.entity.CourseList;
import com.imooc.entity.CourseMap;
import com.imooc.entity.CourseSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Create by hza
 * 2019-10-08 14:12
 */
@Controller
public class DateBindController {

    @Autowired
    private CourseDAO courseDAO ;

    @RequestMapping(value = "/baseType")
    @ResponseBody
    public String baseType(@RequestParam("id") int id) {
        return "id:" + id ;
    }

    @RequestMapping(value = "/packageType")
    @ResponseBody
    public String packageType(@RequestParam("id") Integer id) {
        return "id:" + id ;
    }

    @RequestMapping("/arrType")
    @ResponseBody
    public String arrType(String[] name) {
        StringBuffer buffer = new StringBuffer() ;
        for(String temp : name) {
            buffer.append(temp).append(" ");
        }
        return "arr:" + buffer;
    }

    @RequestMapping("/pojoType")
    public ModelAndView pojoType(Course course) {
        this.courseDAO.add(course);
        ModelAndView modelAndView = new ModelAndView() ;
        modelAndView.addObject("courses",this.courseDAO.getAll()) ;
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/listType")
    public ModelAndView listType(CourseList courses) {

        for (Course course : courses.getCourses()) {
            this.courseDAO.add(course);
        }

        ModelAndView modelAndView = new ModelAndView() ;
        modelAndView.addObject("courses",this.courseDAO.getAll()) ;
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/mapType")
    public ModelAndView mapType(CourseMap courses) {
//        for(Course course : courses.getCourses().values()) {
//            System.out.println(course);
//            this.courseDAO.add(course);
//        }

        for (String key : courses.getCourses().keySet()) {
            Course course = courses.getCourses().get(key) ;
            this.courseDAO.add(course);
        }

        ModelAndView modelAndView = new ModelAndView() ;
        modelAndView.addObject("courses",this.courseDAO.getAll()) ;
        modelAndView.setViewName("index");
        return modelAndView ;
    }

    @RequestMapping("/setType")
    public ModelAndView setType(CourseSet courses) {

        for (Course course : courses.getCourses()) {
            this.courseDAO.add(course);
        }


        ModelAndView modelAndView = new ModelAndView() ;
        modelAndView.addObject("courses",this.courseDAO.getAll()) ;
        modelAndView.setViewName("index");
        return modelAndView ;
    }

    @RequestMapping("/jsonType")
    @ResponseBody
    public Course jsonType(@RequestBody Course course) {
        course.setPrice(course.getPrice() + 100);
        return course ;
    }
}
