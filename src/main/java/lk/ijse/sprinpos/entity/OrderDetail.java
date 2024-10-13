package lk.ijse.sprinpos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Naveen Theekshana
 * @date 10/12/2024
 * @project SpringPos
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private float id;
    @Column(columnDefinition ="default 1")
    private int qtyOnOrder;
    @ManyToOne
    @JoinColumn(name = "itemId",nullable = false)
    private Item item;
    @ManyToOne
    @JoinColumn(name = "orderId",nullable = false)
    private Order order;
}
