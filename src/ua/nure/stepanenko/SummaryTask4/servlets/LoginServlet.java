package ua.nure.stepanenko.SummaryTask4.servlets;

import ua.nure.stepanenko.SummaryTask4.db.entity.User;
import ua.nure.stepanenko.SummaryTask4.exceptions.DBConnectException;
import ua.nure.stepanenko.SummaryTask4.services.UserService;
import ua.nure.stepanenko.SummaryTask4.servlets.constants.Servlet;
import ua.nure.stepanenko.SummaryTask4.servlets.constants.SessionAttributes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(Servlet.LOGIN)
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = null;

        try {
            user = UserService.getUser(login, password);
        } catch (DBConnectException e) {
            System.out.println(e.getMessage());
        }

        if(user == null) {
            resp.sendRedirect(Servlet.INDEX_ERROR);
        }
        else {
            req.getSession().setAttribute(SessionAttributes.LOGIN, user.getLogin());
            req.getSession().setAttribute(SessionAttributes.ROLE, user.getRole().getRoleName());

            resp.sendRedirect(Servlet.USER_HOME);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(Servlet.USER_HOME);
    }
}