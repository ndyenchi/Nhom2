package com.example.demo.service;


import com.example.demo.entity.TAI_KHOAN_NV;
import com.example.demo.repository.TaiKhoanNVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TaiKhoanNVService {
    @Autowired
    private TaiKhoanNVRepository repo;

    public List<TAI_KHOAN_NV> ListAll() {
        return (List<TAI_KHOAN_NV>) repo.findAll();
    }

    public Optional<TAI_KHOAN_NV> get(String id) {
        return repo.findById(id);
    }

    public void delete(String id) {
        repo.deleteById(id);
    }

    public void save(TAI_KHOAN_NV TaiKhoanNV) {
        repo.save(TaiKhoanNV);
    }

    public void deleteNhanVien(String id) {
        repo.deleteNhanVien(id);
    }
}
