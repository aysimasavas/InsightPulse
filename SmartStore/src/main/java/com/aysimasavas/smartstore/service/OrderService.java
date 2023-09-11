package com.aysimasavas.smartstore.service;

import com.aysimasavas.smartstore.dto.OrderRequest;
import com.aysimasavas.smartstore.dto.OrderResponse;
import com.aysimasavas.smartstore.entity.Order;
import com.aysimasavas.smartstore.entity.Product;
import com.aysimasavas.smartstore.insightpulse.service.OrderEventService;
import com.aysimasavas.smartstore.repository.OrderRepository;
import com.aysimasavas.smartstore.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;

    private final ProductRepository productRepository;


    public OrderResponse createOrder(OrderRequest request) {

        List<Product> products = new ArrayList<>();

        double totalPrice = 0.0;

        for (String productId : request.getProductsIds()) {

            Product product = productRepository.getProductById(productId);

            if (product == null || product.getStock() <= 0) {
                return null;
            }

            product.setStock(product.getStock() - 1);

            Product temp = productRepository.save(product);
            totalPrice += temp.getPrice().doubleValue();
            products.add(temp);
        }

        Order order = request.mapToOrderWithProducts(products);
        order.setRawTotalPrice(BigDecimal.valueOf(totalPrice));
        Order savedOrder = orderRepository.save(order);
        OrderEventService.getInstance().orderCompleted(savedOrder,products);

        return OrderResponse.mapToOrder(savedOrder);
    }

    public List<OrderResponse> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(OrderResponse::mapToOrder).toList();
    }

}
