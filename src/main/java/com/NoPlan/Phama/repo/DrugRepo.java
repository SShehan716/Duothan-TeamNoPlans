package com.NoPlan.Phama.repo;

import com.NoPlan.Phama.entity.Drug;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface DrugRepo extends JpaRepository<Drug, String> {

    @Query(value = "SELECT * FROM Drug WHERE name LIKE %?1% || NDC LIKE %?1% ",nativeQuery = true)
    public List<Drug> searchDrug(String searchText, Pageable pageable);
    /* */
    @Query(value = "SELECT COUNT(NDC) FROM Drug WHERE name LIKE %?1% || NDC LIKE %?1%",
            nativeQuery = true)
    public long countDrug(String searchText);
    /* */
}