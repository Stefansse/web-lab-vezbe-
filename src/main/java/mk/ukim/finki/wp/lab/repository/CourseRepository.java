package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.CourseDataHolder;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepository {
    public List<Course> findAllCourses(){
        return CourseDataHolder.courseList;
    }
    public Course findById(Long courseId){
        return CourseDataHolder.courseList.stream().filter(x->x.getCourseId()==courseId).findFirst().orElse(null);
    }
    public List<Student> findAllStudentsByCourse(Long courseId){
        Course c=CourseDataHolder.courseList.stream().filter(x->x.getCourseId()==courseId).findFirst().orElse(null);
        if(c!=null)
            return c.getStudents();
        return new ArrayList<>();
    }
    public Course addStudentToCourse(Student student, Course course){
        course.getStudents().add(student);
        return course;
    }
}
