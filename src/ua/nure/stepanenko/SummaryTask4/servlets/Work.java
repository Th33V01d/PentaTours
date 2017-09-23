package ua.nure.stepanenko.SummaryTask4.servlets;

import ua.nure.stepanenko.SummaryTask4.servlets.constants.Servlet;
import ua.nure.stepanenko.SummaryTask4.servlets.constants.SessionAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class Work {

    public static void doRedirection(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute(SessionAttributes.LOGIN) == null) {
            resp.sendRedirect(Servlet.INDEX_ERROR);
        }
        else {
            resp.sendRedirect(Servlet.USER_HOME);
        }
    }

    public static void setSessionLanguage(HttpServletRequest req, String bundleName) {
        Map<String, String> bundleMap;
        String sessionLang = (String) req.getSession().getAttribute(SessionAttributes.LANG);
        String reqLang = req.getParameter(SessionAttributes.LANG);
        String defaultLocaleLang = req.getLocale().getLanguage();

        boolean resetBundle = false;

        if(sessionLang != null) {
            if(!sessionLang.equals(reqLang) && reqLang != null) {
                sessionLang = reqLang;
                resetBundle = true;
            }
            else if(!sessionLang.equals(defaultLocaleLang)) {
                sessionLang = defaultLocaleLang;
                resetBundle = true;
            }
        }
        else {
            if(reqLang != null) {
                sessionLang = reqLang;
            }
            else {
                sessionLang = defaultLocaleLang;
            }
            resetBundle = true;
        }

        if(resetBundle) {
            req.setAttribute(SessionAttributes.LANG, sessionLang);

            ResourceBundle rb = ResourceBundle.getBundle(bundleName, new Locale(sessionLang));
            bundleMap = Work.convertResourceBundleToMap(rb);

            req.getSession().setAttribute(SessionAttributes.BUNDLE, bundleMap);
        }
    }

    private static Map<String, String> convertResourceBundleToMap(ResourceBundle resource) {
        Map<String, String> map = new HashMap<>();

        Enumeration<String> keys = resource.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            map.put(key, resource.getString(key));
        }

        return map;
    }

    private Work() {}
}
