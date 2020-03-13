package servlet;
import dao.studentdao;
import dao.teacherdao;
import impl.studentdao1;
import impl.teacherdao1;
import db.student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")

public class registerservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userType = req.getParameter("user_type");
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        if(userType.equals("teacher")){
            teacherdao teacherDao = new teacherdao1();

            if(teacherDao.addTeacher(name, password)){
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }else{
                resp.getWriter().println("注册失败");
            }
        }else{
            studentdao studentDao = new studentdao1();

            if(studentDao.addStudent(name, password)){
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }else{
                resp.getWriter().println("注册失败");
            }
        }
    }
}
