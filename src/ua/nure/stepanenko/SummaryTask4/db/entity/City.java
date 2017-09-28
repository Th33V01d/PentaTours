package ua.nure.stepanenko.SummaryTask4.db.entity;

import ua.nure.stepanenko.SummaryTask4.db.DBNames;
import ua.nure.stepanenko.SummaryTask4.exceptions.BigFieldSizeException;
import ua.nure.stepanenko.SummaryTask4.exceptions.NullFieldException;

public class City extends Entity {
    private String name;
    private long country_id;

    public City(int id,
                String name,
                long country_id) throws NullFieldException, BigFieldSizeException {
        if(name == null ||
                country_id == 0) {
            throw new NullFieldException();
        }
        if(name.length() > DBNames.City.VARCHAR_COLUMN_LENGTHS.get(DBNames.City.NAME)) {
            throw new BigFieldSizeException();
        }

        this.id = id;
        this.name = name;
        this.country_id = country_id;
    }

    public String getName() {
        return name;
    }

    public long getCountry_id() {
        return country_id;
    }
}
