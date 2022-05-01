package com.example.demo.controller;

import com.example.demo.entity.DON_HANG;
import com.example.demo.service.HoaDonXuatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/HoaDonXuat/")
public class HoaDonXuatController {
    @Autowired
    private HoaDonXuatService HoaDonXuatSV;

    @GetMapping("get")
    public List<DON_HANG> getHoaDonXuat() {
        List<DON_HANG> HoaDonXuatList = HoaDonXuatSV.ListAll();
        return HoaDonXuatList;
    }

    @PostMapping("post")
    public List<DON_HANG> postHoaDonXuat(@RequestBody DON_HANG HoaDonXuat) {
        List<DON_HANG> HoaDonXuatList = HoaDonXuatSV.ListAll();

        HoaDonXuatList.add(HoaDonXuat);
        HoaDonXuatSV.save(HoaDonXuat);
        // Trả về trang thành công success.html
        return HoaDonXuatList;
    }
}
