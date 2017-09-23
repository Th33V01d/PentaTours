package ua.nure.stepanenko.SummaryTask4.db.entity;

import ua.nure.stepanenko.SummaryTask4.db.DBNames;
import ua.nure.stepanenko.SummaryTask4.exceptions.BigFieldSizeException;
import ua.nure.stepanenko.SummaryTask4.exceptions.NullFieldException;

public class Tag extends Entity {
    private String name;
    private String type;
    private String description;

    public Tag(String name,
               String type,
               String description) throws NullFieldException, BigFieldSizeException {
        if(name == null ||
                type == null ||
                description == null) {
            throw new NullFieldException();
        }

        if(name.length() > DBNames.Tag.VARCHAR_COLUMN_LENGTHS.get(DBNames.Tag.NAME) ||
                type.length() > DBNames.Tag.VARCHAR_COLUMN_LENGTHS.get(DBNames.Tag.TYPE) ||
                description.length() > DBNames.Tag.VARCHAR_COLUMN_LENGTHS.get(DBNames.Tag.DESCRIPTION)) {
            throw new BigFieldSizeException();
        }

        this.name = name;
        this.type = type;
        this.description = description;
    }

    // todo: в сеттерах сделать проверку инфы и запрос на UPDATE

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
}
