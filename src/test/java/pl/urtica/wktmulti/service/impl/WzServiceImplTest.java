package pl.urtica.wktmulti.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.urtica.wktmulti.controller.dto.WzDto;
import pl.urtica.wktmulti.entity.Wz;
import pl.urtica.wktmulti.entity.WzItem;
import pl.urtica.wktmulti.repo.WzRepo;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith( SpringRunner.class)
public class WzServiceImplTest {

    @MockBean
    private WzRepo wzRepo;

    @Autowired
    private WzServiceImpl wzService;

    private Wz wz;

    @Before
    public void setup() {
        wz = Wz.builder().formattedNumber("WZ/1234/1").build();
        when(wzRepo.getAllByCkkOrderByCreationDateAsc(anyInt(), any())).thenReturn( Arrays.asList(wz, wz));
    }


    @Test
    public void getAllByCkkWithNoItems() {
        List<WzDto> allByCkk = wzService.getAllByCkk(0, PageRequest.of(0, 10));
        verify(wzRepo, times(1)).getAllByCkkOrderByCreationDateAsc(anyInt(), any());
    }

    @Test
    public  void testAllByCkkWithItems()
    {
        WzItem wzItem = WzItem.builder().gtin("1234").build();
        wz.setItems(Arrays.asList(wzItem,wzItem));

        List<WzDto> allByCkk = wzService.getAllByCkk(0, PageRequest.of(0, 10));
        verify(wzRepo, times(1)).getAllByCkkOrderByCreationDateAsc(anyInt(), any());
    }
}