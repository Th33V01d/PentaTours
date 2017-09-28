package ua.nure.stepanenko.SummaryTask4.servlets;

import ua.nure.stepanenko.SummaryTask4.services.AdminService;
import ua.nure.stepanenko.SummaryTask4.servlets.constants.Direction;
import ua.nure.stepanenko.SummaryTask4.servlets.constants.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(Servlet.ADM_UPD)
public class AdminUpdateServlet extends HttpServlet {
    private static final String RES_BUNDLE_NAME = "operation-info";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean err = false;

        String id = req.getParameter("id");
        String par = req.getParameter("par");
        String type = req.getParameter("type");

        if(id == null || par == null || type == null) {
            err = true;
        }
        else if("".equals(id) || "".equals(par) || "".equals(type)) {
            err = true;
        }

        if(!err) {
            try {
                err = AdminService.updateInfo(Integer.parseInt(id), par, type);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                err = true;
            }
        }

        req.setAttribute("err", err);
        Work.setSessionLanguage(req, RES_BUNDLE_NAME);
        req.getRequestDispatcher(Direction.INFO);
    }
}
