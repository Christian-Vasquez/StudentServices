package com.company.studentedgeservice.feign;

import com.company.studentedgeservice.model.Courses;
import com.company.studentedgeservice.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FeignClient("student-service")
@RequestMapping("/student")
public interface StudentClient {

    @GetMapping( "/{id}")
    public Student getStudentById(@PathVariable int id);

    @GetMapping("")
    public List<Student> getAllStudents();

    @PostMapping("")
    public Student createStudent(@Valid @RequestBody Student student);

    @PutMapping("")
    public void updateStudent(@Valid @RequestBody Student student);

    @DeleteMapping("/{id}")
    public void deleteStudent(int id);

    @GetMapping("/courses/id")
    public List<Courses> getCoursesByStudentId(@PathVariable int id);
}

