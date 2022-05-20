package com.example.demo.controller;


import com.example.demo.DTO.*;
import com.example.demo.entity.KHACH_HANG;
import com.example.demo.entity.TAI_KHOAN_KH;
import com.example.demo.helper.ResponseHelper;
import com.example.demo.helper.ValidationHeader;
import com.example.demo.repository.KhachHangRepository;
import com.example.demo.service.KhachHangService;
import com.example.demo.service.TaiKhoanKHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
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
    private TaiKhoanKHService taiKhoanKHService;
    @Autowired
    private static final String password="12345678";
    @GetMapping("getAll")
    public List<KhachHangDto> listall() {return khachHangService.getAll();}

    @GetMapping("{maKH}")
    public Optional<KhachHangDto> getByID(@PathVariable String maKH) {
        return khachHangService.findById(maKH);
    }

//    @PatchMapping("edit/{id}")
//    public ResponseEntity edit(@PathVariable String id, @RequestBody KhachHang_TaiKhoan a){
//        KhachHangDto kh=new KhachHangDto(a.getHoTen(),a.getNgaySinh(),a.getDiaChi(),a.getDanhGiatiemNang(),a.getLuuY(),a.getEmail(),a.getMaKH());
//        TaiKhoanKHDto tk=new TaiKhoanKHDto(a.getUsername(), password,a.getMaKH());
//        khachHangService.save(kh);
//        taiKhoanKHService.save(tk);
//        return ResponseHelper.GenerateResponse(true, "Edit employee success", HttpStatus.OK);
//    }

    @PatchMapping("edit/{id}")
    public ResponseEntity edit(@PathVariable String id,@RequestBody Map<String, Object> fields){
        KhachHangDto khachHangDto=khachHangService.findById1(id);
        fields.forEach((k, v) -> {
            Field field = ReflectionUtils.findField(KhachHangDto.class, k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, khachHangDto, v);
        });
        khachHangService.save(khachHangDto);
        return ResponseHelper.GenerateResponse(true, "Edit employee success", HttpStatus.OK);
    }

    @PostMapping("insert")
    public ResponseEntity insert (@RequestBody KhachHang_TaiKhoan a){
        KhachHangDto kh=new KhachHangDto(a.getHoTen(),a.getNgaySinh(),a.getDiaChi(),a.getDanhGiatiemNang(),a.getLuuY(),a.getEmail(),a.getMaKH());
        TaiKhoanKHDto tk=new TaiKhoanKHDto(a.getUsername(), password,kh);
        khachHangService.save(kh);
        taiKhoanKHService.save(tk);
        return ResponseHelper.GenerateResponse(true, "Create employee success",HttpStatus.OK);
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
//        khachHangService.deleteById(id);
//        return ResponseHelper.GenerateResponse(true, "Delete employee success", HttpStatus.OK);

    }
}
