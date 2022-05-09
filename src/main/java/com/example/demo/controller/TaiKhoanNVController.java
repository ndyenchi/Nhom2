package com.example.demo.controller;

import com.example.demo.entity.TAI_KHOAN_NV;
import com.example.demo.service.TaiKhoanNVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/taiKhoanNV")
public class TaiKhoanNVController {
    @Autowired TaiKhoanNVService taiKhoanNVService;

    //lay toàn bộ thông tin
//    @GetMapping("get")
//    public List<TAI_KHOAN_NV> get() {
//        List<TAI_KHOAN_NV> taiKhoanNv = taiKhoanNVService.ListAll();
//        return taiKhoanNv;
//    }
    // lay thông tin theo mã
//    @GetMapping("{username}")
//    public String get1(  @PathVariable String username) {
//        Optional<TAI_KHOAN_NV> t=taiKhoanNVService.get(username);
//        String a=t.toString();
//        return a;
//    }
//    // chỉnh sửa toàn bộ tên theo mã có sẵn trong database
//    @PostMapping("/edit")
//    public List<TAI_KHOAN_NV> postThuongHieu(@RequestBody TAI_KHOAN_NV taiKhoanNv) {
//        List<TAI_KHOAN_NV> List = taiKhoanNVService.ListAll();
//        List.add(taiKhoanNv);
//        taiKhoanNVService.save(taiKhoanNv);
//        return List;
//    }


}
