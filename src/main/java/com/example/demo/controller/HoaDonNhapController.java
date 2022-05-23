package com.example.demo.controller;


import com.example.demo.DTO.*;
import com.example.demo.entity.HOA_DON_NHAP;
import com.example.demo.entity.KHO_SP;
import com.example.demo.helper.ResponseHelper;
import com.example.demo.service.CHI_TIET_HOA_DON_NHAP_SERVICE;
import com.example.demo.service.HoaDonNhapService;
import com.example.demo.service.KhoSPService;
import com.example.demo.service.NhanVienService;
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
    @Autowired
    private KhoSPService khoSPService;
    @Autowired
    private NhanVienService nhanVienService;
    // ds hóa hơn nhập
    @GetMapping()
    public List<ChiTieHoaDonNhapDto> list() {
        return ctHoaDonNhapService.ListAll();
    }

    @GetMapping("{id}")
    public ChiTieHoaDonNhapDto findByID(@PathVariable int id) {
        return ctHoaDonNhapService.get(id);
    }

        @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody ChiTieHoaDonNhapDto dto){
        hoaDonNhapService.save(dto.getHoaDon());
        ctHoaDonNhapService.save(dto);
       // KhoSPDto k=khoSPService.selectbyID_Color_size(dto.getIdKho_HDNhap().getSanPham().getMaSP(),dto.getIdKho_HDNhap().getMau(), dto.getIdKho_HDNhap().getSize());
         //   System.out.println(k);
        //khoSPService.update(dto.getSoLuongNhap(),k.getIdKho());
        return ResponseHelper.GenerateResponse(true, "Create bill success", HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        int a=ctHoaDonNhapService.get(id).getIdHoaDonNhap();
        ctHoaDonNhapService.delete(id);
        if(ctHoaDonNhapService.findByHoaDon_MaHDNhap(id).size()==0){
            hoaDonNhapService.delete(a);
            return ResponseHelper.GenerateResponse(true, "delete bill success", HttpStatus.OK);
        }
        return ResponseHelper.GenerateResponse(true, "delete bill success", HttpStatus.OK);

    }

    @GetMapping("hoa-don-nhap/{id}")
    public List<ChiTieHoaDonNhapDto> list(@PathVariable int id) {
        return ctHoaDonNhapService.findByHoaDon_MaHDNhap(id);
    }

//    @PostMapping("")
//    public ResponseEntity create(@RequestBody CT_HoaDonNhap dto) {
//        KhoSPDto k=khoSPService.selectbyID_Color_size(dto.getMaSP(), dto.getMau(),dto.getSize());
//        NhanVienDto nv=nhanVienService.findById(dto.getMaNV());
//        HoaDonNhapDto hd=new HoaDonNhapDto(1,nv,dto.getNgayNhap(), dto.getTongTien());
//        ChiTieHoaDonNhapDto ct=new ChiTieHoaDonNhapDto(1,hd,dto.getSoLuongNhap(),k,dto.getGia_Nhap());
//        hoaDonNhapService.save(hd);
//        ctHoaDonNhapService.save(ct);
//        return ResponseHelper.GenerateResponse(true, "delete bill success", HttpStatus.OK);
//
//    }
}
