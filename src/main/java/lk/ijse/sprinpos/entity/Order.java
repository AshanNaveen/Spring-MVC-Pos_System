package lk.ijse.sprinpos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Naveen Theekshana
 * @date 10/12/2024
 * @project SpringPos
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    private String id;
    @CreationTimestamp
    private Timestamp createdTimestamp;
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderDetail> orderDetails = new ArrayList<>();
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;
}
