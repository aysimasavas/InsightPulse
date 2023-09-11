package com.aysimasavas.insightevent.service;

import com.aysimasavas.insightevent.data.dto.ProductDto;
import com.aysimasavas.insightevent.feature.order.OrderEvent;
import com.aysimasavas.insightevent.feature.order.OrderEventService;
import com.aysimasavas.insightevent.feature.product.ProductEvent;
import com.aysimasavas.insightevent.feature.product.ProductEventService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class DataService {

    private final OrderEventService orderEventService;

    private final ProductEventService productEventService;

    public DataService(OrderEventService orderEventService, ProductEventService productEventService) {
        this.orderEventService = orderEventService;
        this.productEventService = productEventService;
    }

    //sitede en çok sipariş edilen ürün
    public ProductDto getMostOrderedProductStats() {
        List<OrderEvent> events = orderEventService.getAllOrderEvents();
        ArrayList<ProductDto> uniqueProductList = new ArrayList<>();

        for (OrderEvent event : events) {
            List<ProductDto> products = event.getProducts();

            for (ProductDto product : products) {
                boolean found = false;
                for (ProductDto existingProduct : uniqueProductList) {
                    if (existingProduct.equals(product)) {
                        existingProduct.setQuantity(existingProduct.getQuantity() + 1);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    product.setQuantity(0);
                    uniqueProductList.add(product);
                }
            }
        }

        Collections.sort(uniqueProductList, Comparator.comparingInt(ProductDto::getQuantity).reversed());
        return uniqueProductList.get(uniqueProductList.size() - 1);

    }

    //müşterinin en çok sipariş ettiği ürün
    public ProductDto getMostOrderedProductStatsByClientId(String clientId) {
        List<OrderEvent> events = orderEventService.getAllOrderEvents();
        ArrayList<ProductDto> uniqueProductList = new ArrayList<>();

        for (OrderEvent event : events) {
            if (event.getClientId().equals(clientId)) {
                List<ProductDto> products = event.getProducts();

                for (ProductDto product : products) {
                    boolean found = false;
                    for (ProductDto existingProduct : uniqueProductList) {
                        if (existingProduct.equals(product)) {
                            existingProduct.setQuantity(existingProduct.getQuantity() + 1);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        product.setQuantity(0);
                        uniqueProductList.add(product);
                    }
                }
            }
        }

        Collections.sort(uniqueProductList, Comparator.comparingInt(ProductDto::getQuantity).reversed());
        return uniqueProductList.get(uniqueProductList.size() - 1);
    }

    //müşterinin en çok görüntülediği ürün

    public ProductDto getMostViewedProductStatsByClientId(String clientId) {
        List<ProductEvent> events = productEventService.getAllProductEvents();
        HashMap<ProductDto, Integer> productViewsMap = new HashMap<>();

        for (ProductEvent event : events) {
            if (event.getClientId().equals(clientId)) {
                ProductDto product = event.getProduct();
                int views = productViewsMap.getOrDefault(product, 0);
                productViewsMap.put(product, views + 1);
            }
        }

        ProductDto mostViewedProduct = null;

        int maxViews = 0;

        for (Map.Entry<ProductDto, Integer> entry : productViewsMap.entrySet()) {
            if (entry.getValue() > maxViews) {
                mostViewedProduct = entry.getKey();
                maxViews = entry.getValue();
            }
        }

        return mostViewedProduct;
    }

    //sitede en çok görüntülenen ürün
    public ProductDto getMostViewedProductStats() {
        List<ProductEvent> events = productEventService.getAllProductEvents();
        HashMap<ProductDto, Integer> productViewsMap = new HashMap<>();

        for (ProductEvent event : events) {
            ProductDto product = event.getProduct();
            int views = productViewsMap.getOrDefault(product, 0);
            productViewsMap.put(product, views + 1);
        }

        ProductDto mostViewedProduct = null;
        int maxViews = 0;

        for (Map.Entry<ProductDto, Integer> entry : productViewsMap.entrySet()) {
            if (entry.getValue() > maxViews) {
                mostViewedProduct = entry.getKey();
                maxViews = entry.getValue();
            }
        }

        return mostViewedProduct;
    }


    public ProductDto getMostViewedProductStatsByClientIdLastMonth(String clientId) {
        List<ProductEvent> events = productEventService.getAllProductEvents();
        HashMap<ProductDto, Integer> productViewsMap = new HashMap<>();

        LocalDate lastMonth = LocalDate.now().minusMonths(1);

        for (ProductEvent event : events) {
            if (event.getClientId().equals(clientId) && event.getCreatedAt().isAfter(lastMonth.atStartOfDay())) {
                ProductDto product = event.getProduct();
                int views = productViewsMap.getOrDefault(product, 0);
                productViewsMap.put(product, views + 1);
            }
        }

        ProductDto mostViewedProduct = null;
        int maxViews = 0;

        for (Map.Entry<ProductDto, Integer> entry : productViewsMap.entrySet()) {
            if (entry.getValue() > maxViews) {
                mostViewedProduct = entry.getKey();
                maxViews = entry.getValue();
            }
        }

        return mostViewedProduct;
    }


    //müşterinin toplam harcaması
    public double getTotalSpendingByClientId(String clientId) {
        List<OrderEvent> events = orderEventService.getAllOrderEvents();
        double totalSpending = 0;

        for (OrderEvent event : events) {
            if (event.getClientId().equals(clientId)) {
                List<ProductDto> products = event.getProducts();

                for (ProductDto product : products) {
                    totalSpending += product.getPrice();

                }
            }
        }


        return totalSpending;
    }

    //müşterinin son aydaki toplam harcaması
    public double getTotalSpendingLastMonthByClientId(String clientId) {
        List<OrderEvent> events = orderEventService.getAllOrderEvents();
        double totalSpending = 0;
        LocalDate currentDate = LocalDate.now();

        for (OrderEvent event : events) {
            if (event.getClientId().equals(clientId)) {
                LocalDateTime createdAt = LocalDateTime.parse(event.getCreatedAt().toString());
                LocalDate eventDate = createdAt.toLocalDate();

                if (eventDate.isAfter(currentDate.minusMonths(1))) {
                    List<ProductDto> products = event.getProducts();

                    for (ProductDto product : products) {
                        totalSpending += product.getPrice();
                    }
                }
            }
        }

        return totalSpending;
    }

    //müşterinin en çok görüntülediği ve satın almadığı ürün

    public ProductDto getMostViewedButNotOrderedProductStatsByClientId(String clientId) {
        List<ProductEvent> productEvents = productEventService.getAllProductEvents();
        List<OrderEvent> orderEvents = orderEventService.getAllOrderEvents();
        ArrayList<ProductDto> viewedProducts = new ArrayList<>();
        ArrayList<ProductDto> orderedProducts = new ArrayList<>();

        for (ProductEvent productEvent : productEvents) {
            if (productEvent.getClientId().equals(clientId)) {
                ProductDto viewedProduct = productEvent.getProduct();
                viewedProducts.add(viewedProduct);
            }
        }

        for (OrderEvent orderEvent : orderEvents) {
            if (orderEvent.getClientId().equals(clientId)) {
                List<ProductDto> orderedProductsInEvent = orderEvent.getProducts();
                orderedProducts.addAll(orderedProductsInEvent);
            }
        }

        viewedProducts.removeIf(orderedProducts::contains);

        if (viewedProducts.isEmpty()) {
            return null; // Müşterinin sipariş etmediği görüntülenen ürün yok
        }

        Map<ProductDto, Integer> productViewCounts = new HashMap<>();

        for (ProductDto viewedProduct : viewedProducts) {
            if (productViewCounts.containsKey(viewedProduct)) {
                int count = productViewCounts.get(viewedProduct);
                productViewCounts.put(viewedProduct, count + 1);
            } else {
                productViewCounts.put(viewedProduct, 1);
            }
        }

        ProductDto mostViewedButNotOrderedProduct = Collections.max(productViewCounts.entrySet(), Map.Entry.comparingByValue()).getKey();

        return mostViewedButNotOrderedProduct;
    }

    public ProductDto getMostViewedButNotOrderedProductStats() {
        List<ProductEvent> productEvents = productEventService.getAllProductEvents();
        List<OrderEvent> orderEvents = orderEventService.getAllOrderEvents();
        ArrayList<ProductDto> viewedProducts = new ArrayList<>();
        ArrayList<ProductDto> orderedProducts = new ArrayList<>();

        for (ProductEvent productEvent : productEvents) {

                ProductDto viewedProduct = productEvent.getProduct();
                viewedProducts.add(viewedProduct);

        }

        for (OrderEvent orderEvent : orderEvents) {
                List<ProductDto> orderedProductsInEvent = orderEvent.getProducts();
                orderedProducts.addAll(orderedProductsInEvent);

        }

        viewedProducts.removeIf(orderedProducts::contains);

        if (viewedProducts.isEmpty()) {
            return null; // Müşterinin sipariş etmediği görüntülenen ürün yok
        }

        Map<ProductDto, Integer> productViewCounts = new HashMap<>();

        for (ProductDto viewedProduct : viewedProducts) {
            if (productViewCounts.containsKey(viewedProduct)) {
                int count = productViewCounts.get(viewedProduct);
                productViewCounts.put(viewedProduct, count + 1);
            } else {
                productViewCounts.put(viewedProduct, 1);
            }
        }

        ProductDto mostViewedButNotOrderedProduct = Collections.max(productViewCounts.entrySet(), Map.Entry.comparingByValue()).getKey();

        return mostViewedButNotOrderedProduct;
    }


}
