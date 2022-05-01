package com.example.demo.service;

import com.example.demo.entity.KHO_SP;
import com.example.demo.repository.KhoSPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhoSPService {

    @Autowired
    private KhoSPRepository repo;
    public List<KHO_SP> ListAll(){
        return (List<KHO_SP>) repo.findAll();
    }

    public Optional<KHO_SP> get(Integer id){
        return repo.findById(id);
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }

    public void save(KHO_SP KhoSP){
        repo.save(KhoSP);
    }
}
