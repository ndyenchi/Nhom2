package com.example.demo.repository;

import com.example.demo.entity.KHACH_HANG;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;

@Repository
public interface KhachHangRepository extends JpaRepository<KHACH_HANG, String> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE KHACH_HANG SET HO_TEN =:hoTen, NGAY_SINH=:ngaySinh,DIA_CHI=:diaChi,DANH_GIA_TIEM_NANG=:danhGia,LUU_Y=:luuY  WHERE MAKH=:maKH", nativeQuery = true)
    void editByMa(@Param("hoTen") String a, @Param("ngaySinh") Date b, @Param("diaChi") String c, @Param("danhGia") String e, @Param("luuY") String f, @Param("maKH") String g);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO KHACH_HANG (HO_TEN, DIA_CHI, EMAIL, MAKH) VALUES  (:hoTen, :diaChi, :email, :maKH)",nativeQuery = true)
    void insert(@Param("hoTen") String ten, @Param("diaChi") String addr, @Param("email") String email, @Param("maKH") String makh);

}
