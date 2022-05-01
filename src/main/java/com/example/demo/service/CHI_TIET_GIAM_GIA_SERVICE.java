package com.example.demo.service;


import com.example.demo.entity.CHI_TIET_GIAM_GIA;
import com.example.demo.repository.CHI_TIET_GIAM_GIA_REPOSITORY;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class CHI_TIET_GIAM_GIA_SERVICE {
    @Autowired
    private CHI_TIET_GIAM_GIA_REPOSITORY repo;
    public List<CHI_TIET_GIAM_GIA> ListAll(){
        return (List<CHI_TIET_GIAM_GIA>) repo.findAll();
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }

    public Optional<CHI_TIET_GIAM_GIA> get(Integer id){
        return repo.findById(id);
    }

    public void save(CHI_TIET_GIAM_GIA ChiTietGiamGia){
        repo.save(ChiTietGiamGia);
    }

}
