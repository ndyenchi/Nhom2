package com.example.demo.service;


import com.example.demo.entity.TAI_KHOAN_KH;
import com.example.demo.repository.TaiKhoanKHRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TaiKhoanKHService {
    @Autowired
    private TaiKhoanKHRepository repo;
    public List<TAI_KHOAN_KH> ListAll(){
        return (List<TAI_KHOAN_KH>) repo.findAll();
    }

    public Optional<TAI_KHOAN_KH> get(String id){
        return repo.findById(id);
    }

    public void delete(String id){
        repo.deleteById(id);
    }

    public void save(TAI_KHOAN_KH TaiKhoanKH){
        repo.save(TaiKhoanKH);
    }
}
