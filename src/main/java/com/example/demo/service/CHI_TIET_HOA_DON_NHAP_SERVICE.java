package com.example.demo.service;


import com.example.demo.entity.CT_HOA_DON_NHAP;
import com.example.demo.repository.CHI_TIET_HOA_DON_NHAP_REPOSITORY;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CHI_TIET_HOA_DON_NHAP_SERVICE {
    @Autowired
    private CHI_TIET_HOA_DON_NHAP_REPOSITORY repo;
    public List<CT_HOA_DON_NHAP> ListAll(){
        return (List<CT_HOA_DON_NHAP>) repo.findAll();
    }

    public Optional<CT_HOA_DON_NHAP> get(Integer id){
        return repo.findById(id);
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }

    public void save(CT_HOA_DON_NHAP CTHoaDonNhap){
        repo.save(CTHoaDonNhap);
    }


}
