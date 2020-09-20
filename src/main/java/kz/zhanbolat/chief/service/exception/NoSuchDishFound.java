package kz.zhanbolat.chief.service.exception;

public class NoSuchDishFound extends RuntimeException {
    public NoSuchDishFound(String message) {
        super(message);
    }
}
