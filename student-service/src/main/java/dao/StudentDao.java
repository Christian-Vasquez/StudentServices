package dao;

import model.Courses;
import model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {
    List<Courses> getCoursesByStudentId(int id);
}
