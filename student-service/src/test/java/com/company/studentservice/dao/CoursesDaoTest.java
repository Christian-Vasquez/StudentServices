package com.company.studentservice.dao;

import dao.CoursesDao;
import model.Courses;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CoursesDaoTest {

    @Autowired
    CoursesDao coursesDao;

    @Before
    public void setUp(){
        List<Courses> coursesList = coursesDao.findAll();

        for(Courses courses: coursesList){
            coursesDao.deleteById(courses.getId());
        }
    }

    @Test
    public void shouldCreateCourse(){
        Courses courses = new Courses();
        courses.setName("n");
        courses.setScore(1);
        courses.setStudentId(1);

        coursesDao.save(courses);

        assert
    }
}
