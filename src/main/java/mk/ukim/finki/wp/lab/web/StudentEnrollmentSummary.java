package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.service.CourseService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="student-enrollment-summary",urlPatterns = "/studentEnrollmentSummary")
public class StudentEnrollmentSummary extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final CourseService courseService;
    public StudentEnrollmentSummary(SpringTemplateEngine springTemplateEngine,CourseService courseService){
        this.springTemplateEngine=springTemplateEngine;
        this.courseService=courseService;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("courseId")==null)
            resp.sendRedirect("/listCourses");
        WebContext context=new WebContext(req,resp,getServletContext());
        Long courseId=Long.parseLong(req.getSession().getAttribute("courseId").toString());
        String username=req.getParameter("size");
        courseService.addStudentInCourse(username,courseId);
        context.setVariable("students",courseService.listStudentsByCourse(courseId));
        context.setVariable("courseName",courseService.getCourseNameById(courseId));
        springTemplateEngine.process("studentsInCourse.html",context,resp.getWriter());
    }
}
