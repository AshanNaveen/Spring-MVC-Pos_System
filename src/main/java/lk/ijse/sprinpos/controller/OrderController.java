package lk.ijse.sprinpos.controller;

import jakarta.servlet.http.HttpServletRequest;
import lk.ijse.sprinpos.customObj.OrderErrorResponse;
import lk.ijse.sprinpos.customObj.OrderResponse;
import lk.ijse.sprinpos.dto.impl.OrderDTO;
import lk.ijse.sprinpos.exceptions.CustomerNotFoundException;
import lk.ijse.sprinpos.exceptions.DataPersistFailedException;
import lk.ijse.sprinpos.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
@RequiredArgsConstructor
public class OrderController {

    private OrderService orderService;
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @GetMapping(value = "/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderResponse getOrder(@PathVariable("orderId") String orderId, HttpServletRequest request) {
        OrderDTO order = orderService.getSelectedOrder(orderId);
        logger.info("Received request to get order on " + request.getRemoteAddr());
        return order == null ? new OrderErrorResponse() : order;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDTO> getAllOrders(HttpServletRequest request) {
        logger.info("Received request to get all orders on " + request.getRemoteAddr());
        return orderService.getAllOrders();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createOrder(@RequestBody OrderDTO order, HttpServletRequest request) {
        try {
            orderService.saveOrder(order);
            logger.info("Received request to save order on " + request.getRemoteAddr());
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistFailedException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{orderId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateOrder(@PathVariable("orderId") String orderId, @RequestBody OrderDTO orderDTO, HttpServletRequest request) {
        try {
            orderService.updateOrder(orderId, orderDTO);
            logger.info("Received request to update order on " + request.getRemoteAddr());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("orderId") String orderId , HttpServletRequest request) {
        try {
            orderService.deleteOrder(orderId);
            logger.info("Received request to delete order on " + request.getRemoteAddr());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
