package com.NoPlan.Phama.repo;

import com.NoPlan.Phama.entity.Pharmacy;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface PharmacyRepo extends JpaRepository<Pharmacy, String> {

    @Query(value = "SELECT * FROM Pharmacy WHERE pharmacyName LIKE %?1%  ",nativeQuery = true)
    public List<Pharmacy> searchPharmacy(String searchText, Pageable pageable);
    /* */
    @Query(value = "SELECT COUNT(pharmacyLicence) FROM Pharmacy WHERE pharmacyLicence LIKE %?1% ",nativeQuery = true)
    public long countPharmacy(String searchText);
    /* */
}