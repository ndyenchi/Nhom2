package com.example.demo.repository;

import com.example.demo.entity.KHO_SP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhoSPRepository extends JpaRepository<KHO_SP,Integer>{
    List<KHO_SP> findByMaSP_MaSP(Integer maSP);
    KHO_SP findByIdKho(Integer idKho);

}
