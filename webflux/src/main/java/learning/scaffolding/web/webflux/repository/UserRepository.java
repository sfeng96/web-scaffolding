package learning.scaffolding.web.webflux.repository;

import learning.scaffolding.web.webflux.models.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<User, Integer> {
}
