package ua.nure.stepanenko.SummaryTask4.db.enums;

import java.util.NoSuchElementException;

public enum OrderStatus {
    REGISTERED("registered"),
    PAID("paid"),
    CANCELED("canceled");

    public static OrderStatus getEnumValueByRolename(String rolename) {
        switch (rolename) {
            case "registered": return REGISTERED;
            case "paid": return PAID;
            case "canceled": return CANCELED;
            default: throw new NoSuchElementException();
        }
    }

    public String getTypeName() {
        return typeName;
    }

    private String typeName;

    private OrderStatus(String name) {
        typeName = name;
    }
}
