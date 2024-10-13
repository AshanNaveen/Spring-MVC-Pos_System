package lk.ijse.sprinpos.exceptions;

/**
 * @author Naveen Theekshana
 * @date 10/13/2024
 * @project SpringPos
 */
public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String message) {
        super(message);
    }
    public OrderNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
