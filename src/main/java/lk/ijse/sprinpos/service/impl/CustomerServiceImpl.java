package lk.ijse.sprinpos.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.sprinpos.dao.CustomerDao;
import lk.ijse.sprinpos.dto.impl.CustomerDTO;
import lk.ijse.sprinpos.entity.Customer;
import lk.ijse.sprinpos.exceptions.CustomerNotFoundException;
import lk.ijse.sprinpos.service.CustomerService;
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
public class CustomerServiceImpl implements CustomerService {

    private final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
    private final Mapping mapping;
    private final CustomerDao customerDao;

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        Customer customer = mapping.toCustomer(customerDTO);
        customer.setId(AppUtil.getCustomerId());
        customerDao.save(customer);
        logger.info("Saved Customer : {} ", customer.getId());
    }

    @Override
    @Transactional
    public void updateCustomer(String id, CustomerDTO customerDTO) {
        Optional<Customer> customer = customerDao.findById(id);
        if (customer.isPresent()) {
            customer.get().setAddress(customerDTO.getAddress());
            customer.get().setEmail(customerDTO.getEmail());
            customer.get().setName(customerDTO.getName());
            logger.info("Updated Customer : {} ", id);
        } else {
            throw new CustomerNotFoundException("Customer not found with ID: "+id);
        }
    }

    @Override
    public void deleteCustomer(String id) {
        Optional<Customer> customer = customerDao.findById(id);
        if (customer.isPresent()) {
            customerDao.delete(customer.get());
            logger.info("Deleted Customer : {} ", id);
        }else
            throw new CustomerNotFoundException("Customer not found with ID: "+id);

    }

    @Override
    public CustomerDTO getSelectedCustomer(String id) {
        Optional<Customer> customer= customerDao.findById(id);
        if (customer.isPresent()){
            CustomerDTO customerDTO = mapping.toCustomerDTO(customer.get());
            logger.info("Returned Customer : {} ", id);
            return customerDTO;
        }else
            throw new CustomerNotFoundException("Customer not found with ID: "+id);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerDao.findAll();
        logger.info("Returned list of Customers : {} ",customers.stream().map(Customer::getId));
        return mapping.toCustomerDTOList(customers);
    }
}
