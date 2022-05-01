package com.example.demo.controller;


import com.example.demo.entity.HOA_DON_NHAP;
import com.example.demo.service.CHI_TIET_HOA_DON_NHAP_SERVICE;
import com.example.demo.service.HoaDonNhapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/HoaDonNhap/")
public class HoaDonNhapController {
    @Autowired
    private HoaDonNhapService HoaDonNhapSV;
    @Autowired
    private CHI_TIET_HOA_DON_NHAP_SERVICE ChiTietHoaDonNhapSV;

    @GetMapping("get")
    public List<HOA_DON_NHAP> getHoaDonNha() {
        List<HOA_DON_NHAP> HoaDonNhapList = HoaDonNhapSV.ListAll();
        return HoaDonNhapList;
    }

    @PostMapping("post")
    public List<HOA_DON_NHAP> postHoaDonNhap(@RequestBody HOA_DON_NHAP HoaDonNhap) {
        List<HOA_DON_NHAP> HoaDonNhapList = HoaDonNhapSV.ListAll();

        HoaDonNhapList.add(HoaDonNhap);
        HoaDonNhapSV.save(HoaDonNhap);
        // Trả về trang thành công success.html
        return HoaDonNhapList;
    }
}
