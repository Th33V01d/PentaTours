package ua.nure.stepanenko.SummaryTask4.exceptions;

public class CreateInstanceException extends Exception {
    @Override
    public String getMessage() {
        return "Failed creating instance.";
    }
}
