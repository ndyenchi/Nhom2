package com.example.demo.controller;


import com.example.demo.entity.CT_HOA_DON_NHAP;
import com.example.demo.entity.GIO_HANG;
import com.example.demo.service.CHI_TIET_HOA_DON_NHAP_SERVICE;
import com.example.demo.service.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/GioHang/")
public class GioHangController {
    @Autowired
    private GioHangService GioHangSV;

    @GetMapping("get")
    public List<GIO_HANG> getGioHang() {
        List<GIO_HANG> GioHangList = GioHangSV.ListAll();
        return GioHangList;
    }

    @PostMapping("post")
    public List<GIO_HANG> postGioHang(@RequestBody GIO_HANG GioHang) {
        List<GIO_HANG> GioHangList = GioHangSV.ListAll();

        GioHangList.add(GioHang);
        GioHangSV.save(GioHang);
        // Trả về trang thành công success.html
        return GioHangList;
    }
}
