package pl.urtica.wktmulti.entity.completion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.urtica.wktmulti.entity.Status;
import pl.urtica.wktmulti.entity.WzItem;
import pl.urtica.wktmulti.entity.cart.Box;
import pl.urtica.wktmulti.entity.cart.CartPosition;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Document
@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompletionDocument {

    @Id
    private ObjectId id;

    private String code;

    private List<WzItem> wzItemsLocalized;

    private Map<CartPosition, Box> cartConfiguration = new HashMap<>();

    private Status status = Status.TODO;

    private LocalDateTime startDeliveryDate;


}
