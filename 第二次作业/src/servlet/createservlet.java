package servlet;
import dao.assigndao;
import dao.homeworkdao;
import impl.assigndao1;
import impl.homeworkdao1;
import db.homework;
import db.student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/createHomework")
public class createservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int tid = Integer.parseInt(req.getParameter("tid"));
        String title = req.getParameter("title");
        String requirement = req.getParameter("requirement");

        homeworkdao homeworkDao = new homeworkdao1();
        if (homeworkDao.addHomework(title, requirement)) {
            int hid = homeworkDao.getHomeworkByTitle(title).getId();

            assigndao assignDao = new assigndao1();
            assignDao.assign(tid, hid);

            req.setAttribute("homeworkList", homeworkDao.getHomeworkOfTeacher(tid));

            req.getRequestDispatcher("/assign_homework.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/fail.jsp").forward(req, resp);
        }
    }
}