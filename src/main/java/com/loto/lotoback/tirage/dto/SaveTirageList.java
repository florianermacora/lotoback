package com.loto.lotoback.tirage.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Getter
@Setter
public class SaveTirageList {

    private Boolean isFirst;
    private List<TirageDto> tirageList = new ArrayList<>();

}
