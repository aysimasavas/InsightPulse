package com.aysimasavas.smartstore.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "Customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    private String id;
    private String name;
    private String email;
}
