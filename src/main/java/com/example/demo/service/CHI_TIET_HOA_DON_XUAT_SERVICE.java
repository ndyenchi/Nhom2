package com.example.demo.service;

import com.example.demo.entity.CHI_TIET_DON_HANG;
import com.example.demo.repository.ChiTietDonHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CHI_TIET_HOA_DON_XUAT_SERVICE {
    @Autowired
    private ChiTietDonHangRepository repo;
    public List<CHI_TIET_DON_HANG> ListAll(){

        return (List<CHI_TIET_DON_HANG>) repo.findAll();
    }

    public Optional<CHI_TIET_DON_HANG> get(Integer id){
        return repo.findById(id);
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }

    public void save(CHI_TIET_DON_HANG ChiTietHoaDonXuat){
        repo.save(ChiTietHoaDonXuat);
    }

}
