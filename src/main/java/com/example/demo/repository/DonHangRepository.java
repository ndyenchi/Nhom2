package com.example.demo.repository;

import com.example.demo.entity.DON_HANG;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonHangRepository extends JpaRepository<DON_HANG, Integer> {
    List<DON_HANG> findBymaHD(int maHD);
}
