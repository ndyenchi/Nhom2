package com.example.demo.service;

import com.example.demo.entity.KHUYEN_MAI;
import com.example.demo.repository.KhuyenMaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class KhuyenMaiService {
    @Autowired
    private KhuyenMaiRepository repo;
    public List<KHUYEN_MAI> ListAll(){
        return (List<KHUYEN_MAI>) repo.findAll();
    }

    public Optional<KHUYEN_MAI> get(String id){
        return repo.findById(id);
    }

    public void delete(String id){
        repo.deleteById(id);
    }

    public void save(KHUYEN_MAI KhuyenMai){
        repo.save(KhuyenMai);
    }
}
