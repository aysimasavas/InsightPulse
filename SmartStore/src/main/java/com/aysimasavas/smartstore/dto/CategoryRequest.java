package com.aysimasavas.smartstore.dto;

import com.aysimasavas.smartstore.entity.Category;
import com.aysimasavas.smartstore.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryRequest {

    private String name;

    public Category mapToCategory() {
        return Category.builder()
                .name(name)
                .build();
    }
}
