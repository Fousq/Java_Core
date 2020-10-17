package kz.zhanbolat.chief.exception;

public class NoSuchDishFound extends RuntimeException {
    public NoSuchDishFound(String message) {
        super(message);
    }
}
