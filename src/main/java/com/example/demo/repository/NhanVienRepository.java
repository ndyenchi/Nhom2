package com.example.demo.repository;

import com.example.demo.entity.NHAN_VIEN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface NhanVienRepository extends JpaRepository<NHAN_VIEN, String> {
    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM NHAN_VIEN a ", nativeQuery = true)
    List<NHAN_VIEN> getAllNhanVien();

//    @Modifying
//    @Transactional
//    @Query(value = "select * from nhan_vien, tai_khoan_nv where nhan_vien.cmnd=tai_khoan_nv.cmnd and nhan_vien.cmnd=:id", nativeQuery = true)
//    List<NHAN_VIEN> getbyID(String id);


//    @Modifying
//    @Transactional
//    @Query(value = "INSERT INTO NHAN_VIEN (cmnd,email,gioi_tinh,ho_ten,ngay_sinh, sdt)\n" +
//            "VALUES (:cmnd,:email,:gioi_tinh,:ho_ten,:ngay_sinh,sdt)\n" +
//            "INSERT INTO TAI_KHOAN_NV(username,mat_khau, trang_thai, ma_quyen, cmnd)\n" +
//            "VALUES(:username,:mat_khau,:trang_thai,:ma_quyen,:cmnd)", nativeQuery = true)
//    void insert(@Param("cmnd") String a, @Param("email") String b, @Param("gioi_tinh") Boolean c,@Param("ho_ten") String hoten,
//                @Param("ngay_sinh") Date d, @Param("sdt") String e, @Param("username") String f,
//                @Param("mat_khau") String g, @Param("trang_thai") Boolean h,@Param("ma_quyen") String i);

}