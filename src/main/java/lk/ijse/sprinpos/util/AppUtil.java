package lk.ijse.sprinpos.util;

import java.util.UUID;

/**
 * @author Naveen Theekshana
 * @date 10/13/2024
 * @project SpringPos
 */
public class AppUtil {
    public static String getCustomerId(){
        return "C"+ UUID.randomUUID();
    }
    public static String getItemId(){
        return "I"+ UUID.randomUUID();
    }
    public static String getOrderId(){
        return "O"+ UUID.randomUUID();
    }
}
