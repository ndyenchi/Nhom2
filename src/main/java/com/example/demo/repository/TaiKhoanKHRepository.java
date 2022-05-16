package com.example.demo.repository;

import com.example.demo.entity.TAI_KHOAN_KH;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TaiKhoanKHRepository extends JpaRepository<TAI_KHOAN_KH, String> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO TAI_KHOAN_KH (USERNAME, MAT_KHAU, MAKH) VALUES  (:username, :password, :maKH)",nativeQuery = true)
    void insert(@Param("username") String username, @Param("password") String password, @Param("maKH") String maKH);

}
