package com.example.demo.repository;

import com.example.demo.entity.SAN_PHAM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SanPhamRepository extends JpaRepository<SAN_PHAM, Integer> {
    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM SAN_PHAM c WHERE c.GIOITINH =:gioiTinh" , nativeQuery = true)
    List<SAN_PHAM> selectGioiTinh(@Param("gioiTinh") String gioiTinh);
    @Modifying
    @Transactional
    @Query(value =  "INSERT INTO SAN_PHAM (MASP,GIA,GIOITINH,MOTA,TENSP, MA_THUONG_HIEU ) VALUES  (:masp,:gia,:gioitinh,:mota, :tensp, :maThuongHieu)",nativeQuery = true)
    public void save1(@Param("masp") int masp,@Param("gia") long gia,@Param("gioitinh") String gioiTinh,@Param("mota") String mota,@Param("tensp") String tensp,@Param("maThuongHieu") String mathuonghieu);

}
