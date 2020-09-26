package kz.zhanbolat.chief.exception;

public class NoSuchDishException extends RuntimeException {
    public NoSuchDishException(String message) {
        super(message);
    }
}
