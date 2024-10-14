package lk.ijse.sprinpos.service.impl;

import lk.ijse.sprinpos.dao.CustomerDao;
import lk.ijse.sprinpos.dto.CustomerDTO;
import lk.ijse.sprinpos.entity.Customer;
import lk.ijse.sprinpos.exceptions.CustomerNotFoundException;
import lk.ijse.sprinpos.service.CustomerService;
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
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private Mapping mapping;

    @Autowired
    private CustomerDao customerDao;

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        Customer customer = mapping.toCustomer(customerDTO);
        customer.setId(AppUtil.getCustomerId());
        customerDao.save(customer);
    }

    @Override
    public void updateCustomer(String id, CustomerDTO customerDTO) {
        Optional<Customer> customer = customerDao.findById(id);
        if (customer.isPresent()) {
            customer.get().setAddress(customerDTO.getAddress());
            customer.get().setEmail(customerDTO.getEmail());
            customer.get().setName(customerDTO.getName());
        }else
            throw new CustomerNotFoundException();

    }

    @Override
    public void deleteCustomer(String id) {
        Optional<Customer> customer = customerDao.findById(id);
        if (customer.isPresent()) {
            customerDao.delete(customer.get());
        }else
            throw new CustomerNotFoundException();

    }

    @Override
    public CustomerDTO getSelectedCustomer(String id) {
        Optional<Customer> customer= customerDao.findById(id);
        if (customer.isPresent()){
            return mapping.toCustomerDTO(customer.get());
        }else
            throw new CustomerNotFoundException();
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return mapping.toCustomerDTOList(customerDao.findAll());
    }
}
