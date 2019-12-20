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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WzRepoTest {

    @Autowired
    private WzRepo wzRepo;

    @Before
    public void setUp() {

        List<WzItem> wzItems = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            WzItem wzItem = WzItem.builder()
                    .name("apap")
                    .batchId(1L)
                    .batchExpiryDate(LocalDate.now().minusDays(1))
                    .batchNumber("1234")
                    .ean("321321312")
                    .gtin("012121211")
                    .orderedQuantity(10)
                    .localization("A12/4/5")
                    .build();

            wzItems.add(wzItem);
        }

        IntStream.range(0,1000).forEach( j->{

            IntStream.range(0, 1000).forEach(i -> {
                Wz wz = Wz.builder()
                        .formattedNumber("WZ/1000/12/"+i+"/"+j)
                        .ckk(j)
                        .documentId(i)
                        .items(wzItems)
                        .dimension(1000)
                        .creationDate(LocalDateTime.now().minusDays(i))
                        .build();

                wzRepo.save(wz);
            });
        });

    }

    @After
    public void tearDown() {
      //  wzRepo.deleteAll();
    }

    @Test
    public void testFindByCkk() {
        List<Wz> allByCkkOrderByCreationDateAsc = wzRepo.getAllByCkkAndStatusOrderByCreationDateAsc(0, Status.NONE, PageRequest.of(0, 10 ));

        assertThat(allByCkkOrderByCreationDateAsc.size(), greaterThan(0));
        assertThat(allByCkkOrderByCreationDateAsc.size(), lessThan(11));
    }


}