package pl.urtica.wktmulti.service;

import org.springframework.data.domain.Pageable;
import pl.urtica.wktmulti.controller.dto.WzDto;

import java.util.List;

public interface WzService {
    List<WzDto> getAllByCkk(Integer ckk, Pageable pageable);
}
