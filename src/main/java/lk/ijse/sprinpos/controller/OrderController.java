package lk.ijse.sprinpos.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Naveen Theekshana
 * @date 10/12/2024
 * @project SpringPos
 */
@ResponseStatus
@CrossOrigin("*")
@RequestMapping("api/v1/orders")
public class OrderController {
    @GetMapping(value = "/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getOrder(@PathVariable String orderId) {

        return "Order Saved Successfully";
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String getAllOrders() {

        return "Orders List";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createOrder() {

    }

    @PutMapping(value = "/{orderId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateOrder(@PathVariable String orderId) {

    }

    @DeleteMapping(value = "/{orderId}")
    public void deleteOrder(@PathVariable String orderId) {

    }
}
