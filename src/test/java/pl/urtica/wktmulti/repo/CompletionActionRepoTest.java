package pl.urtica.wktmulti.repo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.urtica.wktmulti.entity.Status;
import pl.urtica.wktmulti.entity.cart.Cart;
import pl.urtica.wktmulti.entity.completion.CompletionAction;
import pl.urtica.wktmulti.entity.completion.CompletionDocument;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CompletionActionRepoTest {

    @Autowired
    private CompletionActionRepo completionActionRepo;

    @Autowired
    private CompletionDocumentRepo completionDocumentRepo;

    @Autowired
    private CartRepo cartRepo;

    @Before
    public void setUp() {
        Cart cart = cartRepo.findAll().get(0);
        CompletionDocument completionDocument = completionDocumentRepo.findFirstByStatusOrderByStartDeliveryDate(Status.TODO);

        CompletionAction action = CompletionAction.builder()
                .cartCode(cart.getCode())
                .completionDocumentCode(completionDocument.getCode())
                .build();

        completionActionRepo.save(action);

    }

    @After
    public void tearDown() {
        //completionActionRepo.deleteAll();
    }

    @Test
    public  void testSimplePath() {

    }
}