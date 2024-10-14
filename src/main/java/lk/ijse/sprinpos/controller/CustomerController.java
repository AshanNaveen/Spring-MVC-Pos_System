package lk.ijse.sprinpos.controller;

import lk.ijse.sprinpos.customObj.CustomerErrorResponse;
import lk.ijse.sprinpos.customObj.CustomerResponce;
import lk.ijse.sprinpos.dto.impl.CustomerDTO;
import lk.ijse.sprinpos.exceptions.CustomerNotFoundException;
import lk.ijse.sprinpos.exceptions.DataPersistFailedException;
import lk.ijse.sprinpos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Naveen Theekshana
 * @date 10/11/2024
 * @project SpringPos
 */

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/{custId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerResponce getCustomer(@PathVariable("custId") String custId) {
        CustomerDTO customer = customerService.getSelectedCustomer(custId);
        return customer==null ? new CustomerErrorResponse():customer;
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createCustomer(@RequestBody CustomerDTO dto) {
        try{
            customerService.saveCustomer(dto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistFailedException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{custId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateCustomer(@PathVariable("custId") String custId , @RequestBody CustomerDTO dto) {
        try {
            customerService.updateCustomer(custId, dto);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (CustomerNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{custId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("custId") String custId) {
        try {
            customerService.deleteCustomer(custId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (CustomerNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
