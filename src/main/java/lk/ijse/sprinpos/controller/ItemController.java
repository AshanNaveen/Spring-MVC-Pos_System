package lk.ijse.sprinpos.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Naveen Theekshana
 * @date 10/12/2024
 * @project SpringPos
 */
@ResponseStatus
@CrossOrigin("*")
@RequestMapping("api/v1/items")
public class ItemController {
    @GetMapping(value = "/{itemId}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public String getItem(@PathVariable int itemId) {
        return "Item Created Successfully";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getItems() {
       return "Item List";
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void createItem() {

    }

    @PutMapping(value = "/{itemId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateItem(@PathVariable String itemId) {

    }

    @DeleteMapping(value = "/{itemId}")
    public void deleteItem(@PathVariable String itemId) {

    }
}
