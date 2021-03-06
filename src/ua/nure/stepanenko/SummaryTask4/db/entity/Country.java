package ua.nure.stepanenko.SummaryTask4.db.entity;

import ua.nure.stepanenko.SummaryTask4.db.DBNames;
import ua.nure.stepanenko.SummaryTask4.exceptions.BigFieldSizeException;
import ua.nure.stepanenko.SummaryTask4.exceptions.NullFieldException;

public class Country extends Entity {
    private String name;

    public Country(int id, String name) throws NullFieldException, BigFieldSizeException {
        if(name == null) {
            throw new NullFieldException();
        }
        if(name.length() > DBNames.Country.VARCHAR_COLUMN_LENGTHS.get(DBNames.Country.NAME)) {
            throw new BigFieldSizeException();
        }
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
