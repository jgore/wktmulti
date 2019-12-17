package pl.urtica.wktmulti.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.urtica.wktmulti.entity.cart.Cart;

@Repository
public interface CartRepo extends MongoRepository<Cart, Object> {
}
