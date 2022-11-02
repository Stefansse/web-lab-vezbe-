package mk.ukim.finki.wp.lab.bootstrap;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class CourseDataHolder {
    public static List<Course> courseList=new ArrayList<>();
    @PostConstruct
    public void init() {
        courseList.add(new Course((long)1,"Matematika","Matematika",new ArrayList<>()));
        courseList.add(new Course((long)2,"filozofija","Filozofija",new ArrayList<>()));
        courseList.add(new Course((long)3,"fizika","fizika",new ArrayList<>()));
        courseList.add(new Course((long)4,"prirodni nauke","prirodni nauke",new ArrayList<>()));
        courseList.add(new Course((long)5,"biologoija","bilogoija",new ArrayList<>()));
    }
}
