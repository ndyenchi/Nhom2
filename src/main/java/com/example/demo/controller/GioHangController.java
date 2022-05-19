package com.example.demo.controller;


import com.example.demo.DTO.GioHangDto;
import com.example.demo.DTO.KhachHangDto;
import com.example.demo.DTO.KhoSPDto;
import com.example.demo.entity.CT_HOA_DON_NHAP;
import com.example.demo.entity.GIO_HANG;
import com.example.demo.helper.ResponseHelper;
import com.example.demo.service.CHI_TIET_HOA_DON_NHAP_SERVICE;
import com.example.demo.service.GioHangService;
import com.example.demo.service.KhachHangService;
import com.example.demo.service.KhoSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gio-hang/")
public class GioHangController {
    @Autowired
    private GioHangService gioHangService;
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private KhoSPService khoSPService;

    @GetMapping("")
    public List<GioHangDto> getGioHang() {
        return gioHangService.ListAll();
    }
    @GetMapping("{maKH}")
    public List<GioHangDto> getbymaKH(@PathVariable String maKH) { return gioHangService.findByMaKH_GioHang_MaKH(maKH); }
    @PatchMapping("")
    public ResponseEntity create (@RequestBody GioHangDto dto){

        gioHangService.save(dto);

        return ResponseHelper.GenerateResponse(true, "Add item to cart success", HttpStatus.OK);
    }
    @DeleteMapping("{maKH}/{idSanPham}")
    public ResponseEntity delete(@PathVariable String maKH, @PathVariable int idSanPham){
        gioHangService.getByMaKH_IdSanPham(maKH,idSanPham);

        return ResponseHelper.GenerateResponse(true, "Delete item to cart success", HttpStatus.OK);
    }
    @GetMapping("{maKH}/{idSanPham}")
    public GioHangDto test(@PathVariable String maKH, @PathVariable Integer idSanPham){
        return gioHangService.getByMaKH_IdSanPham(maKH,idSanPham);
    }
}
