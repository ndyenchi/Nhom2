package com.example.demo.controller;


import com.example.demo.DTO.*;
import com.example.demo.entity.KHO_SP;
import com.example.demo.entity.SAN_PHAM;
import com.example.demo.helper.ResponseHelper;
import com.example.demo.service.KhoSPService;
import com.example.demo.service.SanPhamService;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/SanPham/")
public class SanPhamController {
    @Autowired
    private SanPhamService sanPhamSV;
    @Autowired
    private KhoSPService khoSPService;

    private List<KhoSPDto> dsKhoSP;
    private List<SanPhamDto> dsSanPham;
    private List<SanPham_khoSP> ds;

    @GetMapping()
    public List<SanPham_khoSP> getAll(){
        dsSanPham=sanPhamSV.getAll();
        dsKhoSP=khoSPService.ListAll();
        ds=new ArrayList<>();
        for(SanPhamDto a:dsSanPham){
            for(KhoSPDto b:dsKhoSP){
                if(b.getMaSPMaSP().equals(a.getMaSP())){
                    SanPham_khoSP t= new SanPham_khoSP(a.getMaSP(),a.getTenSP(),a.getGioiTinh(),a.getMoTa(),a.getGia(),
                            a.getThuongHieuMaThuongHieu(),b.getSize(),b.getSoLuongTon(),b.getMau(),b.getHinhAnh(),b.getIdKho() );
                    ds.add(t);
                }
            }
        }
        return ds;
    }

    @GetMapping("{id}")
    public SanPham_khoSP getByID(@PathVariable Integer id){
        KhoSPDto b= khoSPService.getbyID(id);
        SanPhamDto a=sanPhamSV.getbyID(b.getMaSPMaSP());
        SanPham_khoSP c=new SanPham_khoSP(a.getMaSP(),a.getTenSP(),a.getGioiTinh(),a.getMoTa(),a.getGia(),
                a.getThuongHieuMaThuongHieu(),b.getSize(),b.getSoLuongTon(),b.getMau(),b.getHinhAnh(),b.getIdKho() );

        return  c;


    }
    @PostMapping()
    public ResponseEntity insert (@RequestBody SanPham_khoSP sp){
        SanPhamDto a= new SanPhamDto(sp.getMaSP(),sp.getTenSP(),sp.getGioiTinh(),sp.getMoTa(),sp.getGia(),
                sp.getMaThuongHieu());
        sanPhamSV.save(a);
        KhoSPDto b= new KhoSPDto(sp.getSize(),sp.getSoLuongTon(),sp.getMau(),sp.getMaSP(),sp.getHinhAnh(),sp.getIdKho() );
        khoSPService.save(b);
        return ResponseHelper.GenerateResponse(true, "Create product success", HttpStatus.OK);

    }
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        khoSPService.delete(id);
        KhoSPDto a=khoSPService.getbyID(id);
        System.out.println(a.getMaSPMaSP());
        sanPhamSV.delete(a.getMaSPMaSP());
        return ResponseHelper.GenerateResponse(true, "Delete product success", HttpStatus.OK);

    }
}