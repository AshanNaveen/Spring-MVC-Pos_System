package lk.ijse.sprinpos.service;

import lk.ijse.sprinpos.dto.ItemDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Naveen Theekshana
 * @date 10/13/2024
 * @project SpringPos
 */

@Service
public interface ItemService {
    void saveItem(ItemDTO itemDTO);
    void updateItem(String id, ItemDTO itemDTO);
    void deleteItem(String id);
    ItemDTO getSelectedItem(String id);
    List<ItemDTO> getAllItems();
}
