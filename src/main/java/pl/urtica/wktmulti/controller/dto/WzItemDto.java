package pl.urtica.wktmulti.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WzItemDto {

    private String name;
    private String localization;
    private Long batchId;
    private String batchNumber;
    private LocalDate batchExpiryDate;
    private Integer orderedQuantity;
    private String ean;
    private String gtin;
    private Boolean isGTIN;
}
