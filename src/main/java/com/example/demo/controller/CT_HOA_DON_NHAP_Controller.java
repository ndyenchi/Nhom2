package com.example.demo.controller;

import com.example.demo.entity.CT_HOA_DON_NHAP;
import com.example.demo.service.CHI_TIET_HOA_DON_NHAP_SERVICE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/CT_HoaDonNhap/")
public class CT_HOA_DON_NHAP_Controller {
    @Autowired
    private CHI_TIET_HOA_DON_NHAP_SERVICE ChiTietHoaDonNhapSV;

    @GetMapping("get")
    public List<CT_HOA_DON_NHAP> getChiTietHoaDonNhap() {
        List<CT_HOA_DON_NHAP> ChiTietHoaDonNhapList = ChiTietHoaDonNhapSV.ListAll();
        return ChiTietHoaDonNhapList;
    }

    @PostMapping("post")
    public List<CT_HOA_DON_NHAP> postChiTietHoaDonNhap(@RequestBody CT_HOA_DON_NHAP ChiTietHoaDonNhap) {
        List<CT_HOA_DON_NHAP> ChiTietHoaDonNhapList = ChiTietHoaDonNhapSV.ListAll();

        ChiTietHoaDonNhapList.add(ChiTietHoaDonNhap);
        ChiTietHoaDonNhapSV.save(ChiTietHoaDonNhap);
        // Trả về trang thành công success.html
        return ChiTietHoaDonNhapList;
    }
}
