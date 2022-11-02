package mk.ukim.finki.wp.lab.bootstrap;

import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDataHolder {
    public static List<Student> studentList=new ArrayList<>();
    @PostConstruct
    public void init() {
        studentList.add(new Student("sfNN","12345","Stefan","Stosevski"));
        studentList.add(new Student("palosh","44231","Pavel","Kitanov"));
        studentList.add(new Student("shelbi","22111","Darko","Simov"));
        studentList.add(new Student("sulbminal","55331","Natan","Stosevski"));
        studentList.add(new Student("Mar1mg","44221","Mario","Petkovski"));
    }
}
