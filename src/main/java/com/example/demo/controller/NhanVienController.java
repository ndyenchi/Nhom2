package com.example.demo.controller;

import com.example.demo.DTO.NhanVienDto;
import com.example.demo.helper.ResponseHelper;
import com.example.demo.helper.ValidationHeader;
import com.example.demo.service.NhanVienService;
import com.example.demo.service.TaiKhoanNVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/nhanVien")
public class NhanVienController {
    @Autowired
    NhanVienService nhanVienService;
    @Autowired
    TaiKhoanNVService taiKhoanNVService;

    @GetMapping("getAll")
    public List<NhanVienDto> get() {
       return nhanVienService.getALlNhanVien();
    }

//    @GetMapping("{cmnd}")
//    public List<NhanVienDto> getByID(@PathVariable String cmnd) {
//        return nhanVienService.getByID(cmnd);
//    }

//    @PostMapping("insert")
//    public void insert (@RequestBody NhanVienDto a, @RequestBody TaiKhoanNVDto b){
//        nhanVienService.insert(a.getCmnd(),a.getEmail(),a.getGioiTinh(),a.getHoTen(),a.getNgaySinh(),a.getSdt(),b.getUsername()
//        ,b.getPassword(),b.getTrangThai(),b.getQUYENMaquyen());
//    }
    @PostMapping("delete/{id}")
    public ResponseEntity deletNhanVien(@RequestHeader Map<String, String> headers, @PathVariable String id){
        if (!ValidationHeader.IsAdmin(headers)) {
            return ResponseHelper.GenerateResponse(false, "You are not allow to do this action", HttpStatus.FORBIDDEN);
        }

        else{
            taiKhoanNVService.deleteNhanVien(id);
            return ResponseHelper.GenerateResponse(true, "Delete employee success", HttpStatus.OK);
        }

    }
}
