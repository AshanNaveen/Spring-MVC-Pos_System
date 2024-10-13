package lk.ijse.sprinpos.service.impl;

import lk.ijse.sprinpos.dto.CustomerDTO;
import lk.ijse.sprinpos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Naveen Theekshana
 * @date 10/13/2024
 * @project SpringPos
 */
public class CustomerServiceImpl implements CustomerService {
    @Override
    public void saveCustomer(CustomerDTO customerDTO) {

    }

    @Override
    public void updateCustomer(String id, CustomerDTO customerDTO) {

    }

    @Override
    public void deleteCustomer(String id) {

    }

    @Override
    public CustomerDTO getSelectedCustomer(String id) {
        return null;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return List.of();
    }
}
