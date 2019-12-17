package pl.urtica.wktmulti.repo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.urtica.wktmulti.entity.Wz;
import pl.urtica.wktmulti.entity.WzItem;
import pl.urtica.wktmulti.entity.cart.Cart;
import pl.urtica.wktmulti.entity.cart.CartPosition;
import pl.urtica.wktmulti.entity.completion.CompletionDocument;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CompletionDocumentRepoTest {

    @Autowired
    private CompletionDocumentRepo completionDocumentRepo;

    @Autowired
    private WzRepo wzRepo;

    @Before
    public void setUp() {

        List<Wz> wzs = wzRepo.getAllByCkkOrderByCreationDateAsc(1, PageRequest.of(0, 10));

        List<WzItem> wzItemList = wzs.stream()
                .flatMap(wz -> wz.getItems().stream())
                .map(item -> {
                    item.setCartPosition(CartPosition.p1_1);
                    return item;
                })
                .collect(Collectors.toList());

        CompletionDocument completionDocument = CompletionDocument.builder()
                .userId(1)
                .sortedWzItemsList(wzItemList)
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
        completionDocumentRepo.deleteAll();
    }
}