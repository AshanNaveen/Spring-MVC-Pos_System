package lk.ijse.sprinpos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Naveen Theekshana
 * @date 10/12/2024
 * @project SpringPos
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_detail")
public class OrderDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "INTEGER DEFAULT 1")
    private Integer qtyOnOrder;
    @ManyToOne
    @JoinColumn(name = "itemId",nullable = false)
    private Item item;
    @ManyToOne
    @JoinColumn(name = "orderId",nullable = false)
    @JsonIgnore
    private Order order;
}
