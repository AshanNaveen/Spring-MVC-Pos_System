package lk.ijse.sprinpos.dto.impl;


import lk.ijse.sprinpos.customObj.CustomerResponce;
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
public class CustomerDTO implements SuperDTO, CustomerResponce {
    private String id;
    private String name;
    private String address;
    private String email;
    private String[] order;
}
