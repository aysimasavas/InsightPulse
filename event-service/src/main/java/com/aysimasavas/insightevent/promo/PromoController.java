package com.aysimasavas.insightevent.promo;

import com.aysimasavas.insightevent.data.dto.ProductDto;
import com.aysimasavas.insightevent.data.dto.PromoDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("promo/")
public class PromoController {

    private final PromoService promoService;

    public PromoController(PromoService promoService) {
        this.promoService = promoService;
    }

    @PostMapping("create-promo-most-but-not-ordered-product")
    public ProductDto createMostViewedButNotOrderedProductPromo(@RequestBody PromoDto promo) {
        return promoService.createMostViewedButNotOrderedProductPromo(promo.getName(), promo.getPercent().doubleValue());
    }

    @PostMapping("create-promo-most-viewed-product")
    public ProductDto createMostViewedProductPromo(@RequestBody PromoDto promo) {
        return promoService.createMostViewedProductPromo(promo.getName(), promo.getPercent().doubleValue());
    }

    @PostMapping("create-promo-most-ordered-product")
    public ProductDto createMostOrderedProductPromo(@RequestBody PromoDto promo) {
        return promoService.createMostOrderedProductPromo(promo.getName(), promo.getPercent().doubleValue());
    }
}
