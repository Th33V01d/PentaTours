package ua.nure.stepanenko.SummaryTask4.exceptions;

public class NullFieldException extends Exception {
    @Override
    public String getMessage() {
        return "Field must not be empty.";
    }
}
