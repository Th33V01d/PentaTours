package ua.nure.stepanenko.SummaryTask4.db.entity;

import ua.nure.stepanenko.SummaryTask4.db.DBNames;
import ua.nure.stepanenko.SummaryTask4.db.enums.TourType;
import ua.nure.stepanenko.SummaryTask4.exceptions.BigFieldSizeException;
import ua.nure.stepanenko.SummaryTask4.exceptions.NullFieldException;

import java.sql.Timestamp;
import java.util.List;


public class Tour extends Entity {
    private String name;
    private String description;
    private int quantity;
    private int booked;
    private double price;
    private boolean isFire;
    private double discount_max;
    private double discount_step;
    private TourType type;
    private Timestamp date_begin;
    private Timestamp date_end;
    private String image_link;
    private List<Accommodation> accommodations;
    private List<Transport> transports;
    private List<City> cities;

    public Tour(String name,
                String description,
                int quantity,
                int booked,
                double price,
                boolean isFire,
                double discount_max,
                double discount_step,
                TourType type,
                Timestamp date_begin,
                Timestamp date_end,
                String image_link) throws NullFieldException, BigFieldSizeException {

        if(name == null ||
                quantity < 1 ||
                description == null ||
                image_link == null) {
            throw new NullFieldException();
        }

        if(name.length() > DBNames.Tour.VARCHAR_COLUMN_LENGTHS.get(DBNames.Tour.NAME) ||
                description.length() > DBNames.Tour.VARCHAR_COLUMN_LENGTHS.get(DBNames.Tour.DESCRIPTION) ||
                image_link.length() > DBNames.Tour.VARCHAR_COLUMN_LENGTHS.get(DBNames.Tour.IMAGE_LINK)) {
            throw new BigFieldSizeException();
        }

        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.booked = booked;
        this.price = price;
        this.isFire = isFire;
        this.discount_max = discount_max;
        this.discount_step = discount_step;
        this.type = type;
        this.date_begin = date_begin;
        this.date_end = date_end;
        this.image_link = image_link;
    }


    // todo: в сеттерах сделать проверку инфы и запрос на UPDATE

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getBooked() {
        return booked;
    }

    public void setBooked(int booked) {
        this.booked = booked;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isFire() {
        return isFire;
    }

    public void setFire(boolean fire) {
        isFire = fire;
    }

    public double getDiscount_max() {
        return discount_max;
    }

    public void setDiscount_max(double discount_max) {
        this.discount_max = discount_max;
    }

    public double getDiscount_step() {
        return discount_step;
    }

    public void setDiscount_step(double discount_step) {
        this.discount_step = discount_step;
    }

    public TourType getType() {
        return type;
    }

    public void setType(TourType type) {
        this.type = type;
    }

    public Timestamp getDate_begin() {
        return date_begin;
    }

    public void setDate_begin(Timestamp date_begin) {
        this.date_begin = date_begin;
    }

    public Timestamp getDate_end() {
        return date_end;
    }

    public void setDate_end(Timestamp date_end) {
        this.date_end = date_end;
    }

    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public List<Accommodation> getAccommodations() {
        return accommodations;
    }

    public void setAccommodations(List<Accommodation> accommodations) {
        this.accommodations = accommodations;
    }

    public List<Transport> getTransports() {
        return transports;
    }

    public void setTransports(List<Transport> transports) {
        this.transports = transports;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
