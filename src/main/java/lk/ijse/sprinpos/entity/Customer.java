package lk.ijse.sprinpos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
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
public class Customer {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(unique=true, nullable=false,length=100)
    private String email;
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Order> order=new ArrayList<>();
}
