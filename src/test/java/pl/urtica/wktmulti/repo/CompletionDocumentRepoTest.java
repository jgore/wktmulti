package pl.urtica.wktmulti.repo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.urtica.wktmulti.entity.Status;
import pl.urtica.wktmulti.entity.Wz;
import pl.urtica.wktmulti.entity.WzItem;
import pl.urtica.wktmulti.entity.cart.Box;
import pl.urtica.wktmulti.entity.cart.BoxDimension;
import pl.urtica.wktmulti.entity.cart.CartPosition;
import pl.urtica.wktmulti.entity.completion.CompletionDocument;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CompletionDocumentRepoTest {

    @Autowired
    private CompletionDocumentRepo completionDocumentRepo;

    @Autowired
    private WzRepo wzRepo;

    @Before
    public void setUp() {

        Random random = new Random();

        List<Wz> wzs = wzRepo.getAllByCkkAndStatusOrderByCreationDateAsc(1, Status.NONE, PageRequest.of(0, 10) );

        Map<CartPosition, Box> cartConfig = new HashMap<>();

        cartConfig.put(CartPosition.p1_1, Box.builder()
                .boxDimension(BoxDimension.BIG)
                .build());
        cartConfig.put(CartPosition.p1_2, Box.builder()
                .boxDimension(BoxDimension.BIG)
                .build());

        List<WzItem> wzItemList = wzs.stream()
                .flatMap(wz -> wz.getItems().stream())
                .map(item -> {
                    item.setCartPosition(CartPosition.p1_1);
                    return item;
                })
                .collect(Collectors.toList());

        CompletionDocument completionDocument = CompletionDocument.builder()
                .wzItemsLocalized(wzItemList)
                .cartConfiguration(cartConfig)
                .startDeliveryDate(LocalDateTime.now().minusHours(6))
                .code(String.valueOf( random.nextInt(1000)))
                .status(Status.TODO)
                .build();

        CompletionDocument save = completionDocumentRepo.save(completionDocument);

        assertNotNull( save);

    }

    @Test
    public void testCreateCompletionMap()
    {

    }

    @After
    public void tearDown() {
       // completionDocumentRepo.deleteAll();
    }
}