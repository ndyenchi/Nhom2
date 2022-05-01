package com.example.demo.service;

import com.example.demo.entity.GIO_HANG;
import com.example.demo.repository.GioHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GioHangService {
    @Autowired
    private GioHangRepository repo;
    public List<GIO_HANG> ListAll(){
        return (List<GIO_HANG>) repo.findAll();
    }

    public Optional<GIO_HANG> get(Integer id){
        return repo.findById(id);
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }

    public void save(GIO_HANG GioHang){
        repo.save(GioHang);
    }
}
