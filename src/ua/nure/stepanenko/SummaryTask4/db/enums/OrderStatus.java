package ua.nure.stepanenko.SummaryTask4.db.enums;

public enum OrderStatus {
    REGISTERED("registered"),
    PAID("paid"),
    CANCELED("canceled");

    public String getTypeName() {
        return typeName;
    }

    private String typeName;

    private OrderStatus(String name) {
        typeName = name;
    }
}
