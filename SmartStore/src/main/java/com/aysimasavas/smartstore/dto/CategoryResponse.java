package com.aysimasavas.smartstore.dto;

import com.aysimasavas.smartstore.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryResponse {

    private String id;
    private String name;

    public static CategoryResponse mapCategory(Category category){
        return CategoryResponse.builder().id(category.getId())
                .name(category.getName())
                .build();
    }
}
