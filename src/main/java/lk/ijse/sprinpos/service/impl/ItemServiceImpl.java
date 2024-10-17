package lk.ijse.sprinpos.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.sprinpos.dao.ItemDao;
import lk.ijse.sprinpos.dto.impl.ItemDTO;
import lk.ijse.sprinpos.entity.Item;
import lk.ijse.sprinpos.exceptions.ItemNotFoundException;
import lk.ijse.sprinpos.service.ItemService;
import lk.ijse.sprinpos.util.AppUtil;
import lk.ijse.sprinpos.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private static final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);
    private ItemDao itemDao;
    private Mapping mapping;

    @Override
    public void saveItem(ItemDTO itemDTO) {
        Item item = mapping.toItem(itemDTO);
        item.setId(AppUtil.getItemId());
        itemDao.save(item);
        logger.info("Saved Item : {} ", item.getId());
    }

    @Override
    @Transactional
    public void updateItem(String id, ItemDTO itemDTO) {
        Optional<Item> item = itemDao.findById(id);
        if (item.isPresent()) {
            item.get().setName(itemDTO.getName());
            item.get().setQuantity(itemDTO.getQuantity());
            item.get().setPrice(itemDTO.getPrice());
            logger.info("Updated Item : {} ", id);
        } else
            throw new ItemNotFoundException("Item not found with ID: "+id);
    }

    @Override
    public void deleteItem(String id) {
        Optional<Item> item = itemDao.findById(id);
        if (item.isPresent()) {
            itemDao.delete(item.get());
            logger.info("Deleted Item : {} ", id);
        } else
            throw new ItemNotFoundException("Item not found with ID: "+id);
    }

    @Override
    public ItemDTO getSelectedItem(String id) {
        Optional<Item> item = itemDao.findById(id);
        if (item.isPresent()) {
            ItemDTO itemDTO = mapping.toItemDTO(item.get());
            logger.info("Returned Item : {} ", id);
            return itemDTO;
        } else
            throw new ItemNotFoundException("Item not found with ID: "+id);
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<ItemDTO> itemDTOList = mapping.toItemDTOList(itemDao.findAll());
        logger.info("Returned list of Items : {} ", itemDTOList.stream().map(ItemDTO::getId));
        return itemDTOList;
    }
}
