package pl.urtica.wktmulti.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.urtica.wktmulti.controller.dto.WzDto;
import pl.urtica.wktmulti.entity.Status;
import pl.urtica.wktmulti.service.WzService;

import java.util.List;

@Controller
@RequestMapping(path = "/wz")
public class WzController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WzController.class);

    private final WzService wzService;

    public WzController(WzService wzService) {
        this.wzService = wzService;
    }

    @GetMapping(path = "/{ckk}")
    @ApiOperation(value = "Get all WZ by ckk", notes = "wz by ckk")
    public ResponseEntity<List<WzDto>> getAll(@PathVariable Integer ckk, @RequestParam Integer page, @RequestParam Integer size) {
        LOGGER.info("wz by ckk is executed for ckk {} ", ckk);

        List<WzDto> allByCkk = wzService.getAllByCkkWithStatus(ckk, Status.TODO, PageRequest.of(page, size));

        return new ResponseEntity<>(allByCkk, HttpStatus.OK);
    }
}
