package lk.ijse.sprinpos.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Naveen Theekshana
 * @date 10/12/2024
 * @project SpringPos
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetailDTO {
    private int qtyOnOrder;
    private String itemId;
    private String orderId;
}
