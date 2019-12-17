package pl.urtica.wktmulti.controller.mapper;

import org.springframework.stereotype.Component;
import pl.urtica.wktmulti.controller.dto.WzItemDto;
import pl.urtica.wktmulti.entity.WzItem;

@Component
public class WzItemMapper implements Mapper<WzItem, WzItemDto> {

    @Override
    public WzItem map(WzItemDto wzItemDto) {
        return WzItem.builder()
                .name(wzItemDto.getName())
                .localization(wzItemDto.getLocalization())
                .orderedQuantity(wzItemDto.getOrderedQuantity())
                .isGTIN(wzItemDto.getIsGTIN())
                .gtin(wzItemDto.getGtin())
                .ean(wzItemDto.getEan())
                .batchId(wzItemDto.getBatchId())
                .batchNumber(wzItemDto.getBatchNumber())
                .batchExpiryDate(wzItemDto.getBatchExpiryDate())
                .build();
    }

    @Override
    public WzItemDto map(WzItem wzItem) {
        return WzItemDto.builder()
                .name(wzItem.getName())
                .localization(wzItem.getLocalization())
                .orderedQuantity(wzItem.getOrderedQuantity())
                .isGTIN(wzItem.getIsGTIN())
                .gtin(wzItem.getGtin())
                .ean(wzItem.getEan())
                .batchId(wzItem.getBatchId())
                .batchNumber(wzItem.getBatchNumber())
                .batchExpiryDate(wzItem.getBatchExpiryDate())
                .build();
    }
}
