package com.loto.lotoback.tirage.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class SaveTirage {

    private Boolean isFirst;
    private TirageDto tirageList;

}
