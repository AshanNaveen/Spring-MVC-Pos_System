package lk.ijse.sprinpos.customObj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Naveen Theekshana
 * @date 10/15/2024
 * @project SpringPos
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerErrorResponse implements Serializable , CustomerResponce{
    private int errorCode;
    private String errorMessage;
}
