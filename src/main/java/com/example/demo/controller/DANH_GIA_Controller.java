package com.example.demo.controller;


import com.example.demo.entity.DANH_GIA;
import com.example.demo.service.DanhGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/DanhGia/")
public class DANH_GIA_Controller {
    @Autowired
    private DanhGiaService DanhGiaSV;

    @GetMapping("get")
    public List<DANH_GIA> getDanhGia() {
        List<DANH_GIA> DanhGiaList = DanhGiaSV.ListAll();
        return DanhGiaList;
    }

    @PostMapping("post")
    public List<DANH_GIA> postDanhGia(@RequestBody DANH_GIA DanhGia) {
        List<DANH_GIA> DanhGiaList = DanhGiaSV.ListAll();

        DanhGiaList.add(DanhGia);
        DanhGiaSV.save(DanhGia);
        // Trả về trang thành công success.html
        return DanhGiaList;
    }
}
