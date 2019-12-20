package controller;

import dao.StudentDao;
import model.Courses;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentDao studentDao;

    @GetMapping( "/{id}")
    public Student getStudentById(@PathVariable int id) throws IllegalArgumentException{
        return studentDao.getOne(id);
    }

    @GetMapping("")
    public List<Student> getAllStudents(){
        return studentDao.findAll();
    }

    @PostMapping("")
    public Student createStudent(@Valid @RequestBody Student student){
        return studentDao.save(student);
    }

    @PutMapping("")
    public void updateStudent(@Valid @RequestBody Student student){
        studentDao.save(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id){
        studentDao.deleteById(id);
    }

    @GetMapping("/courses/id")
    public List<Courses> getCoursesByStudentId(@PathVariable int id){ return studentDao.getCoursesByStudentId(id); }
}
