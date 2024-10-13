package lk.ijse.sprinpos.exceptions;

import lombok.NoArgsConstructor;

/**
 * @author Naveen Theekshana
 * @date 10/13/2024
 * @project SpringPos
 */
@NoArgsConstructor
public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String message){}
    public CustomerNotFoundException(String message, Throwable cause){}
}
