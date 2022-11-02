package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.StudentDataHolder;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    public List<Student> findAllStudents(){
        return StudentDataHolder.studentList;
    }
    public List<Student> findAllByNameOrSurname(String text){
        return StudentDataHolder.studentList.stream().filter(x->x.getName().contains(text)||x.getSurname().contains(text)).collect(Collectors.toList());
    }
    public Student saveStudent(String username, String password, String name, String surname){
        Student s=new Student(username,password,name,surname);
        StudentDataHolder.studentList.add(s);
        return s;
    }
    public Student findByUsername(String username){
        return StudentDataHolder.studentList.stream().filter(x->x.getUsername().equals(username)).findFirst().orElse(null);
    }
}
