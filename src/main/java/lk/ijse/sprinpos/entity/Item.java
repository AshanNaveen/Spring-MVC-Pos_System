package lk.ijse.sprinpos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class Item {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private int quantity;
    @Column(columnDefinition = "LONGTEXT")
    private String picture;
    @OneToMany(mappedBy = "item")
    private List<OrderDetail> orderDetails;
}
