package lk.ijse.sprinpos.util;

import lk.ijse.sprinpos.dto.impl.CustomerDTO;
import lk.ijse.sprinpos.dto.impl.ItemDTO;
import lk.ijse.sprinpos.dto.impl.OrderDTO;
import lk.ijse.sprinpos.dto.impl.OrderDetailDTO;
import lk.ijse.sprinpos.entity.Customer;
import lk.ijse.sprinpos.entity.Item;
import lk.ijse.sprinpos.entity.Order;
import lk.ijse.sprinpos.entity.OrderDetail;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Naveen Theekshana
 * @date 10/13/2024
 * @project SpringPos
 */
@Component
public class Mapping {
    @Autowired
    ModelMapper modelMapper;

    public CustomerDTO toCustomerDTO(Customer customer) {
        return modelMapper.map(customer, CustomerDTO.class);
    }
    public Customer toCustomer(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, Customer.class);
    }
    public ItemDTO toItemDTO(Item item) {
        return modelMapper.map(item, ItemDTO.class);
    }
    public Item toItem(ItemDTO itemDTO) {
        return modelMapper.map(itemDTO, Item.class);
    }
    public OrderDTO toOrderDTO(Order order) {
        return modelMapper.map(order, OrderDTO.class);
    }
    public Order toOrder(OrderDTO orderDTO) {
        return modelMapper.map(orderDTO, Order.class);
    }
    public OrderDetailDTO toOrderDetailDTO(Order order) {
        return modelMapper.map(order, OrderDetailDTO.class);
    }
    public OrderDetail toOrderDetail(OrderDetailDTO orderDetailDTO) {
        return modelMapper.map(orderDetailDTO, OrderDetail.class);
    }
    public List<OrderDetailDTO> toOrderDetailDTOList(List<OrderDetail> orderDetailList) {
        return modelMapper.map(orderDetailList, new TypeToken<List<OrderDetailDTO>>() {}.getType());
    }
    public List<OrderDetail> toOrderDetailList(List<OrderDetailDTO> orderDetailDTOList) {
        return modelMapper.map(orderDetailDTOList, new TypeToken<List<OrderDetail>>() {}.getType());
    }
    public List<Order> toOrderList(List<OrderDTO> orderDTOList) {
        return modelMapper.map(orderDTOList, new TypeToken<List<Order>>() {}.getType());
    }
    public List<OrderDTO> toOrderDTOList(List<Order> orderList) {
        return modelMapper.map(orderList, new TypeToken<List<OrderDTO>>() {}.getType());
    }
    public List<Customer> toCustomerList(List<CustomerDTO> customerDTOList) {
        return modelMapper.map(customerDTOList, new TypeToken<List<Customer>>() {}.getType());
    }
    public List<CustomerDTO> toCustomerDTOList(List<Customer> customerList) {
        return modelMapper.map(customerList, new TypeToken<List<CustomerDTO>>() {}.getType());
    }
    public List<Item> toItemList(List<ItemDTO> itemDTOList) {
        return modelMapper.map(itemDTOList, new TypeToken<List<Item>>() {}.getType());
    }
    public List<ItemDTO> toItemDTOList(List<Item> itemList) {
        return modelMapper.map(itemList, new TypeToken<List<ItemDTO>>() {}.getType());
    }

}
