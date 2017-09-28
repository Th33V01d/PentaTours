package ua.nure.stepanenko.SummaryTask4.db.entity;

import ua.nure.stepanenko.SummaryTask4.db.DBNames;
import ua.nure.stepanenko.SummaryTask4.db.enums.TourType;
import ua.nure.stepanenko.SummaryTask4.exceptions.BigFieldSizeException;
import ua.nure.stepanenko.SummaryTask4.exceptions.DBConnectException;
import ua.nure.stepanenko.SummaryTask4.exceptions.NullFieldException;
import ua.nure.stepanenko.SummaryTask4.services.CatalogService;

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

    public Tour(int id,
                String name,
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
                String image_link) throws NullFieldException, BigFieldSizeException, DBConnectException {

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

        this.id = id;
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

        this.accommodations = CatalogService.getAccommodationsByTourId(this.id);
        this.cities = CatalogService.getCitiesByTourId(this.id);
        this.transports = CatalogService.getTransportsByTourId(this.id);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getBooked() {
        return booked;
    }

    public double getPrice() {
        return price;
    }

    public boolean isFire() {
        return isFire;
    }

    public double getDiscount_max() {
        return discount_max;
    }

    public double getDiscount_step() {
        return discount_step;
    }

    public TourType getType() {
        return type;
    }

    public Timestamp getDate_begin() {
        return date_begin;
    }

    public Timestamp getDate_end() {
        return date_end;
    }

    public String getImage_link() {
        return image_link;
    }

    public List<Accommodation> getAccommodations() {
        return accommodations;
    }

    public List<Transport> getTransports() {
        return transports;
    }

    public List<City> getCities() {
        return cities;
    }
}
