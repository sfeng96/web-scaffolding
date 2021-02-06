package learning.scaffolding.web.springboot.repository;

import learning.scaffolding.web.springboot.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
}
