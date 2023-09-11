package com.aysimasavas.smartstore.service;

import com.aysimasavas.smartstore.dto.CustomerRequest;
import com.aysimasavas.smartstore.dto.CustomerResponse;
import com.aysimasavas.smartstore.entity.Customer;
import com.aysimasavas.smartstore.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerResponse createCustomer(CustomerRequest customerRequest){
        Customer customer=customerRequest.mapToCustomer();
        Customer savedCustomer=customerRepository.save(customer);
        return CustomerResponse.mapCustomer(savedCustomer);
    }

    public List<CustomerResponse> getAllCustomers(){
        List<Customer> customers=customerRepository.findAll();
        return customers.stream().map(CustomerResponse::mapCustomer).toList();

    }
}
