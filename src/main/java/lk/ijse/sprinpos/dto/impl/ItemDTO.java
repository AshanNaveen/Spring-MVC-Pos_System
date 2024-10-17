package lk.ijse.sprinpos.dto.impl;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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
public class ItemDTO implements SuperDTO, ItemResponse {
    private String id;
    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, max = 40, message = "Name must be between 3 and 40 characters")
    private String name;
    @NotBlank(message = "Price is mandatory")
    @Positive(message = "Price must be a positive number")
    @Size(min = 1, max = 10, message = "Price must be between 1 and 10 digits")
    private double price;
    @NotBlank(message = "Quantity is mandatory")
    @Positive(message = "Quantity must be a positive number")
    @Size(min = 1, max = 20, message = "Quantity must be between 1 and 20 digits")
    private int quantity;
    private String[] orderDetails;
}
