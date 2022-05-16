package com.example.demo.controller;


import com.example.demo.DTO.KhachHangDto;
import com.example.demo.DTO.NhanVienDto;
import com.example.demo.DTO.TaiKhoanNVDto;
import com.example.demo.DTO.TaiKhoan_NhanVien;
import com.example.demo.entity.KHACH_HANG;
import com.example.demo.helper.ResponseHelper;
import com.example.demo.helper.ValidationHeader;
import com.example.demo.repository.KhachHangRepository;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/KhachHang/")
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private KhachHangRepository repo;
    @GetMapping("getAll")
    public List<KhachHangDto> listall() {return khachHangService.getAll();}

    @GetMapping("{maKH}")
    public Optional<KhachHangDto> getByID(@PathVariable String maKH) {
        return khachHangService.findById(maKH);
    }

    @PatchMapping("edit/{id}")
    public ResponseEntity edit(@PathVariable String id, @RequestBody KhachHangDto dto){
        System.out.println(dto.getHoTen());
        dto.setMaKH(id);
        khachHangService.save(dto);
        return ResponseHelper.GenerateResponse(true, "Edit employee success", HttpStatus.OK);
    }
    @PostMapping("insert")
    public ResponseEntity insert (@RequestBody KhachHangDto a){
        khachHangService.save(a);
        return ResponseHelper.GenerateResponse(true, "Create employee success",khachHangService.getAll() ,HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity deletNhanVien(@RequestHeader Map<String, String> headers, @PathVariable String id){
        if (!ValidationHeader.IsAdmin(headers)) {
            return ResponseHelper.GenerateResponse(false, "You are not allow to do this action", HttpStatus.FORBIDDEN);
        }

        else{
            khachHangService.deleteById(id);
            return ResponseHelper.GenerateResponse(true, "Delete employee success", HttpStatus.OK);
        }

    }
}
