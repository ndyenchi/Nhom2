package com.example.demo.repository;

import com.example.demo.entity.NHAN_VIEN;
import com.example.demo.entity.TAI_KHOAN_NV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;


@Repository
public interface TaiKhoanNVRepository extends JpaRepository<TAI_KHOAN_NV, String> {
    @Modifying
    @Transactional
    @Query(value = "update tai_khoan_nv set trang_thai= false where cmnd=:id", nativeQuery = true)
    void deleteNhanVien(String id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO TAI_KHOAN_NV(username,mat_khau, trang_thai, ma_quyen, cmnd)\n" +
            "VALUES(:username,:mat_khau,:trang_thai,:ma_quyen,:cmnd)" ,nativeQuery = true)
    void insert(@Param("username") String f, @Param("mat_khau") String g, @Param("trang_thai") Boolean h, @Param("ma_quyen") String i, @Param("cmnd") String k);
}
