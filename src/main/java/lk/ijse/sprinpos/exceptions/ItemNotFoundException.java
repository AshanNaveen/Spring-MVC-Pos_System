package lk.ijse.sprinpos.exceptions;

/**
 * @author Naveen Theekshana
 * @date 10/13/2024
 * @project SpringPos
 */
public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String message) {
        super(message);
    }
    public ItemNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
