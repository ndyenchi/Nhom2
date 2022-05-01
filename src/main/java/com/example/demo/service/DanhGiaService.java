package com.example.demo.service;


import com.example.demo.entity.DANH_GIA;
import com.example.demo.repository.DanhGiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DanhGiaService {
    @Autowired
    private DanhGiaRepository repo;
    public List<DANH_GIA> ListAll(){
        return (List<DANH_GIA>) repo.findAll();
    }

    public Optional<DANH_GIA> get(Integer id){
        return repo.findById(id);
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }

    public void save(DANH_GIA DanhGia){
        repo.save(DanhGia);
    }
}
