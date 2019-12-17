package pl.urtica.wktmulti.entity.cart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Box {

    private BoxDimension boxDimension;
    private Integer  ckk;

}
