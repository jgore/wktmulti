package pl.urtica.wktmulti.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Wz implements EntityClass {

    @Id
    private ObjectId id;
    private Integer documentId;
    private String formattedNumber;
    private Integer ckk;
    private Integer volume;
    private LocalDateTime creationDate;
    private List<WzItem> items = new ArrayList<>();
}
