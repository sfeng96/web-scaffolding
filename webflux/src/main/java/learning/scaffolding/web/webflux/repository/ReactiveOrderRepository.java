package learning.scaffolding.web.webflux.repository;

import learning.scaffolding.web.webflux.models.Order;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

public interface ReactiveOrderRepository extends ReactiveCrudRepository<Order, Integer> {

    @Query("INSERT INTO orders_list (order_id, product_id, amount) VALUES (:1,:2,:3)")
    Mono<Order> insertUser (String orderId, String productId, BigDecimal amount);
}
