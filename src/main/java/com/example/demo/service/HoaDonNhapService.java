package com.example.demo.service;

import com.example.demo.entity.HOA_DON_NHAP;
import com.example.demo.repository.HoaDonNhapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HoaDonNhapService {
    @Autowired
    private HoaDonNhapRepository repo;
    public List<HOA_DON_NHAP> ListAll(){
        return (List<HOA_DON_NHAP>) repo.findAll();
    }

    public Optional<HOA_DON_NHAP> get(Integer id){
        return repo.findById(id);
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }

    public void save(HOA_DON_NHAP HoaDonNhap){
        repo.save(HoaDonNhap);
    }
}
