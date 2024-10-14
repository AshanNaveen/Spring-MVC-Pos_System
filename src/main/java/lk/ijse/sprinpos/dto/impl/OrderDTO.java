package lk.ijse.sprinpos.dto.impl;

import lk.ijse.sprinpos.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @author Naveen Theekshana
 * @date 10/12/2024
 * @project SpringPos
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDTO {
    private String id;
    private Timestamp createdTimestamp;
    private String orderDetails;
    private Customer customer;
}
