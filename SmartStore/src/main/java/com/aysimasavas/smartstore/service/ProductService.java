package com.aysimasavas.smartstore.service;

import com.aysimasavas.smartstore.dto.ProductRequest;
import com.aysimasavas.smartstore.dto.ProductResponse;
import com.aysimasavas.smartstore.entity.Product;
import com.aysimasavas.smartstore.insightpulse.service.ProductEventService;
import com.aysimasavas.smartstore.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = productRequest.mapToProduct();
        log.info("product {} is saved", product.getId());
        Product savedProduct = productRepository.save(product);
        return ProductResponse.mapProduct(savedProduct);
    }


    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductResponse::mapProduct).toList();
    }

    public ProductResponse getProductById(String id) {
        Optional<Product> product = productRepository.findById(id);
        ProductEventService.getInstance().productViewed(product.get());
        return ProductResponse.mapProduct(product.get());
    }

    public List<ProductResponse> getProductsByCategoryId(String categoryId) {
        List<Product> products = productRepository.getProductByCategoryId(categoryId);
        return products.stream().map(ProductResponse::mapProduct).toList();
    }


}
