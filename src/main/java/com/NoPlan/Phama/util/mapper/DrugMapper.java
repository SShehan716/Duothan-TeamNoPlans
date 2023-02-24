package com.NoPlan.Phama.util.mapper;

import com.NoPlan.Phama.dto.DrugDto;
import com.NoPlan.Phama.dto.response.DrugResponseDto;
import com.NoPlan.Phama.entity.Drug;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DrugMapper {
    Drug toDrug(DrugDto dto);
    DrugResponseDto toDrugResponseDto(Drug customer);
    List<DrugResponseDto> toDrugResponseDtoList(List<Drug> list );
}
