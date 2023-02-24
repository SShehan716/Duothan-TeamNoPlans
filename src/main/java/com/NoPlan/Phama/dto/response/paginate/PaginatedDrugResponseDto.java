package com.NoPlan.Phama.dto.response.paginate;

import com.NoPlan.Phama.dto.response.DrugResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedDrugResponseDto {
    private long dataCount;
    private List<DrugResponseDto> dataList;
}
