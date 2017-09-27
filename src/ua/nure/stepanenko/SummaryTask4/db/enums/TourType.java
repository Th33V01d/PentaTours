package ua.nure.stepanenko.SummaryTask4.db.enums;

import java.util.NoSuchElementException;

public enum TourType {
    EXCURSION("excursion"),
    REST("rest"),
    MIXED("mixed");

    public static TourType getEnumValueByRolename(String rolename) {
        switch (rolename) {
            case "excursion": return EXCURSION;
            case "rest": return REST;
            case "mixed": return MIXED;
            default: throw new NoSuchElementException();
        }
    }

    public String getTypeName() {
        return typeName;
    }

    private String typeName;

    private TourType(String name) {
        typeName = name;
    }
}
