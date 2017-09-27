package ua.nure.stepanenko.SummaryTask4.services.helpingClasses;

public class TourReview {
    private int id;
    private String name;
    private String description;
    private int left;
    private String img_link;
    private double price;

    public TourReview(int id, String name, String description, int left, String img_link, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.left = left;
        this.img_link = img_link;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getLeft() {
        return left;
    }

    public String getImagelink() {
        return img_link;
    }

    public double getPrice() {
        return price;
    }
}
