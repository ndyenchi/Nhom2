package com.example.demo.repository;

import com.example.demo.entity.KHO_SP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhoSPRepository extends JpaRepository<KHO_SP,Integer>{
}
