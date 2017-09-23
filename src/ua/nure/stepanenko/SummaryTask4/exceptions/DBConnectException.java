package ua.nure.stepanenko.SummaryTask4.exceptions;

public class DBConnectException extends Exception {
    @Override
    public String getMessage() {
        return "Error occurred while trying to connect.";
    }
}
