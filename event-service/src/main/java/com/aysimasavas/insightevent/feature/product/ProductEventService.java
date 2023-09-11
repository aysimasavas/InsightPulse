package com.aysimasavas.insightevent.feature.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductEventService {
    private final ProductEventRepository productEventRepository;

    @Autowired
    public ProductEventService(ProductEventRepository productEventRepository) {
        this.productEventRepository = productEventRepository;
    }

    public ProductEvent createProductEvent(ProductEvent productEvent) {
        return productEventRepository.save(productEvent);
    }

    public ProductEvent getProductEventById(String id) {
        Optional<ProductEvent> productEvent = productEventRepository.findById(id);
        return productEvent.orElse(null);
    }

    public List<ProductEvent> getAllProductEvents() {
        return productEventRepository.findAll();
    }

    public ProductEvent updateProductEvent(ProductEvent productEvent) {
        return productEventRepository.save(productEvent);
    }

    public void deleteProductEvent(String id) {
        productEventRepository.deleteById(id);
    }
}
