package com.example.demo.controller;

import com.example.demo.DTO.*;
import com.example.demo.entity.DON_HANG;
import com.example.demo.entity.KHO_SP;
import com.example.demo.entity.TAI_KHOAN_KH;
import com.example.demo.helper.ResponseHelper;
import com.example.demo.service.CHI_TIET_HOA_DON_XUAT_SERVICE;
import com.example.demo.service.HoaDonXuatService;
import com.example.demo.service.KhoSPService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/hoa-don-xuat/")
public class HoaDonXuatController {
    @Autowired
    private HoaDonXuatService HoaDonXuatSV;
    @Autowired
    private CHI_TIET_HOA_DON_XUAT_SERVICE chi_tiet_hoa_don_xuat_service;
    @Autowired
    private KhoSPService khoSPService;
    @Autowired
    private ModelMapper modelMapper;

//    public List<KhoSPDto> listSp(){
//        List<KhoSPDto> sp = khoSPService.ListAll();
//        List<KhoSPDto> spDtos = new ArrayList<KhoSPDto>();
//        for(int i =0; i < sp.size(); i++ ){
//            KhoSPDto dto = modelMapper.map(sp.get(i), KhoSPDto.class);
//            spDtos.add(dto);
//        }
//        return  spDtos;
//    }

    @GetMapping("")
    public List<DonHangDto> getHoaDonXuat() {
        List<DonHangDto> HoaDonXuatList = HoaDonXuatSV.ListAll();
        return HoaDonXuatList;
    }

    @GetMapping("{id}")
    public DonHangDto getByID(@PathVariable int id){
        return HoaDonXuatSV.getbyID(id);
    }


    @DeleteMapping("{maHD}")
    public ResponseEntity delete(@PathVariable int maHD){
        List<DonHangDto> a=HoaDonXuatSV.findBy_MaHD(maHD);
        if (a.size()<0){
            return ResponseHelper.GenerateResponse(false, "Cant not delete bill", HttpStatus.OK);
        }else{
            HoaDonXuatSV.delete(maHD);
            return ResponseHelper.GenerateResponse(true, "Delete bill success", HttpStatus.OK);
        }
    }

    @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody ChiTietDonHangDto dto){

        KhoSPDto t = new KhoSPDto();
        for(KhoSPDto sp: khoSPService.ListAll()) {
            if (t.getIdKho().equals(dto.getIdKhoHDXuat())) {
                t = sp;
            }
        }
        HoaDonXuatSV.save(dto.getMaHDXuat());
        chi_tiet_hoa_don_xuat_service.save(dto);

        t.setSoLuongTon(t.getSoLuongTon()-1);
        khoSPService.save(t);

        return ResponseHelper.GenerateResponse(true, "Create bill success", HttpStatus.OK);

    }
    @PostMapping("tao-hd")
    public ResponseEntity taoHD(@RequestBody DonHangDto dto){
        HoaDonXuatSV.save(dto);
        return ResponseHelper.GenerateResponse(true, "Create bill success", HttpStatus.OK);
    }
    @PostMapping("tao-ct-hd")
    public ResponseEntity taoCT(@RequestBody ChiTietDonHangDto dto){
        chi_tiet_hoa_don_xuat_service.save(dto);
        KhoSPDto t = new KhoSPDto();
        for(KhoSPDto sp: khoSPService.ListAll()) {
            if (t.getIdKho()==dto.getIdKhoHDXuat().getIdKho()) {
                t = sp;
            }
        }
        t.setSoLuongTon(t.getSoLuongTon()-dto.getSoLuongXuat());
        khoSPService.save(t);
        return ResponseHelper.GenerateResponse(true, "Create bill success", HttpStatus.OK);
    }
}
