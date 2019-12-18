package pl.urtica.wktmulti.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.urtica.wktmulti.entity.Status;
import pl.urtica.wktmulti.entity.completion.CompletionDocument;

@Repository
public interface CompletionDocumentRepo extends MongoRepository<CompletionDocument, Object> {
    CompletionDocument findFirstByStatusOrderByStartDeliveryDate(Status status);
}
