package com.example.demo.repository;

import com.example.demo.entity.CT_HOA_DON_NHAP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CHI_TIET_HOA_DON_NHAP_REPOSITORY extends JpaRepository<CT_HOA_DON_NHAP, Integer> {
}
