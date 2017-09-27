package ua.nure.stepanenko.SummaryTask4.servlets;

import ua.nure.stepanenko.SummaryTask4.servlets.constants.Servlet;
import ua.nure.stepanenko.SummaryTask4.servlets.constants.SessionAttributes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(Servlet.LOGOUT)
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doWork(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doWork(req, resp);
    }

    private void doWork(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        req.getSession().setAttribute(SessionAttributes.LOGIN, null);
        req.getSession().setAttribute(SessionAttributes.ROLE, null);

        req.getSession().invalidate();

        resp.sendRedirect(Servlet.INDEX);
    }
}
