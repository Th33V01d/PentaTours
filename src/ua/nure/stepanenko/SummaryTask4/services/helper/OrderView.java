package ua.nure.stepanenko.SummaryTask4.services.helper;

import ua.nure.stepanenko.SummaryTask4.db.entity.Order;

public class OrderView {
    private Order order;
    private String userLogin;
    private String tourName;

    public OrderView(Order order, String userLogin, String tourName) {
        this.order = order;
        this.userLogin = userLogin;
        this.tourName = tourName;
    }

    public Order getOrder() {
        return order;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getTourName() {
        return tourName;
    }
}
