package lk.ijse.sprinpos.service.impl;

import lk.ijse.sprinpos.dto.OrderDTO;
import lk.ijse.sprinpos.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Naveen Theekshana
 * @date 10/13/2024
 * @project SpringPos
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public void saveOrder(OrderDTO orderDTO) {

    }

    @Override
    public void updateOrder(String id, OrderDTO orderDTO) {

    }

    @Override
    public void deleteOrder(String id) {

    }

    @Override
    public OrderDTO getSelectedOrder(String id) {
        return null;
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return List.of();
    }
}
