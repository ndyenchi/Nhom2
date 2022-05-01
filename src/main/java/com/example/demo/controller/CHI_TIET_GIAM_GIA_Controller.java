package com.example.demo.controller;

import com.example.demo.entity.CHI_TIET_GIAM_GIA;
import com.example.demo.service.CHI_TIET_GIAM_GIA_SERVICE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ChiTietGiamGia/")

public class CHI_TIET_GIAM_GIA_Controller {
    @Autowired
    private CHI_TIET_GIAM_GIA_SERVICE ChiTietGiamGiaSV;

    @GetMapping("get")
    public List<CHI_TIET_GIAM_GIA> getChi_tiet_giam_gias(){
        List<CHI_TIET_GIAM_GIA> ChiTieGamGiaList = ChiTietGiamGiaSV.ListAll();
        return ChiTieGamGiaList;
    }

    @PostMapping("edit")
    public List<CHI_TIET_GIAM_GIA> postChiTietGiamGia(@RequestBody CHI_TIET_GIAM_GIA ChiTietGiamGia){
        List<CHI_TIET_GIAM_GIA> ChiTietGiamGiaList = ChiTietGiamGiaSV.ListAll();
        ChiTietGiamGiaSV.save(ChiTietGiamGia);
        return ChiTietGiamGiaList;
    }

}
