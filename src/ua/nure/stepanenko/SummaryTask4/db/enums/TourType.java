package ua.nure.stepanenko.SummaryTask4.db.enums;

public enum TourType {
    EXCURSION("excursion"),
    REST("rest"),
    MIXED("mixed");

    public String getTypeName() {
        return typeName;
    }

    private String typeName;

    private TourType(String name) {
        typeName = name;
    }
}
