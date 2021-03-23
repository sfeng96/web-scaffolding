package learning.scaffolding.web.webflux.controller;

import learning.scaffolding.web.webflux.models.User;
import learning.scaffolding.web.webflux.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/user")
@AllArgsConstructor
@Slf4j
public class SimpleRestController {
  private final UserRepository userRepository;

  @GetMapping
  public Mono<User> getUserById(@RequestParam(name = "id") int id) {
    return userRepository
        .findById(id)
        .doOnError(throwable -> log.error(throwable.getMessage()))
        .doOnSuccess(user -> log.info("user returned : {}", user));
  }

  @PostMapping
  public Mono<User> createUser(@RequestBody User user) {
    return userRepository.save(user).doOnSuccess(user1 -> log.info("user created : {}", user1));
  }

  @DeleteMapping
  public Mono<Void> deleteUser(@RequestParam(name = "id") int id) {
    return userRepository.deleteById(id);
  }
}
