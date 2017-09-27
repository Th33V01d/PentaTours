package ua.nure.stepanenko.SummaryTask4.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ua.nure.stepanenko.SummaryTask4.dao.CatalogDAO;
import ua.nure.stepanenko.SummaryTask4.db.entity.Tour;
import ua.nure.stepanenko.SummaryTask4.db.enums.UserRole;
import ua.nure.stepanenko.SummaryTask4.dbmanager.DBManager;
import ua.nure.stepanenko.SummaryTask4.exceptions.BigFieldSizeException;
import ua.nure.stepanenko.SummaryTask4.exceptions.DBConnectException;
import ua.nure.stepanenko.SummaryTask4.exceptions.NullFieldException;
import ua.nure.stepanenko.SummaryTask4.services.CatalogService;
import ua.nure.stepanenko.SummaryTask4.servlets.constants.Direction;
import ua.nure.stepanenko.SummaryTask4.servlets.constants.Servlet;
import ua.nure.stepanenko.SummaryTask4.servlets.constants.SessionAttributes;

@WebServlet(Servlet.USER_HOME)
public class UserHomeServlet extends HttpServlet {
    public static final String RES_BUNDLE_NAME = "user-catalog";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Work.setSessionLanguage(req, RES_BUNDLE_NAME);
        if (UserRole.USER.getRoleName().equals(req.getSession().getAttribute(SessionAttributes.ROLE))) {
            CatalogService.setSortParameters(req);
            CatalogService.searchTours(req);
        }

        redirectionByRole(req, resp);
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        redirectionByRole(req, resp);
    }

    private void redirectionByRole(HttpServletRequest req,
                                   HttpServletResponse resp) throws ServletException, IOException {
        String role = (String) req.getSession().getAttribute(SessionAttributes.ROLE);

        if(role != null) {
            String dir = Direction.HOME_PAGES_BY_ROLES.get(UserRole.getEnumValueByRolename(role));
            getServletContext().getRequestDispatcher(dir).forward(req, resp);
        }
        else {
            Work.doRedirection(req, resp);
        }
    }
}
