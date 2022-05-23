package com.example.demo.controller;


import com.example.demo.DTO.ChiTieHoaDonNhapDto;
import com.example.demo.entity.HOA_DON_NHAP;
import com.example.demo.helper.ResponseHelper;
import com.example.demo.service.CHI_TIET_HOA_DON_NHAP_SERVICE;
import com.example.demo.service.HoaDonNhapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hoa-don-nhap/")
public class HoaDonNhapController {
    @Autowired
    private HoaDonNhapService hoaDonNhapService;
    @Autowired
    private CHI_TIET_HOA_DON_NHAP_SERVICE ctHoaDonNhapService;

    // ds hóa hơn nhập
    @GetMapping()
    public List<ChiTieHoaDonNhapDto> list(){
        return ctHoaDonNhapService.ListAll();
    }
    @GetMapping("{id}")
    public ChiTieHoaDonNhapDto findByID(@PathVariable int id){
        return  ctHoaDonNhapService.get(id);
    }
    @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody ChiTieHoaDonNhapDto dto){
        hoaDonNhapService.save(dto.getHoaDon());
        ctHoaDonNhapService.save(dto);
        return ResponseHelper.GenerateResponse(true, "Create bill success", HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable int id){
        ctHoaDonNhapService.delete(id);
        hoaDonNhapService.delete(ctHoaDonNhapService.get(id).getIdHoaDonNhap());
        return ResponseHelper.GenerateResponse(true, "delete bill success", HttpStatus.OK);
    }
@GetMapping("hoa-don-nhap/{id}")
    public List<ChiTieHoaDonNhapDto> list(@PathVariable int id){
        return ctHoaDonNhapService.findByHoaDon_MaHDNhap(id);
}

}
