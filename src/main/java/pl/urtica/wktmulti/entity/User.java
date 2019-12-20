package pl.urtica.wktmulti.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private ObjectId id;
    @Indexed(unique = true)
    private String userId;

    private String firstName;
    private String lastName;

    private String login;
    //FIXME @pszczepkowksi password has to be coded
    private String password;
}
