package lk.ijse.sprinpos.exceptions;

import lombok.NoArgsConstructor;

/**
 * @author Naveen Theekshana
 * @date 10/14/2024
 * @project SpringPos
 */
@NoArgsConstructor
public class DataPersistFailedException extends RuntimeException {
    public DataPersistFailedException(String message) {
        super(message);
    }
    public DataPersistFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
