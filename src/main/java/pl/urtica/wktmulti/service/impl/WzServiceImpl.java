package pl.urtica.wktmulti.service.impl;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.urtica.wktmulti.controller.dto.WzDto;
import pl.urtica.wktmulti.controller.mapper.WzMapper;
import pl.urtica.wktmulti.entity.Status;
import pl.urtica.wktmulti.entity.Wz;
import pl.urtica.wktmulti.repo.WzRepo;
import pl.urtica.wktmulti.service.WzService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WzServiceImpl implements WzService {

    private final WzRepo wzRepo;

    private final WzMapper wzMapper;

    public WzServiceImpl(WzRepo wzRepo, WzMapper wzMapper) {
        this.wzRepo = wzRepo;
        this.wzMapper = wzMapper;
    }

    @Override
    public List<WzDto> getAllByCkkWithStatus(Integer ckk, Status status, Pageable pageable) {

        List<Wz> allByCkk = wzRepo.getAllByCkkAndStatusOrderByCreationDateAsc(ckk, Status.TODO, pageable);

        return allByCkk.stream()
                .map(wzMapper::map)
                .collect(Collectors.toList());

    }
}
