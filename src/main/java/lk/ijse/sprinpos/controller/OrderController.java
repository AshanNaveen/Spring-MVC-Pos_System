package lk.ijse.sprinpos.controller;

import lk.ijse.sprinpos.dto.impl.OrderDTO;
import lk.ijse.sprinpos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Naveen Theekshana
 * @date 10/12/2024
 * @project SpringPos
 */
@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderDTO getOrder(@PathVariable("orderId") String orderId) {
        return orderService.getSelectedOrder(orderId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody OrderDTO order) {
        orderService.saveOrder(order);
    }

    @PutMapping(value = "/{orderId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateOrder(@PathVariable("orderId") String orderId, @RequestBody OrderDTO orderDTO) {
        orderService.updateOrder(orderId, orderDTO);
    }

    @DeleteMapping(value = "/{orderId}")
    public void deleteOrder(@PathVariable("orderId") String orderId) {
        orderService.deleteOrder(orderId);
    }
}
