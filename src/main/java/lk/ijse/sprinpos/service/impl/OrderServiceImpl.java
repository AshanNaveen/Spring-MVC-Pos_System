package lk.ijse.sprinpos.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.sprinpos.dao.CustomerDao;
import lk.ijse.sprinpos.dao.ItemDao;
import lk.ijse.sprinpos.dao.OrderDao;
import lk.ijse.sprinpos.dao.OrderDetailDao;
import lk.ijse.sprinpos.dto.impl.OrderDTO;
import lk.ijse.sprinpos.entity.Customer;
import lk.ijse.sprinpos.entity.Item;
import lk.ijse.sprinpos.entity.Order;
import lk.ijse.sprinpos.entity.OrderDetail;
import lk.ijse.sprinpos.exceptions.CustomerNotFoundException;
import lk.ijse.sprinpos.exceptions.ItemNotFoundException;
import lk.ijse.sprinpos.exceptions.OrderNotFoundException;
import lk.ijse.sprinpos.service.OrderService;
import lk.ijse.sprinpos.util.AppUtil;
import lk.ijse.sprinpos.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Naveen Theekshana
 * @date 10/13/2024
 * @project SpringPos
 */
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;
    private OrderDetailDao orderDetailDao;
    private ItemDao itemDao;
    private CustomerDao customerDao;
    private Mapping mapping;
    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    @Transactional
    public void saveOrder(OrderDTO orderDTO) {
        Customer customer = customerDao.findById(orderDTO.getCustomerId())
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID: " + orderDTO.getCustomerId()));

        Order order = new Order();
        order.setId(AppUtil.getOrderId());
        order.setCreatedTimestamp(orderDTO.getCreatedTimestamp());
        order.setCustomer(customer);

        // Order Save
        orderDao.save(order);

        List<OrderDetail> orderDetails = orderDTO.getOrderDetails().stream().map(orderDetailDTO -> {
            Item item = itemDao.findById(orderDetailDTO.getItemId())
                    .orElseThrow(() -> new ItemNotFoundException("Item not found with ID: " + orderDetailDTO.getItemId()));
            return new OrderDetail(null, orderDetailDTO.getQtyOnOrder(), item, order);
        }).collect(Collectors.toList());

        // Set the order details to the order
        order.setOrderDetails(orderDetails);

        // Order Detail Save
        orderDetailDao.saveAll(orderDetails);

        // Item Quantity Update
        orderDetails.forEach(orderDetail -> {
            Item item = orderDetail.getItem();
            item.setQuantity(item.getQuantity() - orderDetail.getQtyOnOrder());
            itemDao.save(item);
        });

        logger.info("Saved Order : {} ", order.getId());
    }

    @Override
    @Transactional
    public void updateOrder(String id, OrderDTO orderDTO) {
        Order order = orderDao.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with ID: " + id));

        Customer customer = customerDao.findById(orderDTO.getCustomerId())
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID: " + orderDTO.getCustomerId()));

        order.setCreatedTimestamp(orderDTO.getCreatedTimestamp());
        order.setCustomer(customer);

        // Clear existing order details
        order.getOrderDetails().clear();

        // Add new order details
        List<OrderDetail> orderDetails = orderDTO.getOrderDetails().stream().map(orderDetailDTO -> {
            Item item = itemDao.findById(orderDetailDTO.getItemId())
                    .orElseThrow(() -> new ItemNotFoundException("Item not found with ID: " + orderDetailDTO.getItemId()));
            return new OrderDetail(null, orderDetailDTO.getQtyOnOrder(), item, order);
        }).collect(Collectors.toList());

        order.setOrderDetails(orderDetails);

        // Save updated order
        orderDao.save(order);

        // Save updated order details
        orderDetailDao.saveAll(orderDetails);

        // Update item quantities
        orderDetails.forEach(orderDetail -> {
            Item item = orderDetail.getItem();
            item.setQuantity(item.getQuantity() - orderDetail.getQtyOnOrder());
            itemDao.save(item);
        });

        logger.info("Updated Order : {} ", id);
    }

    @Override
    @Transactional
    public void deleteOrder(String id) {
        Order order = orderDao.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with ID: " + id));

        // Update item quantities before deleting order details
        order.getOrderDetails().forEach(orderDetail -> {
            Item item = orderDetail.getItem();
            item.setQuantity(item.getQuantity() + orderDetail.getQtyOnOrder());
            itemDao.save(item);
        });

        // Delete order details
        orderDetailDao.deleteAll(order.getOrderDetails());

        // Remove the reference to order details to avoid transient instance exception
        order.setOrderDetails(new ArrayList<>());

        // Save the order to update the reference
        orderDao.save(order);

        // Delete order
        orderDao.delete(order);

        logger.info("Deleted Order : {} ", id);
    }

    @Override
    public OrderDTO getSelectedOrder(String id) {
        Optional<Order> orderOptional = orderDao.findById(id);
        if (orderOptional.isPresent()) {
            OrderDTO orderDTO = mapping.toOrderDTO(orderOptional.get());
            logger.info("Returned Order : {} ", id);
            return orderDTO;
        } else {
            throw new OrderNotFoundException("Order with ID " + id + " not found");
        }
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderDao.findAll();
        logger.info("Returned list of Orders : {} ", orders.stream().map(Order::getId));
        return mapping.toOrderDTOList(orders);
    }
}
