package lk.ijse.sprinpos.customObj;

import java.io.Serializable;

/**
 * @author Naveen Theekshana
 * @date 17/10/2024
 * @project SpringPos
 */
public class OrderErrorResponse implements OrderResponse , Serializable {
    private int errorCode;
    private String errorMessage;
}
