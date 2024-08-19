package com.loto.lotoback.tirage.mapper;

import com.loto.lotoback.tirage.dto.TirageDto;
import com.loto.lotoback.tirage.entity.TirageEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TirageMapper {

    List<TirageDto> entityToDtoList(List<TirageEntity> source);
    List<TirageEntity> dtoToEntityList(List<TirageDto> source);

    TirageDto entityToDto(TirageEntity source);
    TirageEntity dtoToEntity(TirageDto source);
}
