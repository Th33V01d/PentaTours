package ua.nure.stepanenko.SummaryTask4.servlets.constants;

import ua.nure.stepanenko.SummaryTask4.db.enums.UserRole;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Direction {
    private static final String FOLDER = "/WEB-INF/web-pages/";
    private static final String USER_FOLDER = FOLDER + "user/";
    private static final String MANAGER_FOLDER = FOLDER + "manager/";
    private static final String ADMIN_FOLDER = FOLDER + "admin/";
    private static final String HOME_JSP = "home.jsp";

    public static final String INDEX = FOLDER + "index.jsp";

    public static final String REGISTER = FOLDER + "register.jsp";
    public static final String REGISTER_RES = FOLDER + "register-res.jsp";

    public static final String USER_HOME = USER_FOLDER + HOME_JSP;
    public static final String MANAGER_HOME = MANAGER_FOLDER + HOME_JSP;
    public static final String ADMIN_HOME = MANAGER_FOLDER + HOME_JSP;


    public static final Map<UserRole, String> HOME_PAGES_BY_ROLES;
    static {
        Map<UserRole, String> tempMap = new HashMap<>();
        tempMap.put(UserRole.USER, USER_HOME);
        tempMap.put(UserRole.MANAGER, MANAGER_HOME);
        tempMap.put(UserRole.ADMIN, ADMIN_HOME);
        HOME_PAGES_BY_ROLES = Collections.unmodifiableMap(tempMap);
    }

    private Direction() {}
}
