package T2454.Chandan_Bansal.BE_Project1.exception;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(String message) {
        super(message);
    }

    public ItemNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemNotFoundException(Throwable cause) {
        super(cause);
    }
}
