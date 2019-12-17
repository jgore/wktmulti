package pl.urtica.wktmulti.entity.completion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.urtica.wktmulti.entity.Wz;
import pl.urtica.wktmulti.entity.WzItem;
import pl.urtica.wktmulti.entity.cart.Cart;
import pl.urtica.wktmulti.entity.cart.CartPosition;

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

    private Integer userId;

    private List<WzItem> sortedWzItemsList;

    private List<Wz> wzs;

    private List<Integer> ckks;

}
