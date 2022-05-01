package com.example.demo.repository;

import com.example.demo.entity.GIO_HANG;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GioHangRepository extends JpaRepository<GIO_HANG, Integer> {
}
