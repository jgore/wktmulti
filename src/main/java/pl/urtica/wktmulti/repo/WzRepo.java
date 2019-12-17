package pl.urtica.wktmulti.repo;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.urtica.wktmulti.entity.Wz;

import java.util.List;

@Repository
public interface WzRepo extends MongoRepository<Wz, Object> {
    List<Wz> getAllByCkkOrderByCreationDateAsc(Integer ckk, Pageable pageable);
}
