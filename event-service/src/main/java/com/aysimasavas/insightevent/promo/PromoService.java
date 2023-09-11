package com.aysimasavas.insightevent.promo;

import com.aysimasavas.insightevent.data.dto.ProductDto;
import com.aysimasavas.insightevent.data.dto.PromoDto;
import com.aysimasavas.insightevent.service.DataService;
import com.mongodb.lang.Nullable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PromoService {
    private final DataService dataService;

    public PromoService(DataService dataService) {
        this.dataService = dataService;
    }

    private BigDecimal makeDiscount(BigDecimal oldPrice, BigDecimal percent) {
        double discountPrice = oldPrice.doubleValue() - ((oldPrice.doubleValue() * percent.doubleValue()) / 100);
        return BigDecimal.valueOf(discountPrice);
    }

    public ProductDto createMostViewedButNotOrderedProductPromo(@Nullable String name, Double percent) {
        ProductDto product = dataService.getMostViewedButNotOrderedProductStats();
        String promoName = product.getName() + "_" + (name == null ? "promo" : name);
        PromoDto promo = new PromoDto(promoName, BigDecimal.valueOf(percent));
        BigDecimal discountedPrice = makeDiscount(BigDecimal.valueOf(product.getPrice()), promo.getPercent());
        product.setDiscountedPrice(discountedPrice.doubleValue());
        product.setHasDiscount(true);
        return product;
    }

    public ProductDto createMostViewedProductPromo(@Nullable String name, Double percent) {
        ProductDto product = dataService.getMostViewedProductStats();
        String promoName = product.getName() + "_" + (name == null ? "promo" : name);
        PromoDto promo = new PromoDto(promoName, BigDecimal.valueOf(percent));
        BigDecimal discountedPrice = makeDiscount(BigDecimal.valueOf(product.getPrice()), promo.getPercent());
        product.setDiscountedPrice(discountedPrice.doubleValue());
        product.setHasDiscount(true);
        return product;
    }

    public ProductDto createMostOrderedProductPromo(@Nullable String name, Double percent) {
        ProductDto product = dataService.getMostOrderedProductStats();
        String promoName = product.getName() + "_" + (name == null ? "promo" : name);
        PromoDto promo = new PromoDto(promoName, BigDecimal.valueOf(percent));
        BigDecimal discountedPrice = makeDiscount(BigDecimal.valueOf(product.getPrice()), promo.getPercent());
        product.setDiscountedPrice(discountedPrice.doubleValue());
        product.setHasDiscount(true);
        return product;
    }


}
