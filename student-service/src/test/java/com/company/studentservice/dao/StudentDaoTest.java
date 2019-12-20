package com.company.studentservice.dao;

import dao.StudentDao;
import model.Student;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    
}
