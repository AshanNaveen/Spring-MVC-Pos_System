package lk.ijse.sprinpos.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Naveen Theekshana
 * @date 10/11/2024
 * @project SpringPos
 */

@ResponseStatus
@CrossOrigin("*")
@RequestMapping("api/v1/customer")
public class CustomerController {

    @GetMapping(value = "/{custId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getCustomer(@PathVariable String custId) {

        return "Customer Saved";
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String getAllCustomers() {

        return "Customer List";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createCustomer() {

    }

    @PutMapping(value = "/{custId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCustomer(@PathVariable String custId) {

    }

    @DeleteMapping(value = "/{custId}")
    public void deleteCustomer(@PathVariable String custId) {

    }
}
