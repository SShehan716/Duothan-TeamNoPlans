package com.NoPlan.Phama.service.impl;

import com.NoPlan.Phama.dto.PharmacyDto;
import com.NoPlan.Phama.dto.request.PharmacyRequestDto;
import com.NoPlan.Phama.dto.response.PharmacyResponseDto;
import com.NoPlan.Phama.dto.response.paginate.PaginatedPharmacyResponseDto;
import com.NoPlan.Phama.entity.Pharmacy;
import com.NoPlan.Phama.repo.PharmacyRepo;
import com.NoPlan.Phama.service.PharmacyService;
import com.NoPlan.Phama.service.PharmacyService;
import com.NoPlan.Phama.util.mapper.PharmacyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PharmacyServiceImpl implements PharmacyService {

    @Autowired
    private PharmacyRepo pharmacyRepo;

    @Autowired
    private PharmacyMapper pharmacyMapper;

    @Override
    public String savePharmacy(PharmacyRequestDto dto) {
        PharmacyDto cDto  = new PharmacyDto(
                dto.getPharmacyLicence(),
                dto.getPharmacyName(),
                dto.getPharmacyAddress(),
                dto.getPharmacyMobile(),
                dto.getPharmacyEmail(),
                dto.getPharmacyWebsite(),
                dto.getPharmacyOpeningHours());

        return pharmacyRepo.save(pharmacyMapper.toPharmacy(cDto)).getPharmacyName()+" Saved!";

    }

    @Override
    public PharmacyResponseDto findPharmacy(String id) throws ClassNotFoundException {

        Optional<Pharmacy> selectedPharmacy = pharmacyRepo.findById(id);
        if(selectedPharmacy.isPresent()){
            return pharmacyMapper.toPharmacyResponseDto(selectedPharmacy.get());
        }
        throw new ClassNotFoundException("Not Found");

    }



    @Override
    public String updatePharmacy(PharmacyRequestDto dto, String id) throws ClassNotFoundException {
        Optional<Pharmacy> pharmacy = pharmacyRepo.findById(id);
        if (pharmacy.isPresent()){

            pharmacy.get().setPharmacyLicence(dto.getPharmacyLicence());
            pharmacy.get().setPharmacyName(dto.getPharmacyName());
            pharmacy.get().setPharmacyAddress(dto.getPharmacyAddress());
            pharmacy.get().setPharmacyMobile(dto.getPharmacyMobile());
            pharmacy.get().setPharmacyEmail(dto.getPharmacyEmail());
            pharmacy.get().setPharmacyWebsite(dto.getPharmacyWebsite());
            pharmacy.get().setPharmacyOpeningHours(dto.getPharmacyOpeningHours());

            pharmacyRepo.save(pharmacy.get());
            return pharmacy.get().getPharmacyName()+" was Saved";
        }
        throw new ClassNotFoundException("Not Found");
    }

    @Override
    public String deletePharmacy(String id) {
        pharmacyRepo.deleteById(id);
        return id+" was deleted!";
    }

    @Override
    public PaginatedPharmacyResponseDto findAllPharmacy(
            String searchText, int page, int size
    ) {

        return new PaginatedPharmacyResponseDto(
                pharmacyRepo.countPharmacy(searchText),
                pharmacyMapper.toPharmacyResponseDtoList(pharmacyRepo.searchPharmacy(
                        searchText,  PageRequest.of(page, size)
                ))
        );
    }
}
