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

@WebServlet(name="courses-list-servlet", urlPatterns="/listCourses")
public class CoursesListSevlet extends HttpServlet {
    private final CourseService courseService;
    private final SpringTemplateEngine springTemplateEngine;
    public CoursesListSevlet(CourseService courseService,SpringTemplateEngine springTemplateEngine){
        this.courseService=courseService;
        this.springTemplateEngine=springTemplateEngine;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context=new WebContext(req,resp,getServletContext());
        context.setVariable("courseList",courseService.listAllCourses());
        springTemplateEngine.process("listCourses.html",context,resp.getWriter());
    }
}
