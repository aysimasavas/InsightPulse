package com.aysimasavas.smartstore.controller;

import com.aysimasavas.smartstore.dto.CustomerRequest;
import com.aysimasavas.smartstore.dto.CustomerResponse;
import com.aysimasavas.smartstore.service.CustomerService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public CustomerResponse createCustomer(@RequestBody CustomerRequest request){
        return customerService.createCustomer(request);
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<CustomerResponse> getAllCustomers(){
        return customerService.getAllCustomers();
    }
}
