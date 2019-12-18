package pl.urtica.wktmulti.entity.completion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.urtica.wktmulti.entity.cart.Cart;

@Document
@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompletionAction {

    @Id
    private ObjectId id;

    private Integer userId;

    private String completionDocumentCode;

    private String cartCode;

}
