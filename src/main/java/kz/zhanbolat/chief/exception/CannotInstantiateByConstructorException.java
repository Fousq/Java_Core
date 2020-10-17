package kz.zhanbolat.chief.exception;

public class CannotInstantiateByConstructorException extends RuntimeException {
    public CannotInstantiateByConstructorException(String message, Throwable cause) {
        super(message, cause);
    }
}
