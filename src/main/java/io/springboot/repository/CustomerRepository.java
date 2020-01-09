package io.springboot.repository;

import io.springboot.db.Customer;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomerRepository {

    private Customer sharedCustomer = new Customer();

    public List<Customer> findAll() {
        return Arrays.asList(new Customer());

    }

    public Customer findById(Long id) {
        return sharedCustomer;
    }
}
