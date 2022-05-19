package com.example.demo.repository;

import com.example.demo.DTO.SanPham_khoSP;
import com.example.demo.entity.KHO_SP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface KhoSPRepository extends JpaRepository<KHO_SP,Integer>{
 //   List<KHO_SP> findByMaSP_MaSP(Integer maSP);
//    KHO_SP findByIdKho(Integer idKho);
    List<KHO_SP> findByMau(String mau);
    List<KHO_SP> findBySize(int size);
    List<KHO_SP> findBySanPham_MaSP(int maSP);
//
//    @Modifying
//    @Transactional
//    @Query(value ="select id_kho , anh, mau, size, so_luong_ton,kho_sp.masp,gia,gioitinh,mota,tensp,ma_thuong_hieu from kho_sp, san_pham where mau=:mau and kho_sp.masp=san_pham.masp" , nativeQuery = true)
//    List<SanPham_khoSP> selectByColor(@Param("mau") String id);
}
