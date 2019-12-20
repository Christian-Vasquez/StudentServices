package com.company.studentedgeservice.controller;

import com.company.studentedgeservice.model.StudentViewModel;
import com.company.studentedgeservice.service.ServiceLayer;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentEdgeServiceController {

    private ServiceLayer serviceLayer;

    @PostMapping("/students")
    public StudentViewModel addStudent(@RequestBody StudentViewModel studentViewModel) {
        return serviceLayer.addStudent(studentViewModel);
    }

    @GetMapping("/student/{id}")
    public StudentViewModel getStudentById(@PathVariable int id) {
        return serviceLayer.getStudentById(id);
    }

}
