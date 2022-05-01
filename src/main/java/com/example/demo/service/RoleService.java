package com.example.demo.service;

import com.example.demo.entity.ROLE;
import com.example.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RoleService {
    @Autowired
    private RoleRepository repo;
    public List<ROLE> ListAll(){
        return (List<ROLE>) repo.findAll();
    }

    public Optional<ROLE> get(Integer id){
        return repo.findById(id);
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }

    public void save(ROLE role){
        repo.save(role);
    }

    public void insert(String maQuyen, String tenQuyen) {
        repo.insert(maQuyen,tenQuyen);
    }


    public void editByMa(int maQuyen, String tenQuyen){
        repo.editByMa(maQuyen,tenQuyen);
    }

}
