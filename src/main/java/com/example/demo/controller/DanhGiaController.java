package com.example.demo.controller;

import com.example.demo.DTO.DanhGiaDto;
import com.example.demo.helper.ResponseHelper;
import com.example.demo.service.DanhGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/danh-gia/")
public class DanhGiaController {
    @Autowired
    DanhGiaService danhGiaService;

    // tat ca danh gia trong 1 sp
    @GetMapping("{masp}")
    public List<DanhGiaDto> a(@PathVariable int masp){
        return danhGiaService.findByIdHoaDonXuat_IdKho_HDXuat_SanPham_MaSP(masp);
    }
    @PatchMapping("insert/{makh}/{masp}")
    public ResponseEntity create (@PathVariable String makh, @PathVariable int masp, @RequestBody DanhGiaDto dto){
        int idHoaDon= danhGiaService.getId(masp,makh);
        int idDanhGia=danhGiaService.findAll().size()+1;
        danhGiaService.insert(idDanhGia,dto.getDanhGia(),dto.getDiemDanhGia(),idHoaDon);
        return ResponseHelper.GenerateResponse(true, "Create rate success", HttpStatus.OK);

    }
}
