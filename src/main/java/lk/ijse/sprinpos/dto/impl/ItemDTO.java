package lk.ijse.sprinpos.dto.impl;

import lk.ijse.sprinpos.customObj.ItemResponse;
import lk.ijse.sprinpos.dto.SuperDTO;
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
public class ItemDTO implements SuperDTO , ItemResponse {
    private String id;
    private String name;
    private double price;
    private int quantity;
    private String[] orderDetails;
}
