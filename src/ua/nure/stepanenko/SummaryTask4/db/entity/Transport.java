package ua.nure.stepanenko.SummaryTask4.db.entity;

import ua.nure.stepanenko.SummaryTask4.db.DBNames;
import ua.nure.stepanenko.SummaryTask4.exceptions.BigFieldSizeException;
import ua.nure.stepanenko.SummaryTask4.exceptions.NullFieldException;

public class Transport extends Entity {
    private String name;
    private String type;
    private String description;
    private int quantity;

    public Transport(int id,
                     String name,
                     String type,
                     String description,
                     int quantity) throws NullFieldException, BigFieldSizeException {
        if(name == null ||
                type == null ||
                description == null ||
                quantity < 1) {
            throw new NullFieldException();
        }
        if(name.length() > DBNames.Transport.VARCHAR_COLUMN_LENGTHS.get(DBNames.Transport.NAME) ||
                type.length() > DBNames.Transport.VARCHAR_COLUMN_LENGTHS.get(DBNames.Transport.TYPE) ||
                description.length() > DBNames.Transport.VARCHAR_COLUMN_LENGTHS.get(DBNames.Transport.DESCRIPTION)) {
            throw new BigFieldSizeException();
        }
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}
