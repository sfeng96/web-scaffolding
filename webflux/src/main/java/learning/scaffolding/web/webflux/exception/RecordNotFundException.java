package learning.scaffolding.web.webflux.exception;

public class RecordNotFundException extends RuntimeException{
    public RecordNotFundException(String message) {
        super(message);
    }
}
