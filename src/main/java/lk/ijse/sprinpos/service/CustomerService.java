package lk.ijse.sprinpos.service;

import lk.ijse.sprinpos.dto.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Naveen Theekshana
 * @date 10/13/2024
 * @project SpringPos
 */
@Service
public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);
    void updateCustomer(String id, CustomerDTO customerDTO);
    void deleteCustomer(String id);
    CustomerDTO getSelectedCustomer(String id);
    List<CustomerDTO> getAllCustomers();
}
