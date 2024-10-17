package lk.ijse.sprinpos.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lk.ijse.sprinpos.customObj.ItemErrorResponse;
import lk.ijse.sprinpos.customObj.ItemResponse;
import lk.ijse.sprinpos.dto.impl.ItemDTO;
import lk.ijse.sprinpos.exceptions.DataPersistFailedException;
import lk.ijse.sprinpos.exceptions.ItemNotFoundException;
import lk.ijse.sprinpos.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Naveen Theekshana
 * @date 10/12/2024
 * @project SpringPos
 */
@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;
    private final Logger logger = LoggerFactory.getLogger(ItemController.class);

    @GetMapping(value = "/{itemId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemResponse getItem(@PathVariable("itemId") String itemId, HttpServletRequest request) {
        ItemDTO item = itemService.getSelectedItem(itemId);
        logger.info("Received request to get item on " + request.getRemoteAddr());
        return item == null ? new ItemErrorResponse() : item;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemDTO> getItems(HttpServletRequest request) {
        List<ItemDTO> allItems = itemService.getAllItems();
        logger.info("Received request to get all items on " + request.getRemoteAddr());
        return allItems;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createItem(@Valid @RequestBody ItemDTO itemDTO, HttpServletRequest request) {
        try {
            itemService.saveItem(itemDTO);
            logger.info("Received request to save item on " + request.getRemoteAddr());
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistFailedException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{itemId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateItem(@PathVariable("itemId") String itemId, @Valid @RequestBody ItemDTO dto, HttpServletRequest request) {
        try {
            itemService.updateItem(itemId, dto);
            logger.info("Received request to update item on " + request.getRemoteAddr());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ItemNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{itemId}")
    public ResponseEntity<String> deleteItem(@PathVariable("itemId") String itemId, HttpServletRequest request) {
        try {
            itemService.deleteItem(itemId);
            logger.info("Received request to delete item on " + request.getRemoteAddr());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ItemNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
