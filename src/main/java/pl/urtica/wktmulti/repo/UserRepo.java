package pl.urtica.wktmulti.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.urtica.wktmulti.entity.User;

@Repository
public interface UserRepo extends MongoRepository<User, Object> {
}
