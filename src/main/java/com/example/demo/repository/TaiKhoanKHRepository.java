package com.example.demo.repository;

import com.example.demo.entity.TAI_KHOAN_KH;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaiKhoanKHRepository extends JpaRepository<TAI_KHOAN_KH, String> {
}
