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

        // todo: поиск страны по ид; выброс исключения, если таковой не обнаруживается.
        // todo: for each reference - do ref id test!!!
        this.id = id;
        this.name = name;
        this.country_id = country_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCountry_id() {
        return country_id;
    }

    public void setCountry_id(long country_id) {
        this.country_id = country_id;
    }
}
