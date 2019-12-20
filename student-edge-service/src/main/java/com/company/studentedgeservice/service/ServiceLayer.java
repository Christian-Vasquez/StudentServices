package com.company.studentedgeservice.service;

import com.company.studentedgeservice.feign.CoursesClient;
import com.company.studentedgeservice.feign.StudentClient;
import com.company.studentedgeservice.model.Courses;
import com.company.studentedgeservice.model.Student;
import com.company.studentedgeservice.model.StudentViewModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceLayer {


    StudentClient studentClient;

    CoursesClient coursesClient;

    public ServiceLayer(StudentClient studentClient, CoursesClient coursesClient) {
        this.studentClient = studentClient;
        this.coursesClient = coursesClient;
    }

    public StudentViewModel addStudent(StudentViewModel studentViewModel) {
        Student student = new Student();
        student.setFirstName(studentViewModel.getFirstName());
        student.setLastName(studentViewModel.getLastName());
        student = studentClient.createStudent(student);

        List<Courses> courses = new ArrayList<>();

        for (Courses c : studentViewModel.getCourses()) {
            c.setStudentId(student.getId());
            c = coursesClient.createCourse(c);
            courses.add(c);
        }

        StudentViewModel svm = new StudentViewModel();
        svm.setCourses(courses);
        svm.setId(student.getId());
        svm.setLastName(student.getLastName());
        svm.setFirstName(student.getFirstName());

        return svm;
    }

    public StudentViewModel getStudentById(int id) {
        return createStudentViewModel(studentClient.getStudentById(id));
    }

    private StudentViewModel createStudentViewModel(Student student) {
        StudentViewModel studentViewModel = new StudentViewModel();
        studentViewModel.setFirstName(student.getFirstName());
        studentViewModel.setLastName(student.getLastName());
        studentViewModel.setId(student.getId());
        List<Courses> courses = studentClient.getCoursesByStudentId(student.getId());
        studentViewModel.setCourses(courses);
        return studentViewModel;
    }
}
