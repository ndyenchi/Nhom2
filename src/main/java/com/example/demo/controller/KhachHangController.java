package com.example.demo.controller;


import com.example.demo.DTO.KhachHangDto;
import com.example.demo.DTO.NhanVienDto;
import com.example.demo.DTO.TaiKhoanNVDto;
import com.example.demo.DTO.TaiKhoan_NhanVien;
import com.example.demo.entity.KHACH_HANG;
import com.example.demo.helper.ResponseHelper;
import com.example.demo.helper.ValidationHeader;
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
    @GetMapping("getAll")
    public List<KhachHangDto> listall() {return khachHangService.getAll();}

    @GetMapping("{maKH}")
    public Optional<KhachHangDto> getByID(@PathVariable String maKH) {
        return khachHangService.findById(maKH);
    }

    @PostMapping("insert")
    public void insert (@RequestBody KHACH_HANG a){khachHangService.save(a); }
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

    @PostMapping("edit/{maKH}")
    public void edit(@RequestBody KhachHangDto d,@PathVariable String maKH ){
        khachHangService.edit(d, maKH);
    }
}
