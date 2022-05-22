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

    private static List<SanPhamDto> dsSanPham;

    private static List<SanPham_khoSP> dsSp_khoSP=new ArrayList<>();


    @GetMapping()
    public  List<KhoSPDto> getAll(){
        return khoSPService.ListAll();
    }
    @GetMapping("id/{id}")
    public KhoSPDto getByID(@PathVariable int id){
        return khoSPService.getbyID(id);
    }
    @GetMapping("color/{color}")
    public List<KhoSPDto> getByColor(@PathVariable String color){
        return khoSPService.findByMau(color);
    }
    @GetMapping("size/{size}")
    public List<KhoSPDto> getbySize(@PathVariable int size){
        return khoSPService.findBySize(size);
    }

//    @PostMapping()
//    public ResponseEntity insert (@RequestBody SanPham_khoSP sp){
//        SanPhamDto a= new SanPhamDto(sp.getMaSP(),sp.getTenSP(),sp.getGioiTinh(),sp.getMoTa(),sp.getGia(),
//                sp.getMaThuongHieu());
//        sanPhamSV.save(a);
//        KhoSPDto b= new KhoSPDto(sp.getSize(),sp.getSoLuongTon(),sp.getMau(),a,sp.getHinhAnh(),sp.getIdKho() );
//        khoSPService.save(b);
//        return ResponseHelper.GenerateResponse(true, "Create product success", HttpStatus.OK);
//
//    }
    @DeleteMapping("{maSP}")
    public ResponseEntity delete(@PathVariable int maSP){
        List<KhoSPDto> a=khoSPService.findBySanPham_MaSP(maSP);
        if (a.size()>0){
            return ResponseHelper.GenerateResponse(false, "Cant not delete product", HttpStatus.OK);

        }else{

            sanPhamSV.delete(maSP);
            return ResponseHelper.GenerateResponse(true, "Delete product success", HttpStatus.OK);

        }


    }
    @GetMapping("ma-sp/{id}")
    public List<KhoSPDto> getBymaSP(@PathVariable int id){
        return khoSPService.findBySanPham_MaSP(id);
    }
    @GetMapping("chung")
    public List<SanPhamDto> getSanPham(){
        return sanPhamSV.getAll();
    }
    @GetMapping("/default")
    private List<SanPhamDto> listSanPham(){
        return  sanPhamSV.getAll();
    }
}