package com.example.demo.repository;

import com.example.demo.DTO.TaiKhoan_NhanVien;
import com.example.demo.entity.NHAN_VIEN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface NhanVienRepository extends JpaRepository<NHAN_VIEN, String> {


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO NHAN_VIEN (cmnd,email,gioi_tinh,ho_ten,ngay_sinh, sdt)\n" +
            "VALUES (:cmnd,:email,:gioi_tinh,:ho_ten,:ngay_sinh,:sdt)" ,nativeQuery = true)
    void insert(@Param("cmnd") String a, @Param("email") String b, @Param("gioi_tinh") Boolean c, @Param("ho_ten") String hoten,
                @Param("ngay_sinh") Date d, @Param("sdt") String e);

}