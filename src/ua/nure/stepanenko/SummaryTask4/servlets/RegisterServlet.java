package ua.nure.stepanenko.SummaryTask4.servlets;

import org.json.simple.JSONObject;
import ua.nure.stepanenko.SummaryTask4.db.DBNames;
import ua.nure.stepanenko.SummaryTask4.exceptions.DBConnectException;
import ua.nure.stepanenko.SummaryTask4.services.UserService;
import ua.nure.stepanenko.SummaryTask4.servlets.constants.Direction;
import ua.nure.stepanenko.SummaryTask4.servlets.constants.Servlet;
import ua.nure.stepanenko.SummaryTask4.servlets.constants.SessionAttributes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(Servlet.REGISTER)
public class RegisterServlet extends HttpServlet {
    private static final String RES_BUNDLE_NAME = "register";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Work.setSessionLanguage(req, RES_BUNDLE_NAME);
        getServletContext().getRequestDispatcher(Direction.REGISTER).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isCreated = false;
        try {
            isCreated = UserService.createUser(req.getParameter("login"),
                    req.getParameter("password"),
                    req.getParameter("name"),
                    req.getParameter("lastname"),
                    req.getParameter("phone"),
                    req.getParameter("email"));
        } catch (DBConnectException | SQLException e) {
            System.out.println(e.getMessage());
        }

        req.setAttribute(SessionAttributes.REGISTRATION, isCreated);

        req.getRequestDispatcher(Direction.REGISTER_RES).forward(req, resp);
    }
}
