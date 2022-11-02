package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.service.StudentService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="list-student-servlet",urlPatterns = "/addStudent")
public class ListStudentServlet extends HttpServlet {
    private final StudentService studentService;
    private final SpringTemplateEngine springTemplateEngine;
    public ListStudentServlet(StudentService studentService, SpringTemplateEngine springTemplateEngine){
        this.studentService=studentService;
        this.springTemplateEngine=springTemplateEngine;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("courseId")==null)
            resp.sendRedirect("/listCourses");
        HttpSession session=req.getSession();
        session.setAttribute("courseId",req.getParameter("courseId"));
        WebContext context=new WebContext(req,resp,getServletContext());
        context.setVariable("studentsList",studentService.listAll());
        springTemplateEngine.process("listStudents.html",context,resp.getWriter());
    }
}
