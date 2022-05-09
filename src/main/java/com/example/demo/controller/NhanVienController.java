package com.example.demo.controller;

import com.example.demo.DTO.NhanVienDto;
import com.example.demo.DTO.TaiKhoanNVDto;
import com.example.demo.DTO.TaiKhoan_NhanVien;
import com.example.demo.entity.NHAN_VIEN;
import com.example.demo.helper.ResponseHelper;
import com.example.demo.helper.ValidationHeader;
import com.example.demo.repository.NhanVienRepository;
import com.example.demo.service.NhanVienService;
import com.example.demo.service.TaiKhoanNVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/nhanVien")
public class NhanVienController {
    @Autowired
    NhanVienService nhanVienService;
    @Autowired
    TaiKhoanNVService taiKhoanNVService;
    @Autowired
    NhanVienRepository repo;

    public static List<NhanVienDto> dsNhanVien;
    public static List<TaiKhoanNVDto> dsTaiKhoan;

    public static List<TaiKhoan_NhanVien> dsTaiKhoan_NhanVien=new ArrayList<>();


    @GetMapping("getAll")
    public List<TaiKhoan_NhanVien> listal() {
        dsNhanVien=nhanVienService.chichi();
        dsTaiKhoan=taiKhoanNVService.ListAll();
      for(NhanVienDto nv:dsNhanVien){
          System.out.println("nhan vien "+nv.getCmnd());
          for(TaiKhoanNVDto tk:dsTaiKhoan){
              System.out.println("taikhoan :"+tk.getUsername());
              if(tk.getMaNVCmnd().equals(nv.getCmnd())){
                  TaiKhoan_NhanVien t= new TaiKhoan_NhanVien(nv.getSdt(),nv.getHoTen(), nv.getNgaySinh(),nv.getCmnd(),
                          nv.getEmail(), nv.getGioiTinh(),tk.getUsername(),tk.getTrangThai(), tk.getQUYENMaQuyen());
                  dsTaiKhoan_NhanVien.add(t);
              }
          }
      }
      for(NhanVienDto nv:dsNhanVien){
          System.out.println("nhanvien: "+nv.getCmnd());
      }
      return dsTaiKhoan_NhanVien;
    }

        @GetMapping("test")
    public List<NhanVienDto> chichi() {
        return nhanVienService.chichi();
    }

//    @GetMapping("{cmnd}")
//    public List<NhanVienDto> getByID(@PathVariable String cmnd) {
//        return nhanVienService.getByID(cmnd);
//    }

//    @PostMapping("insert")
//    public void insert (@RequestBody NhanVienDto a, @RequestBody TaiKhoanNVDto b){
//        nhanVienService.insert(a.getCmnd(),a.getEmail(),a.getGioiTinh(),a.getHoTen(),a.getNgaySinh(),a.getSdt(),b.getUsername()
//        ,b.getPassword(),b.getTrangThai(),b.getQUYENMaquyen());
//    }
    @PostMapping("delete/{id}")
    public ResponseEntity deletNhanVien(@RequestHeader Map<String, String> headers, @PathVariable String id){
        if (!ValidationHeader.IsAdmin(headers)) {
            return ResponseHelper.GenerateResponse(false, "You are not allow to do this action", HttpStatus.FORBIDDEN);
        }

        else{
            taiKhoanNVService.deleteNhanVien(id);
            return ResponseHelper.GenerateResponse(true, "Delete employee success", HttpStatus.OK);
        }

    }
}
