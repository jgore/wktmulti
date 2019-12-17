package pl.urtica.wktmulti.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WzDto {

    private Integer documentId;
    private String formattedNumber;
    private Integer ckk;
    private Integer dimension;
    private LocalDateTime creationDate;
    private List<WzItemDto> items = new ArrayList<>();
}
