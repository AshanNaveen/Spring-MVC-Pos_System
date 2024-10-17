package lk.ijse.sprinpos.dto.impl;

import lk.ijse.sprinpos.customObj.OrderResponse;
import lk.ijse.sprinpos.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Naveen Theekshana
 * @date 10/12/2024
 * @project SpringPos
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDTO implements SuperDTO, OrderResponse {
    private String id;
    private Timestamp createdTimestamp;
    private List<OrderDetailDTO> orderDetails = new ArrayList<>();
    private String customerId;
}
