package com.company.studentservice.dao;

import dao.StudentDao;
import model.Student;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
public class StudentDaoTest {

    @Autowired
    StudentDao studentDao;

    @Before
    public void setUp(){
        List<Student> studentList = studentDao.findAll();

        for(Student student: studentList){
            studentDao.deleteById(student.getId());
        }
    }

    @Test
    public void  createGetGetAllDeleteStudentTest(){
        Student student = new Student();
        student.setFirstName("f");
        student.setLastName("l");

        studentDao.save(student);

        assertEquals(student, studentDao.getOne(student.getId()));
        studentDao.deleteById(student.getId());
        assertEquals(0,studentDao.findAll().size());
    }
}
