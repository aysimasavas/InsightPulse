package com.aysimasavas.insightevent.service;


import com.aysimasavas.insightevent.data.dto.ProductDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("stats/")
public class DataController {

    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("most-product")
    public ResponseEntity<ProductDto> getMostOrderedProduct() {
        return new ResponseEntity<ProductDto>(dataService.getMostOrderedProductStats(), HttpStatus.OK);
    }

    @GetMapping("most-product/{clientId}")
    public ResponseEntity<ProductDto> getMostOrderedProductByClientId(@PathVariable String clientId) {
        return new ResponseEntity<ProductDto>(dataService.getMostOrderedProductStatsByClientId(clientId), HttpStatus.OK);
    }

    @GetMapping("most-viewed/{clientId}")
    public ResponseEntity<ProductDto> getMostViewedProductByClientId(@PathVariable String clientId) {
        return new ResponseEntity<ProductDto>(dataService.getMostViewedProductStatsByClientId(clientId), HttpStatus.OK);
    }

    @GetMapping("most-viewed-last-month/{clientId}")
    public ResponseEntity<ProductDto> getMostViewedProductLastMonthByClientId(@PathVariable String clientId) {
        return new ResponseEntity<ProductDto>(dataService.getMostViewedProductStatsByClientIdLastMonth(clientId), HttpStatus.OK);
    }

    @GetMapping("most-viewed")
    public ResponseEntity<ProductDto> getMostViewedProduct() {
        return new ResponseEntity<ProductDto>(dataService.getMostViewedProductStats(), HttpStatus.OK);
    }

    @GetMapping("total-spending/{clientId}")
    public Double getTotalSpendingByClientId(@PathVariable String clientId) {
        return dataService.getTotalSpendingByClientId(clientId);
    }

    @GetMapping("total-spending-last-month/{clientId}")
    public Double getTotalSpendingLastMonthByClientId(@PathVariable String clientId) {
        return dataService.getTotalSpendingLastMonthByClientId(clientId);
    }

    @GetMapping("most-viewed-not-ordered/{clientId}")
    public ResponseEntity<ProductDto> getMostViewedButNotOrderedProductStatsByClientId(@PathVariable String clientId) {
        return new ResponseEntity<ProductDto>(dataService.getMostViewedButNotOrderedProductStatsByClientId(clientId), HttpStatus.OK);
    }
    @GetMapping("most-viewed-not-ordered")
    public ResponseEntity<ProductDto>  getMostViewedButNotOrderedProductStats() {
        return new ResponseEntity<ProductDto>(dataService.getMostViewedButNotOrderedProductStats(), HttpStatus.OK);
    }
}
