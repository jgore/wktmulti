package pl.urtica.wktmulti.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.urtica.wktmulti.entity.completion.CompletionAction;

@Repository
public interface CompletionActionRepo extends MongoRepository<CompletionAction, Object> {
}
