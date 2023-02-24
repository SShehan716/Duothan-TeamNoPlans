package com.NoPlan.Phama.service;

import com.NoPlan.Phama.dto.request.DrugRequestDto;
import com.NoPlan.Phama.dto.response.DrugResponseDto;
import com.NoPlan.Phama.dto.response.paginate.PaginatedDrugResponseDto;

public interface DrugService {
    String saveDrug(DrugRequestDto dto);
    DrugResponseDto findDrug(String name) throws ClassNotFoundException;
    public String updateDrug(DrugRequestDto dto , String id) throws ClassNotFoundException;
    public String deleteDrug(String id);
    public PaginatedDrugResponseDto findAllDrug(
            String searchText,int page, int size
    );

}
