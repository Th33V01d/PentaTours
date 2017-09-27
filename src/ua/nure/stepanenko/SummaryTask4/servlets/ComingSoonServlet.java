package ua.nure.stepanenko.SummaryTask4.servlets;

import ua.nure.stepanenko.SummaryTask4.servlets.constants.Direction;
import ua.nure.stepanenko.SummaryTask4.servlets.constants.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(Servlet.COMING_SOON)
public class ComingSoonServlet extends HttpServlet {
    private static final String RES_BUNDLE_NAME = "coming-soon";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Work.setSessionLanguage(req, RES_BUNDLE_NAME);

        req.getRequestDispatcher(Direction.COMING_SOON).forward(req, resp);
    }
}
