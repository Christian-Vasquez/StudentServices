package controller;

import dao.CoursesDao;
import model.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    CoursesDao coursesDao;

    @GetMapping( "/{id}")
    public Courses getCoursesById(@PathVariable int id){
        return coursesDao.getOne(id);
    }

    @GetMapping("")
    public List<Courses> getAllCourses(){
        return coursesDao.findAll();
    }

    @PostMapping("")
    public Courses createCourse(@Valid @RequestBody Courses courses){
        return coursesDao.save(courses);
    }

    @PutMapping("")
    public void updateCourse(@Valid @RequestBody Courses courses){
        coursesDao.save(courses);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(int id){
        coursesDao.deleteById(id);
    }
}
