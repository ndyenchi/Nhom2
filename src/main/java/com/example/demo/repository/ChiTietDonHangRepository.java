package com.example.demo.repository;

import com.example.demo.entity.CHI_TIET_DON_HANG;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietDonHangRepository extends JpaRepository<CHI_TIET_DON_HANG, Integer> {
}
