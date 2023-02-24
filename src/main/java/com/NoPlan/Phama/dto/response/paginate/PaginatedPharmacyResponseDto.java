package com.NoPlan.Phama.dto.response.paginate;

import com.NoPlan.Phama.dto.response.PharmacyResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedPharmacyResponseDto {
    private long dataCount;
    private List<PharmacyResponseDto> dataList;
}
