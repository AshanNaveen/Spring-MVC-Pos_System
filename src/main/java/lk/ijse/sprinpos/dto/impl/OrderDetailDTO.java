package lk.ijse.sprinpos.dto.impl;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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
    @NotBlank(message = "QtyOnOrder is mandatory")
    @Positive(message = "QtyOnOrder must be a positive number")
    @Size(min = 1, max = 20, message = "QtyOnOrder must be between 1 and 20 digits")
    private int qtyOnOrder;
    private String itemId;
    private String orderId;
}
