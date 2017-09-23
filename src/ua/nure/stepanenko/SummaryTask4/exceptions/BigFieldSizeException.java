package ua.nure.stepanenko.SummaryTask4.exceptions;

public class BigFieldSizeException extends Exception {
    @Override
    public String getMessage() {
        return "Field length is bigger, than database assumes.";
    }
}
