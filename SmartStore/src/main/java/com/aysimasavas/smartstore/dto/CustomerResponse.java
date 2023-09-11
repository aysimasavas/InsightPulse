package com.aysimasavas.smartstore.dto;

import com.aysimasavas.smartstore.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponse {

    private String id;
    private String name;
    private String email;

    public static CustomerResponse mapCustomer(Customer customer) {
        return CustomerResponse.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .build();
    }
}

/*
USER -> CustomerRequest
->
API -> CUSTOMER
-> *
USER -> CustomerResponse
 */