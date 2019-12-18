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
import pl.urtica.wktmulti.entity.cart.CartPosition;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CartRepoTest {

    @Autowired
    private CartRepo cartRepo;

    @Before
    public void setup() {

        Cart cart = Cart.builder()
                .code("1")
                .build();

        Cart saved = cartRepo.save(cart);

    }

    @Test
    public void createBigCart()
    {

        Cart cart = Cart.builder()
                .code("2")
                .build();

        Cart saved = cartRepo.save(cart);

        assertNotNull(saved);
    }

    @After
    public void reset() {
       // cartRepo.deleteAll();
    }
}
