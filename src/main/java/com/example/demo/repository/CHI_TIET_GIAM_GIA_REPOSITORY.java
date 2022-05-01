package com.example.demo.repository;

import com.example.demo.entity.CHI_TIET_GIAM_GIA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CHI_TIET_GIAM_GIA_REPOSITORY extends JpaRepository<CHI_TIET_GIAM_GIA, Integer> {
}
