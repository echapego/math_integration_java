package integration;

public class NotSupportedLimitsException extends IllegalArgumentException {
    public NotSupportedLimitsException(String errorMessage){
        super(errorMessage);
    }
}