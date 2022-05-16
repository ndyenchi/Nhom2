package com.example.demo.controller;

import com.example.demo.DTO.ThuongHieuDto;
import com.example.demo.entity.THUONG_HIEU;
import com.example.demo.helper.ResponseHelper;
import com.example.demo.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/thuongHieu/")
public class ThuongHIeuController {
    @Autowired
    private ThuongHieuService thuongHieuService;

    //lay toàn bộ thông tin
//    @GetMapping("get")
//    public List<THUONG_HIEU> getThuongHieu() {
//        List<THUONG_HIEU> thuongHieuList = thuongHieuService.listAll();
//        return thuongHieuList;
//    }

    @GetMapping("get")
    public List<ThuongHieuDto> getThuongHieu() {
        List<ThuongHieuDto> thuongHieuList = thuongHieuService.getAll();
        return thuongHieuList;
    }

    // lay thông tin theo mã
    @GetMapping("{maThuongHieu}")
    public ThuongHieuDto get1ThuongHieu(  @PathVariable String maThuongHieu) {
        ThuongHieuDto dto=thuongHieuService.selectbyID(maThuongHieu);
        return dto;
    }
// chỉnh sửa toàn bộ tên theo mã có sẵn trong database


     //edit thông tin theo mã
    @PatchMapping("/edit/{maThuongHieu}")
    public ResponseEntity edit1ThuongHieu(@PathVariable String maThuongHieu,
                                @RequestBody ThuongHieuDto thuongHieu) {
       thuongHieu.setMaThuongHieu(maThuongHieu);
        thuongHieuService.save(thuongHieu);
        return ResponseHelper.GenerateResponse(true, "Edit category success", HttpStatus.OK);

    }
    //=== thêm thương hiệu======

    @PostMapping("insert")
    public ResponseEntity insert (@RequestBody ThuongHieuDto thuonghieu){
        thuongHieuService.insert(thuonghieu.getMaThuongHieu(),thuonghieu.getTenThuongHieu());
        return ResponseHelper.GenerateResponse(true, "Create category success", HttpStatus.OK);

    }
    //========= delete thuong hiệu
    @DeleteMapping("delete/{id}")
    public ResponseEntity delete (@PathVariable String id){
        thuongHieuService.delete(id);
        return ResponseHelper.GenerateResponse(true, "Delete category success", HttpStatus.OK);
    }
}
