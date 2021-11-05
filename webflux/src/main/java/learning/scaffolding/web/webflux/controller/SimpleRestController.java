package learning.scaffolding.web.webflux.controller;

import learning.scaffolding.web.webflux.models.Order;
import learning.scaffolding.web.webflux.repository.ReactiveOrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "order")
@RequiredArgsConstructor
@Slf4j
public class SimpleRestController {

  private final ReactiveOrderRepository reactiveOrderRepository;

  @GetMapping
  public Flux<Order> hello() {
    return reactiveOrderRepository.findAll();
  }

  @GetMapping("/{orderId}/{productId}")
  public Mono<Order> getOrderById(@PathVariable Integer orderId) {
    return reactiveOrderRepository.findById(orderId);
  }

  @PostMapping
  public Mono<Order> createUser(@RequestBody Order user) {
    return reactiveOrderRepository.insertUser(user.getOrderId(), user.getProductId(),
            user.getAmount());
  }

}
