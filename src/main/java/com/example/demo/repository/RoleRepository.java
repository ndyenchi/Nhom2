package com.example.demo.repository;

import com.example.demo.entity.ROLE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface RoleRepository extends JpaRepository<ROLE, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE ROLE t SET t.tenQuyen =:tenQuyen  WHERE t.maQuyen=:maQuyen")
    void editByMa(@Param("maQuyen") int ma, @Param("tenQuyen") String ten);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ROLE (MA_QUYEN, TEN_QUYEN ) VALUES  (:maQuyen, :tenQuyen)",nativeQuery = true)
    void insert(@Param("maQuyen") String ma, @Param("tenQuyen") String ten);
}
