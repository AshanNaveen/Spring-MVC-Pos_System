package lk.ijse.sprinpos.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lk.ijse.sprinpos.customObj.CustomerErrorResponse;
import lk.ijse.sprinpos.customObj.CustomerResponse;
import lk.ijse.sprinpos.dto.impl.CustomerDTO;
import lk.ijse.sprinpos.exceptions.CustomerNotFoundException;
import lk.ijse.sprinpos.exceptions.DataPersistFailedException;
import lk.ijse.sprinpos.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @GetMapping(value = "/{custId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerResponse getCustomer(@PathVariable("custId") String custId, HttpServletRequest request) {
        CustomerDTO customer = customerService.getSelectedCustomer(custId);
        logger.info("Received request to get customer on " + request.getRemoteAddr());
        return customer == null ? new CustomerErrorResponse() : customer;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDTO> getAllCustomers(HttpServletRequest request) {
        logger.info("Received request to get all customers on " + request.getRemoteAddr());
        return customerService.getAllCustomers();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createCustomer(@Valid @RequestBody CustomerDTO dto, HttpServletRequest request) {
        try {
            customerService.saveCustomer(dto);
            logger.info("Received request to save customer on " + request.getRemoteAddr());
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistFailedException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{custId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateCustomer(@PathVariable("custId") String custId,@Valid @RequestBody CustomerDTO dto, HttpServletRequest request) {
        try {
            customerService.updateCustomer(custId, dto);
            logger.info("Received request to update customer on " + request.getRemoteAddr());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{custId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("custId") String custId, HttpServletRequest request) {
        try {
            customerService.deleteCustomer(custId);
            logger.info("Received request to delete customer on " + request.getRemoteAddr());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
