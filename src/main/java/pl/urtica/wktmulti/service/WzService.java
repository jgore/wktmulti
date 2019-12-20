package pl.urtica.wktmulti.service;

import org.springframework.data.domain.Pageable;
import pl.urtica.wktmulti.controller.dto.WzDto;
import pl.urtica.wktmulti.entity.Status;

import java.util.List;

/**
 * Wydanie zewnetrzne
 * This document represents "wydanie zewnetrznie" in context of warehouse completion.
 * Here we treat Wz and wzItems only in context to store WZ items inside the cart
 * Status means the state of all wz items inside wz in context of completion process.
 */
public interface WzService {
    /**
     *
     * @param ckk this is client
     * @param status different status on different stage
     * @param pageable need to paginate because of large number of entities
     * @return
     */
    List<WzDto> getAllByCkkWithStatus(Integer ckk, Status status, Pageable pageable);
}
