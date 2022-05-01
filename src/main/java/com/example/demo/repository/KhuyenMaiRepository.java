package com.example.demo.repository;

import com.example.demo.entity.KHUYEN_MAI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhuyenMaiRepository extends JpaRepository<KHUYEN_MAI, String> {
}
