package servlet;

import dao.submitdao;
import impl.submitdao1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/assign")
public class assignservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int hid = Integer.parseInt(req.getParameter("hid"));
        String[] studentIDs = req.getParameter("students").split(";");

        submitdao submitDao = new submitdao1();
        for (String studentId : studentIDs) {
            int sid = Integer.parseInt(studentId);

            submitDao.addSubmit(sid, hid);
        }

        req.getRequestDispatcher("/successful.jsp").forward(req, resp);
    }
}
