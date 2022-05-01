package com.example.demo.controller;


import com.example.demo.DTO.SanPhamDto;
import com.example.demo.DTO.ThuongHieuDto;
import com.example.demo.entity.KHO_SP;
import com.example.demo.entity.SAN_PHAM;
import com.example.demo.service.KhoSPService;
import com.example.demo.service.SanPhamService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api/SanPham/")
public class SanPhamController {
    @Autowired
    private SanPhamService SanPhamSV;
//    @Autowired
//    private ModelMapper modelMapper;

    @GetMapping("get")
    public List<SanPhamDto> getSanPham() {
        List<SanPhamDto> thuongHieuList = SanPhamSV.getAll();
        return thuongHieuList;
    }


   @GetMapping("getByGioiTinh/{gioiTinh}")
    public List<SanPhamDto> selectGioiTinh(@PathVariable(name="gioiTinh")String gioiTinh){
        List<SanPhamDto> list = SanPhamSV.select(gioiTinh);
        return list;
    }

}