package com.example.demo.repository;

import com.example.demo.entity.DANH_GIA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanhGiaRepository extends JpaRepository<DANH_GIA, Integer> {
}
