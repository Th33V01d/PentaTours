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
        try {
            req.setAttribute("cities", CatalogService.getAllCities());
            req.setAttribute("accomms", CatalogService.getAllAccommodationTypes());
            req.setAttribute("transports", CatalogService.getAllTransportTypes());
        } catch (DBConnectException e) {
            e.printStackTrace();
        }

        String city = null;
        String transport = null;
        String accommodation = null;
        Double priceMin = null;
        Double priceMax = null;
        Integer quantity = null;

        city = req.getParameter("city");
        transport = req.getParameter("transport");
        accommodation = req.getParameter("accommodation");
        String price_min = req.getParameter("price_min");
        String price_max = req.getParameter("price_max");
        String quant = req.getParameter("quant");

        if(price_min != null) {
            if(!"".equals(price_min)) {
                priceMin = Double.parseDouble(price_min);
            }
        }
        if(price_max != null) {
            if(!"".equals(price_max)) {
                priceMax = Double.parseDouble(price_max);
            }
        }
        if(quant != null) {
            if(!"".equals(quant)) {
                quantity = Integer.parseInt(quant);
            }
        }

        List<Tour> tours = new ArrayList<>();
        boolean found = false;

        try {
            tours = CatalogService.searchTours(city,transport, accommodation, priceMin, priceMax, quantity);
        } catch (DBConnectException | BigFieldSizeException | NullFieldException e) {
            System.out.println(e.getMessage());
        }

        if(tours.size() > 0) {
            found = true;
        }

        req.setAttribute("found", found);
        req.setAttribute("tours", tours);

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
