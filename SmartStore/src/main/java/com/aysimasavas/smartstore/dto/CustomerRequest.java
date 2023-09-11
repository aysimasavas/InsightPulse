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
public class CustomerRequest {

    private String name;
    private String email;

    public Customer mapToCustomer() {
        return Customer.builder()
                .name(name)
                .email(email)
                .build();
    }
}
