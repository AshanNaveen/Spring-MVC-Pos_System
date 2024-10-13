package lk.ijse.sprinpos.dao;

import lk.ijse.sprinpos.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Naveen Theekshana
 * @date 10/13/2024
 * @project SpringPos
 */
@Repository
public interface ItemDao extends JpaRepository<Item, String> {
}
