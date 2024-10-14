package lk.ijse.sprinpos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Naveen Theekshana
 * @date 10/12/2024
 * @project SpringPos
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private String id;
    private String name;
    private double price;
    private int quantity;
    private String[] orderDetails;
}
