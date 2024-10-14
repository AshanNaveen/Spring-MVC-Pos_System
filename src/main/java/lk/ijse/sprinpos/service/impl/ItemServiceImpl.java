package lk.ijse.sprinpos.service.impl;

import lk.ijse.sprinpos.dao.ItemDao;
import lk.ijse.sprinpos.dto.ItemDTO;
import lk.ijse.sprinpos.entity.Item;
import lk.ijse.sprinpos.exceptions.ItemNotFoundException;
import lk.ijse.sprinpos.service.ItemService;
import lk.ijse.sprinpos.util.AppUtil;
import lk.ijse.sprinpos.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Naveen Theekshana
 * @date 10/13/2024
 * @project SpringPos
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveItem(ItemDTO itemDTO) {
        Item item = mapping.toItem(itemDTO);
        item.setId(AppUtil.getItemId());
        itemDao.save(item);
    }

    @Override
    public void updateItem(String id, ItemDTO itemDTO) {
        Optional<Item> item = itemDao.findById(id);
        if (item.isPresent()) {
           item.get().setName(itemDTO.getName());
           item.get().setQuantity(itemDTO.getQuantity());
           item.get().setPrice(itemDTO.getPrice());

        }else
            throw  new ItemNotFoundException();
    }

    @Override
    public void deleteItem(String id) {
        Optional<Item> item = itemDao.findById(id);
        if (item.isPresent()) {
            itemDao.delete(item.get());
        }else
            throw  new ItemNotFoundException();
    }

    @Override
    public ItemDTO getSelectedItem(String id) {
        Optional<Item> item = itemDao.findById(id);
        if (item.isPresent()) {
            return mapping.toItemDTO(item.get());
        }else
            throw  new ItemNotFoundException();
    }

    @Override
    public List<ItemDTO> getAllItems() {
        return mapping.toItemDTOList(itemDao.findAll());
    }
}
