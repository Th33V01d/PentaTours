package ua.nure.stepanenko.SummaryTask4.db.enums;

import java.util.NoSuchElementException;

public enum UserRole {
    USER("user"),
    MANAGER("manager"),
    ADMIN("admin");

    public static UserRole getEnumValueByRolename(String rolename) {
        switch (rolename) {
            case "user": return USER;
            case "manager": return MANAGER;
            case "admin": return ADMIN;
            default: throw new NoSuchElementException();
        }
    }

    public String getRoleName() {
        return roleName;
    }

    private String roleName;

    private UserRole(String role) {
        roleName = role;
    }
}
