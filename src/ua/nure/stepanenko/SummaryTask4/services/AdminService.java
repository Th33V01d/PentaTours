package ua.nure.stepanenko.SummaryTask4.services;

import ua.nure.stepanenko.SummaryTask4.dao.AdminDAO;
import ua.nure.stepanenko.SummaryTask4.db.entity.Tour;
import ua.nure.stepanenko.SummaryTask4.db.enums.OrderStatus;
import ua.nure.stepanenko.SummaryTask4.dbmanager.DBManager;
import ua.nure.stepanenko.SummaryTask4.exceptions.DBConnectException;
import ua.nure.stepanenko.SummaryTask4.services.helper.OrderView;

import java.util.List;

public class AdminService {
    private AdminService() {}

    public static List<Tour> getAllTours() {
        return CatalogService.getTours();
    }

    public static List<OrderView> getAllOrders() throws DBConnectException {
        AdminDAO adminDAO = new AdminDAO(DBManager.getInstance());
        return adminDAO.getAllOrders();
    }

    public static boolean updateInfo(int id, String value, String type) {
        boolean success = false;

        try {
            AdminDAO adminDAO = new AdminDAO(DBManager.getInstance());
            if("order".equals(type)) {
                OrderStatus actualValue = OrderStatus.getEnumValueByRolename(value);
                success = adminDAO.updateOrder(id, actualValue);
            }
            else if ("tour".equals(type)) {
                boolean actualValue = Boolean.parseBoolean(value);
                success = adminDAO.updateTour(id, actualValue);
            }
        } catch (DBConnectException e) {
            System.out.println(e.getMessage());
            success = false;
        }

        return success;
    }
}
