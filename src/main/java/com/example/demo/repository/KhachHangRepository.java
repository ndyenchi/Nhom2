package com.example.demo.repository;

import com.example.demo.entity.KHACH_HANG;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepository extends JpaRepository<KHACH_HANG, String> {
}
