package com.NoPlan.Phama.service;

import com.NoPlan.Phama.dto.request.PharmacyRequestDto;
import com.NoPlan.Phama.dto.response.PharmacyResponseDto;
import com.NoPlan.Phama.dto.response.paginate.PaginatedDrugResponseDto;
import com.NoPlan.Phama.dto.response.paginate.PaginatedPharmacyResponseDto;

public interface PharmacyService {
    String savePharmacy(PharmacyRequestDto dto);
    PharmacyResponseDto findPharmacy(String name) throws ClassNotFoundException;
    public String updatePharmacy(PharmacyRequestDto dto , String id) throws ClassNotFoundException;
    public String deletePharmacy(String id);
    public PaginatedPharmacyResponseDto findAllPharmacy(
            String searchText,int page, int size
    );

}
