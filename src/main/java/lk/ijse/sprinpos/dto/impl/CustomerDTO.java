package lk.ijse.sprinpos.dto.impl;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lk.ijse.sprinpos.customObj.CustomerResponse;
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
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO implements SuperDTO, CustomerResponse {
    private String id;
    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, max = 40, message = "Name must be between 3 and 40 characters")
    private String name;
    @NotBlank(message = "Address is mandatory")
    @Size(min = 3, max = 30, message = "Address must be between 3 and 30 characters")
    private String address;
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Please provide a valid email address")
    @Size(min = 5, max = 50, message = "Email must be between 5 and 50 characters")
    private String email;
    private String[] order;
}
