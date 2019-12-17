package pl.urtica.wktmulti.repo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.urtica.wktmulti.entity.cart.Box;
import pl.urtica.wktmulti.entity.cart.BoxDimension;
import pl.urtica.wktmulti.entity.cart.Cart;
import pl.urtica.wktmulti.entity.cart.Position;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CartRepoTest {

    @Autowired
    private CartRepo cartRepo;

    @Before
    public void setup() {

        Map<Position, Box> positionBoxMap = new HashMap<>();

        positionBoxMap.put(Position.p1_1, Box.builder().boxDimension(BoxDimension.BIG).build());
        positionBoxMap.put(Position.p1_2, Box.builder().boxDimension(BoxDimension.BIG).build());

        Cart cart = Cart.builder()
                .code("1")
                .boxPositionMap(positionBoxMap)
                .build();

        Cart saved = cartRepo.save(cart);

        assertThat( saved.getBoxPositionMap().get(Position.p1_1).getBoxDimension(), equalTo(BoxDimension.BIG));
    }

    @Test
    public void createBigCart()
    {
        Map<Position, Box> positionBoxMap = new HashMap<>();

        positionBoxMap.put(Position.p1_1, Box.builder().boxDimension(BoxDimension.BIG).build());
        positionBoxMap.put(Position.p1_2, Box.builder().boxDimension(BoxDimension.BIG).build());

        positionBoxMap.put(Position.p2_1, Box.builder().boxDimension(BoxDimension.BIG).build());
        positionBoxMap.put(Position.p2_2, Box.builder().boxDimension(BoxDimension.BIG).build());

        positionBoxMap.put(Position.p3_1, Box.builder().boxDimension(BoxDimension.BIG).build());
        positionBoxMap.put(Position.p3_2, Box.builder().boxDimension(BoxDimension.BIG).build());

        positionBoxMap.put(Position.p4_1, Box.builder().boxDimension(BoxDimension.BIG).build());
        positionBoxMap.put(Position.p4_2, Box.builder().boxDimension(BoxDimension.BIG).build());

        Cart cart = Cart.builder()
                .code("1")
                .boxPositionMap(positionBoxMap)
                .build();

        Cart saved = cartRepo.save(cart);

        assertNotNull(saved);
    }

    @After
    public void reset() {
        //cartRepo.deleteAll();
    }
}
