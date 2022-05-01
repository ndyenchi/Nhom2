package com.example.demo.controller;


import com.example.demo.entity.KHACH_HANG;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/KhachHang/")
public class KhachHangController {
    @Autowired
    private KhachHangService KhachHangSV;

//    @GetMapping("get")
//    public List<KHACH_HANG> getKhachHang() {
//        List<KHACH_HANG> KhachHangList = KhachHangSV.ListAll();
//        return KhachHangList;
//    }
//
//    @PostMapping("post")
//    public List<KHACH_HANG> postKhachHang(@RequestBody KHACH_HANG KH) {
//        List<KHACH_HANG> KhachHangList = KhachHangSV.ListAll();
//
//        KhachHangList.add(KH);
//        KhachHangSV.save(KH);
//        // Trả về trang thành công success.html
//        return KhachHangList;
//    }
}
