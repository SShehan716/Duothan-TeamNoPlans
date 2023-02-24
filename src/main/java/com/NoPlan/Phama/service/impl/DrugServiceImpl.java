package com.NoPlan.Phama.service.impl;

import com.NoPlan.Phama.dto.DrugDto;
import com.NoPlan.Phama.dto.request.DrugRequestDto;
import com.NoPlan.Phama.dto.response.DrugResponseDto;
import com.NoPlan.Phama.dto.response.paginate.PaginatedDrugResponseDto;
import com.NoPlan.Phama.entity.Drug;
import com.NoPlan.Phama.repo.DrugRepo;
import com.NoPlan.Phama.service.DrugService;
import com.NoPlan.Phama.util.mapper.DrugMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    private DrugRepo drugRepo;

    @Autowired
    private DrugMapper drugMapper;
    @Override
    public String saveDrug(DrugRequestDto dto) {
        DrugDto cDto  = new DrugDto(
                dto.getName(),
                dto.getManufacturer(),
                dto.getSupplier(),
                dto.getNDC(),
                dto.getExpirationDate(),
                dto.getQty(),
                dto.getUnitPrice());

        return drugRepo.save(drugMapper.toDrug(cDto)).getName()+" Saved!";

    }

    @Override
    public DrugResponseDto findDrug(String id) throws ClassNotFoundException {

        Optional<Drug> selectedDrug = drugRepo.findById(id);
        if(selectedDrug.isPresent()){
            return drugMapper.toDrugResponseDto(selectedDrug.get());
        }
        throw new ClassNotFoundException("Not Found");

    }



    @Override
    public String updateDrug(DrugRequestDto dto, String id) throws ClassNotFoundException {
        Optional<Drug> drug = drugRepo.findById(id);
        if (drug.isPresent()){
            drug.get().setName(dto.getName());
            drug.get().setManufacturer(dto.getManufacturer());
            drug.get().setSupplier(dto.getSupplier());
            drug.get().setNDC(dto.getNDC());
            drug.get().setExpirationDate(dto.getExpirationDate());
            drug.get().setQty(dto.getQty());
            drug.get().setUnitPrice(dto.getUnitPrice());

            drugRepo.save(drug.get());
            return drug.get().getName()+" was Saved";
        }
        throw new ClassNotFoundException("Not Found");
    }

    @Override
    public String deleteDrug(String id) {
        drugRepo.deleteById(id);
        return id+" was deleted!";
    }

    @Override
    public PaginatedDrugResponseDto findAllDrug(
            String searchText, int page, int size
    ) {

        return new PaginatedDrugResponseDto(
                drugRepo.countDrug(searchText),
                drugMapper.toDrugResponseDtoList(drugRepo.searchDrug(
                        searchText,  PageRequest.of(page, size)
                ))
        );
    }
}
