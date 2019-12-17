package pl.urtica.wktmulti.controller.mapper;

import org.springframework.stereotype.Component;
import pl.urtica.wktmulti.controller.dto.WzDto;
import pl.urtica.wktmulti.controller.dto.WzItemDto;
import pl.urtica.wktmulti.entity.Wz;
import pl.urtica.wktmulti.entity.WzItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class WzMapper implements Mapper<Wz, WzDto> {

    private final WzItemMapper wzItemMapper;

    public WzMapper(WzItemMapper wzItemMapper) {
        this.wzItemMapper = wzItemMapper;
    }

    @Override
    public Wz map(WzDto wzDto) {

        return Wz.builder()
                .formattedNumber(wzDto.getFormattedNumber())
                .ckk(wzDto.getCkk())
                .creationDate(wzDto.getCreationDate())
                .dimension(wzDto.getDimension())
                .documentId(wzDto.getDocumentId())
                .items(convertDtoItems(wzDto))
                .build();
    }

    @Override
    public WzDto map(Wz wz) {

        return WzDto.builder()
                .formattedNumber(wz.getFormattedNumber())
                .ckk(wz.getCkk())
                .creationDate(wz.getCreationDate())
                .dimension(wz.getDimension())
                .documentId(wz.getDocumentId())
                .items((convertItems(wz)))
                .build();
    }

    private List<WzItem> convertDtoItems(WzDto wzDto) {

        if( wzDto.getItems() == null)
        {
            return Collections.emptyList();
        }

        return wzDto.getItems().stream()
                .map(wzItemMapper::map)
                .collect(Collectors.toList());
    }

    private List<WzItemDto> convertItems(Wz wz) {

        if( wz.getItems() == null)
        {
            return Collections.emptyList();
        }

        return wz.getItems().stream()
                .map(wzItemMapper::map)
                .collect(Collectors.toList());
    }


}
