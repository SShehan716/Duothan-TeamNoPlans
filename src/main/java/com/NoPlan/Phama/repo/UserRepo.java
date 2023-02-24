package com.NoPlan.Phama.repo;

import com.NoPlan.Phama.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User, String> {

    @Query(value = "SELECT * FROM User WHERE ownerName LIKE %?1% ||ownerId  LIKE %?1%   ",nativeQuery = true)
    public List<User> searchUser(String searchText, Pageable pageable);
    /* */
    @Query(value = "SELECT COUNT(ownerId) FROM User WHERE ownerId LIKE %?1% ",nativeQuery = true)
    public long countUser(String searchText);
    /* */
}