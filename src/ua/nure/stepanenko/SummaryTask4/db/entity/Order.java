package ua.nure.stepanenko.SummaryTask4.db.entity;

import com.sun.istack.internal.Nullable;
import ua.nure.stepanenko.SummaryTask4.db.DBNames;
import ua.nure.stepanenko.SummaryTask4.db.enums.OrderStatus;
import ua.nure.stepanenko.SummaryTask4.exceptions.BigFieldSizeException;
import ua.nure.stepanenko.SummaryTask4.exceptions.NullFieldException;

import java.sql.Timestamp;

public class Order extends Entity {
    private long user_id;
    private long tour_id;
    private double discount;
    private int quantity;
    private double total_sum;
    private OrderStatus status;
    private Timestamp date_time;
    private String notes;

    public Order(long user_id,
                 long tour_id,
                 double discount,
                 int quantity,
                 double total_sum,
                 OrderStatus status,
                 Timestamp date_time,
                 @Nullable String notes) throws NullFieldException, BigFieldSizeException {
        if(user_id == 0 ||
                tour_id == 0 ||
                quantity == 0 ||
                status == null ||
                date_time == null) {
            throw new NullFieldException();
        }


        this.user_id = user_id;
        this.tour_id = tour_id;
        this.discount = discount;
        this.quantity = quantity;
        this.total_sum = total_sum;
        this.status = status;
        this.date_time = date_time;
        if(notes != null) {
            if(notes.length() > DBNames.Order.VARCHAR_COLUMN_LENGTHS.get(DBNames.Order.NOTES)) {
                throw new BigFieldSizeException();
            }
            this.notes = notes;
        }
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getTour_id() {
        return tour_id;
    }

    public void setTour_id(long tour_id) {
        this.tour_id = tour_id;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal_sum() {
        return total_sum;
    }

    public void setTotal_sum(double total_sum) {
        this.total_sum = total_sum;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Timestamp getDate_time() {
        return date_time;
    }

    public void setDate_time(Timestamp date_time) {
        this.date_time = date_time;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
