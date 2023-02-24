package com.NoPlan.Phama.util.mapper;

import com.NoPlan.Phama.dto.DrugDto;
import com.NoPlan.Phama.dto.PharmacyDto;
import com.NoPlan.Phama.dto.response.DrugResponseDto;
import com.NoPlan.Phama.dto.response.PharmacyResponseDto;
import com.NoPlan.Phama.entity.Drug;
import com.NoPlan.Phama.entity.Pharmacy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PharmacyMapper {
    Pharmacy toPharmacy(PharmacyDto dto);
    PharmacyResponseDto toPharmacyResponseDto(Pharmacy customer);
    List<PharmacyResponseDto> toPharmacyResponseDtoList(List<Pharmacy> list );
}
