package servlet;
import dao.homeworkdao;
import dao.submitdao;
import dao.teacherdao;
import dao.studentdao;
import impl.homeworkdao1;
import impl.studentdao1;
import impl.teacherdao1;
import db.homework;
import db.student;
import db.teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class loginservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userType = req.getParameter("user_type");
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        if(userType.equals("teacher")){
            teacherdao teacherDao = new teacherdao1();

            teacher teacher = teacherDao.getTeacher(name);
            if(password.equals(teacher.getPassword())){

                req.setAttribute("teacher", teacher);
                req.getRequestDispatcher("create_homework.jsp").forward(req, resp);
            }else{
                resp.getWriter().println("用户名或密码错误");
            }
        }else if(userType.equals("student")){
            studentdao studentDao = new studentdao1();

            student student = studentDao.getStudent(name);
            if(password.equals(student.getPassword())){
                req.setAttribute("sid", student.getId());

                List<homework> homeworkList = new homeworkdao1().getHomeworkOfStudent(student.getId());
                req.setAttribute("homeworkList", homeworkList);

                req.getRequestDispatcher("submit_homework.jsp").forward(req, resp);
            }else{
                resp.getWriter().println("用户名或密码错误");
            }
        }
    }
}
