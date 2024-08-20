package com.loto.lotoback.premtirage.mapper;

import com.loto.lotoback.premtirage.entity.PremTirageEntity;
import com.loto.lotoback.tirage.dto.TirageDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PremTirageMapper {

    List<TirageDto> entityToDtoList(List<PremTirageEntity> source);

    List<PremTirageEntity> dtoToEntityList(List<TirageDto> source);

    TirageDto entityToDto(PremTirageEntity source);

    PremTirageEntity dtoToEntity(TirageDto source);

}
