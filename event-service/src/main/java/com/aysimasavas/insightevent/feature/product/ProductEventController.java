package com.aysimasavas.insightevent.feature.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event/product")
public class ProductEventController {
    private final ProductEventService productEventService;

    @Autowired
    public ProductEventController(ProductEventService productEventService) {
        this.productEventService = productEventService;
    }

    @PostMapping
    public ResponseEntity<ProductEvent> createProductEvent(@RequestBody ProductEvent productEvent) {
        ProductEvent createdProductEvent = productEventService.createProductEvent(productEvent);
        return new ResponseEntity<>(createdProductEvent, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEvent> getProductEventById(@PathVariable String id) {
        ProductEvent productEvent = productEventService.getProductEventById(id);
        if (productEvent != null) {
            return new ResponseEntity<>(productEvent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<ProductEvent>> getAllProductEvents() {
        List<ProductEvent> productEvents = productEventService.getAllProductEvents();
        return new ResponseEntity<>(productEvents, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ProductEvent> updateProductEvent(@RequestBody ProductEvent productEvent) {
        ProductEvent updatedProductEvent = productEventService.updateProductEvent(productEvent);
        return new ResponseEntity<>(updatedProductEvent, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductEvent(@PathVariable String id) {
        productEventService.deleteProductEvent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

