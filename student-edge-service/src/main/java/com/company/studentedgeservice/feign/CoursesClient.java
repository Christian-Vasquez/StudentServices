package com.company.studentedgeservice.feign;

import com.company.studentedgeservice.model.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FeignClient("student-service")
@RequestMapping("/courses")
public interface CoursesClient {

    @GetMapping( "/{id}")
    public Courses getCoursesById(@PathVariable int id);

    @GetMapping("")
    public List<Courses> getAllCourses();

    @PostMapping("")
    public Courses createCourse(@Valid @RequestBody Courses courses);

    @PutMapping("")
    public void updateCourse(@Valid @RequestBody Courses courses);

    @DeleteMapping("/{id}")
    public void deleteCourse(int id);

}
