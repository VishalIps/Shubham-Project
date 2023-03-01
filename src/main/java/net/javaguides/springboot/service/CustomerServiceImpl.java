package net.javaguides.springboot.service;

import lombok.Data;
import net.javaguides.springboot.model.Customer;
import net.javaguides.springboot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> search() {
        return customerRepository.search();
    }


}
