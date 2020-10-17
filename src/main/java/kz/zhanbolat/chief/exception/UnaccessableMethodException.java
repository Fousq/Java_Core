package kz.zhanbolat.chief.exception;

public class UnaccessableMethodException extends RuntimeException {
    public UnaccessableMethodException(String message, Throwable cause) {
        super(message, cause);
    }
}
