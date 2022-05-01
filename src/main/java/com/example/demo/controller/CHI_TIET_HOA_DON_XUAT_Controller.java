package com.example.demo.controller;


import com.example.demo.entity.CHI_TIET_DON_HANG;
import com.example.demo.service.CHI_TIET_HOA_DON_XUAT_SERVICE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ChiTietHoaDonXuat/")
public class CHI_TIET_HOA_DON_XUAT_Controller {
    @Autowired
    private CHI_TIET_HOA_DON_XUAT_SERVICE ChiTietHoaDonXuatSV;

    @GetMapping("get")
    public List<CHI_TIET_DON_HANG> getChiTietHoaonXuat() {
        List<CHI_TIET_DON_HANG> ChiTietHoaDonXuatList = ChiTietHoaDonXuatSV.ListAll();
        return ChiTietHoaDonXuatList;
    }

    @PostMapping("post")
    public List<CHI_TIET_DON_HANG> postChiTietHoaDonXuat(@RequestBody CHI_TIET_DON_HANG ChiTietHoaDonXuat) {
        List<CHI_TIET_DON_HANG> ChiTietHoaDonXuatList = ChiTietHoaDonXuatSV.ListAll();

        ChiTietHoaDonXuatList.add(ChiTietHoaDonXuat);
        ChiTietHoaDonXuatSV.save(ChiTietHoaDonXuat);
        // Trả về trang thành công success.html
        return ChiTietHoaDonXuatList;
    }
}
