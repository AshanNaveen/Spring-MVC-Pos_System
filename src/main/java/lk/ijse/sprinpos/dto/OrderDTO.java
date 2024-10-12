package lk.ijse.sprinpos.dto;

import lk.ijse.sprinpos.entity.Customer;

import java.sql.Timestamp;

/**
 * @author Naveen Theekshana
 * @date 10/12/2024
 * @project SpringPos
 */
public class OrderDTO {
    private String id;
    private Timestamp createdTimestamp;
    private String orderDetails;
    private Customer customer;
}
