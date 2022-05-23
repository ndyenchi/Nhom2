package com.example.demo.repository;

import com.example.demo.entity.DANH_GIA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface DanhGiaRepository extends JpaRepository<DANH_GIA, Integer> {
    List<DANH_GIA> findByIdHoaDonXuat_IdKhoHDXuat_SanPham_MaSP(int maSP);

    @Modifying
    @Transactional
    @Query(value = "insert into danh_gia (id_danh_gia,danh_gia,diem_danh_gia,id_hd_xuat) values (:id,:nd,:diem,:hd)", nativeQuery = true)
    public void insert(@Param("id") int id, @Param("nd") String nd, @Param("diem") int diem, @Param("hd") int hd);

    @Modifying
    @Transactional
    @Query(value = "select id_hd_xuat from (select id_hd_xuat, ma_hd from chi_tiet_hoa_don_xuat as a,( select id_kho from kho_sp, san_pham where san_pham.masp=kho_sp.masp and san_pham.masp=:masp) as b\n" +
            "where a.id_kho=b.id_kho ) as c, \n" +
            "(select ma_hd from hoa_don_xuat, khach_hang where khach_hang.makh=hoa_don_xuat.makh and khach_hang.makh=:makh) as d where c.ma_hd=d.ma_hd\n", nativeQuery = true)
    public int getId(@Param("masp") int id, @Param("makh") String nd);
}
