package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.repository.CourseRepository;
import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final StudentService studentService;
    public CourseServiceImpl(CourseRepository courseRepository, StudentService studentService){
        this.courseRepository=courseRepository;
        this.studentService=studentService;
    }

    @Override
    public List<Student> listStudentsByCourse(Long courseId) {
        return courseRepository.findAllStudentsByCourse(courseId);
    }

    @Override
    public Course addStudentInCourse(String username, Long courseId) {
        Student s=studentService.searchByUsername(username);
        Course c=courseRepository.findById(courseId);
        courseRepository.addStudentToCourse(s,c);
        return c;
    }

    @Override
    public List<Course> listAllCourses() {
        return courseRepository.findAllCourses();
    }

    @Override
    public String getCourseNameById(Long courseId) {
        return courseRepository.findById(courseId).getName();
    }
}
