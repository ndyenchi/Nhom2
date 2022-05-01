package com.example.demo.repository;

import com.example.demo.entity.TAI_KHOAN_NV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface TaiKhoanNVRepository extends JpaRepository<TAI_KHOAN_NV, String> {
    @Modifying
    @Transactional
    @Query(value = "update tai_khoan_nv set trang_thai=0 where cmnd=:id", nativeQuery = true)
    void deleteNhanVien(String id);
}
