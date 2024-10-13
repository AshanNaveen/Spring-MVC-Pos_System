package lk.ijse.sprinpos.dao;

import lk.ijse.sprinpos.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Naveen Theekshana
 * @date 10/13/2024
 * @project SpringPos
 */
public interface OrderDetailDao extends JpaRepository<OrderDetail, String> {
}
