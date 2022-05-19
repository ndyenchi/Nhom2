package com.example.demo.repository;

import com.example.demo.entity.GIO_HANG;
import com.example.demo.entity.KHO_SP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface GioHangRepository extends JpaRepository<GIO_HANG, Integer> {
    public List<GIO_HANG> findByKhachHang_MaKH(String maKH);

    @Modifying
    @Transactional
    @Query(value = "select * from GIO_HANG where makh=:maKH and id_kho=:id",nativeQuery = true)
    public GIO_HANG getByMaKH_IdSanPham(@Param("maKH") String maKH, @Param("id") Integer id);

}
