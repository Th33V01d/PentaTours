package ua.nure.stepanenko.SummaryTask4.db.entity;

import ua.nure.stepanenko.SummaryTask4.db.DBNames;
import ua.nure.stepanenko.SummaryTask4.exceptions.BigFieldSizeException;
import ua.nure.stepanenko.SummaryTask4.exceptions.NullFieldException;

public class Accommodation extends Entity {
    private String name;
    private long city_id;
    private String address;
    private int stars;
    private String description;
    private String link;
    private String type;

    public Accommodation (int id,
                          String name,
                          long city_id,
                          String address,
                          int stars,
                          String description,
                          String link,
                          String type) throws NullFieldException, BigFieldSizeException {
        if(name == null ||
                city_id == 0 ||
                address == null ||
                stars == 0 ||
                description == null ||
                type == null) {
            throw new NullFieldException();
        }
        if(name.length() > DBNames.Accommodation.VARCHAR_COLUMN_LENGTHS.get(DBNames.Accommodation.NAME) ||
                address.length() > DBNames.Accommodation.VARCHAR_COLUMN_LENGTHS.get(DBNames.Accommodation.ADDRESS) ||
                description.length() > DBNames.Accommodation.VARCHAR_COLUMN_LENGTHS.get(DBNames.Accommodation.DESCRIPTION) ||
                type.length() > DBNames.Accommodation.VARCHAR_COLUMN_LENGTHS.get(DBNames.Accommodation.TYPE)) {
            throw new BigFieldSizeException();
        }
        if(link != null) {
            if(link.length() > DBNames.Accommodation.VARCHAR_COLUMN_LENGTHS.get(DBNames.Accommodation.LINK)) {
                throw new BigFieldSizeException();
            }
        }

        this.id = id;
        this.name = name;
        this.city_id = city_id;
        this.address = address;
        this.stars = stars;
        this.description = description;
        this.link = link;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCity_id() {
        return city_id;
    }

    public void setCity_id(long city_id) {
        this.city_id = city_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
