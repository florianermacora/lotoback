package com.loto.lotoback.sectirage.mapper;

import com.loto.lotoback.sectirage.entity.SecTirageEntity;
import com.loto.lotoback.tirage.dto.TirageDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SecTirageMapper {

    List<TirageDto> entityToDtoList(List<SecTirageEntity> source);

    List<SecTirageEntity> dtoToEntityList(List<TirageDto> source);

    TirageDto entityToDto(SecTirageEntity source);

    SecTirageEntity dtoToEntity(TirageDto source);

}
