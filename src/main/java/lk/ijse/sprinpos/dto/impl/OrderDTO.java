package lk.ijse.sprinpos.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

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
    private List<OrderDetailDTO> orderDetails;
    private String customerId;
}
