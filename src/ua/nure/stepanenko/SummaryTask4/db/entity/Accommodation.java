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

    public Accommodation (String name,
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
                link == null ||
                type == null) {
            throw new NullFieldException();
        }
        if(name.length() > DBNames.Accommodation.VARCHAR_COLUMN_LENGTHS.get(DBNames.Accommodation.NAME) ||
                address.length() > DBNames.Accommodation.VARCHAR_COLUMN_LENGTHS.get(DBNames.Accommodation.ADDRESS) ||
                description.length() > DBNames.Accommodation.VARCHAR_COLUMN_LENGTHS.get(DBNames.Accommodation.DESCRIPTION) ||
                link.length() > DBNames.Accommodation.VARCHAR_COLUMN_LENGTHS.get(DBNames.Accommodation.LINK) ||
                type.length() > DBNames.Accommodation.VARCHAR_COLUMN_LENGTHS.get(DBNames.Accommodation.TYPE)) {
            throw new BigFieldSizeException();
        }
    }
}
