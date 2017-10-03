package ua.nure.stepanenko.SummaryTask4.servlets;

import ua.nure.stepanenko.SummaryTask4.db.enums.UserRole;
import ua.nure.stepanenko.SummaryTask4.services.CatalogService;
import ua.nure.stepanenko.SummaryTask4.servlets.constants.Direction;
import ua.nure.stepanenko.SummaryTask4.servlets.constants.Servlet;
import ua.nure.stepanenko.SummaryTask4.servlets.constants.SessionAttributes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(Servlet.BUY_TOUR)
public class BuyTourServlet extends HttpServlet {
    private static final String RES_BUNDLE_NAME = "order-info";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Work.setSessionLanguage(req, RES_BUNDLE_NAME);
        boolean suc;
        String role = (String) req.getSession().getAttribute(SessionAttributes.ROLE);
        if(UserRole.USER.getRoleName().equals(role)) {

            String tourId = req.getParameter("tourId");
            String quantity = req.getParameter("quant");

            suc = false;

            if (tourId == null || quantity == null) {
                suc = true;
            } else if ("".equals(tourId) || "".equals(quantity)) {
                suc = true;
            }

            if (!suc) {
                int quant = 0;
                int tour = 0;
                try {
                    quant = Integer.parseInt(quantity);
                    tour = Integer.parseInt(tourId);
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }

                suc = CatalogService.buyTour(tour, (String) req.getSession().getAttribute(SessionAttributes.LOGIN), quant, req.getParameter("notes"));
            }
        }
        else {
            suc = false;
        }
        req.setAttribute("suc", suc);
        req.getRequestDispatcher(Direction.INFO).forward(req, resp);

    }
}
