package ua.nure.stepanenko.SummaryTask4.dao;

import ua.nure.stepanenko.SummaryTask4.db.DBNames;
import ua.nure.stepanenko.SummaryTask4.db.Query;
import ua.nure.stepanenko.SummaryTask4.db.entity.Order;
import ua.nure.stepanenko.SummaryTask4.db.enums.OrderStatus;
import ua.nure.stepanenko.SummaryTask4.dbmanager.DBManager;
import ua.nure.stepanenko.SummaryTask4.exceptions.BigFieldSizeException;
import ua.nure.stepanenko.SummaryTask4.exceptions.NullFieldException;
import ua.nure.stepanenko.SummaryTask4.services.helper.OrderView;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO extends AbstractDAO {
    public AdminDAO(DBManager dbManager) {
        super(dbManager);
    }

    public List<OrderView> getAllOrders() {
        List<OrderView> orderViews = new ArrayList<>();

        try (Connection conn = getConnection()) {
            Statement st = conn.createStatement();
            ResultSet set = st.executeQuery(Query.SELECT_ALL_ORDERS);

            while(set.next()) {
                orderViews.add(
                        new OrderView(
                                new Order(
                                        set.getInt(DBNames.Order.ID),
                                        (long) set.getInt(DBNames.Order.USER),
                                        (long) set.getInt(DBNames.Order.TOUR),
                                        set.getDouble(DBNames.Order.DISCOUNT),
                                        set.getInt(DBNames.Order.QUANTITY),
                                        set.getDouble(DBNames.Order.TOTAL_SUM),
                                        OrderStatus.getEnumValueByRolename(set.getString(DBNames.Order.STATUS)),
                                        set.getTimestamp(DBNames.Order.DATE_TIME),
                                        set.getString(DBNames.Order.NOTES)
                                ),
                                set.getString("user_login"),
                                set.getString("tour_name")
                        )
                );
            }
        } catch (BigFieldSizeException | NullFieldException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return orderViews;
    }

    public boolean updateTour(int id, boolean isFire) {
        try (Connection conn = getConnection()) {
            PreparedStatement ps = conn.prepareStatement(Query.UPDATE_TOUR_FIRE);
            ps.setBoolean(1, isFire);
            ps.setInt(2, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean updateOrder(int id, OrderStatus status) {
        try (Connection conn = getConnection()) {
            PreparedStatement ps = conn.prepareStatement(Query.UPDATE_ORDER_STATUS);
            ps.setString(1, status.getTypeName());
            ps.setInt(2, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
