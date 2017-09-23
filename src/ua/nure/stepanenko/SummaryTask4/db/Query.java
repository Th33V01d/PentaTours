package ua.nure.stepanenko.SummaryTask4.db;

public class Query {

    public static final String SELECT_USER = "select * " +
                "from " + DBNames.User.getName() +
                " where " + DBNames.User.LOGIN + " = ?";

    public static final String CREATE_USER = "insert into " + DBNames.User.getName() +
                " values (default, ?, ?, ?, ?, ?, ?, ?, default);";

    private Query() {}
}
