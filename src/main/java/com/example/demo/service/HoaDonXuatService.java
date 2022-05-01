package com.example.demo.service;

import com.example.demo.entity.DON_HANG;
import com.example.demo.repository.DonHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class HoaDonXuatService {
    @Autowired
    private DonHangRepository repo;
    public List<DON_HANG> ListAll(){
        return (List<DON_HANG>) repo.findAll();
    }

    public Optional<DON_HANG> get(Integer id){
        return repo.findById(id);
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }

    public void save(DON_HANG HoaDonXuat){
        repo.save(HoaDonXuat);
    }
}
