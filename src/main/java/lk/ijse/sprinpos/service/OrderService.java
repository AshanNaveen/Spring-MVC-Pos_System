package lk.ijse.sprinpos.service;

import lk.ijse.sprinpos.dto.impl.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Naveen Theekshana
 * @date 10/13/2024
 * @project SpringPos
 */
@Service
public interface OrderService {
    void saveOrder(OrderDTO orderDTO);
    void updateOrder(String id, OrderDTO orderDTO);
    void deleteOrder(String id);
    OrderDTO getSelectedOrder(String id);
    List<OrderDTO> getAllOrders();
}
