package com.aysimasavas.smartstore.controller;

import com.aysimasavas.smartstore.dto.ProductRequest;
import com.aysimasavas.smartstore.dto.ProductResponse;
import com.aysimasavas.smartstore.entity.Product;
import com.aysimasavas.smartstore.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    private ProductResponse createProduct(@RequestBody ProductRequest request) {
        return productService.createProduct(request);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    private List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    private ProductResponse getProductById(@PathVariable String id) {
       return productService.getProductById(id);
    }

    @RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
    private List<ProductResponse> getAllProducts(@PathVariable String categoryId) {
        return productService.getProductsByCategoryId(categoryId);
    }
}
