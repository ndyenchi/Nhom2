package com.example.demo.controller;

import com.example.demo.DTO.KhachHangDto;
import com.example.demo.DTO.NhanVienDto;
import com.example.demo.DTO.TaiKhoanNVDto;
import com.example.demo.DTO.TaiKhoan_NhanVien;
import com.example.demo.entity.NHAN_VIEN;
import com.example.demo.entity.TAI_KHOAN_NV;
import com.example.demo.helper.ResponseHelper;
import com.example.demo.helper.ValidationHeader;
import com.example.demo.repository.NhanVienRepository;
import com.example.demo.service.NhanVienService;
import com.example.demo.service.TaiKhoanNVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
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
    @Autowired
    private static final String password="12345678";

    private TaiKhoan_NhanVien tk_nv=new TaiKhoan_NhanVien();
    public static List<NhanVienDto> dsNhanVien;
    public static List<TaiKhoanNVDto> dsTaiKhoan;

    public static List<TaiKhoan_NhanVien> dsTaiKhoan_NhanVien;


    @GetMapping("getAll")
    public List<TaiKhoan_NhanVien> listal() {
        dsNhanVien=nhanVienService.listALL();
        dsTaiKhoan=taiKhoanNVService.ListAll();
        dsTaiKhoan_NhanVien=new ArrayList<>();
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
      return dsTaiKhoan_NhanVien;
    }


    @GetMapping("{cmnd}")
    public TaiKhoan_NhanVien getByID(@PathVariable String cmnd) {
        dsNhanVien=nhanVienService.listALL();
        dsTaiKhoan=taiKhoanNVService.ListAll();
     //   dsTaiKhoan_NhanVien=new ArrayList<>();
        for(NhanVienDto nv:dsNhanVien){
            for(TaiKhoanNVDto tk:dsTaiKhoan){
                if(tk.getMaNVCmnd().equals(nv.getCmnd()) && tk.getMaNVCmnd().equals(cmnd)){
                    TaiKhoan_NhanVien t= new TaiKhoan_NhanVien(nv.getSdt(),nv.getHoTen(), nv.getNgaySinh(),nv.getCmnd(),
                            nv.getEmail(), nv.getGioiTinh(),tk.getUsername(),tk.getTrangThai(), tk.getQUYENMaQuyen());
                 //   dsTaiKhoan_NhanVien.add(t);
                    tk_nv=t;
                }
            }
        }
            return  tk_nv;
    //    return dsTaiKhoan_NhanVien;
    }

    @PostMapping("insert")
    public ResponseEntity insert ( @RequestBody TaiKhoan_NhanVien a) {
        //@RequestHeader Map<String, String> headers,
//        nhanVienService.insert(a.getSdt(),a.getHoTen(),a.getNgaySinh(),a.getCmnd(),a.getEmail(),a.getGioiTinh());
//        taiKhoanNVService.insert(a.getUsername(),a.getPassword(),a.getTrangThai(),a.getMaQuyen(),a.getCmnd());
//            if (!ValidationHeader.IsAdmin(headers)) {
//                return ResponseHelper.GenerateResponse(false, "You are not allow to do this action", HttpStatus.FORBIDDEN);
//            } else {
                NHAN_VIEN nv = new NHAN_VIEN(a.getSdt(), a.getHoTen(), a.getNgaySinh(), a.getCmnd(), a.getEmail(), a.getGioiTinh());
           //     TAI_KHOAN_NV tk = new TAI_KHOAN_NV(a.getUsername(), a.getTrangThai());
                boolean trangThai=true;
                TaiKhoanNVDto tk=new TaiKhoanNVDto(a.getUsername(), password ,trangThai, a.getMaQuyen(),a.getCmnd());
                nhanVienService.save(nv);
                taiKhoanNVService.save(tk);
                return ResponseHelper.GenerateResponse(true, "Create employee success", HttpStatus.OK);

       //     }
        }

        @PostMapping("delete/{id}")
    public ResponseEntity deletNhanVien( @PathVariable String id){
    //        @RequestHeader Map<String, String> headers,
//        if (!ValidationHeader.IsAdmin(headers)) {
//            return ResponseHelper.GenerateResponse(false, "You are not allow to do this action", HttpStatus.FORBIDDEN);
//        }
//
//        else{
//            taiKhoanNVService.deleteNhanVien(id);
//            return ResponseHelper.GenerateResponse(true, "Delete employee success", HttpStatus.OK);
//        }
            taiKhoanNVService.deleteNhanVien(id);
          return ResponseHelper.GenerateResponse(true, "Delete employee success", HttpStatus.OK);
    }

//    @PatchMapping("{id}")
//    public ResponseEntity edit(@PathVariable String id, @RequestBody TaiKhoan_NhanVien a){
//        NHAN_VIEN nv = new NHAN_VIEN(a.getSdt(), a.getHoTen(), a.getNgaySinh(),id, a.getEmail(), a.getGioiTinh());
//        TAI_KHOAN_NV tk = new TAI_KHOAN_NV(a.getUsername(), a.getTrangThai());
//        nhanVienService.save(nv);
//        taiKhoanNVService.save(tk);
//        return ResponseHelper.GenerateResponse(true, "Edit employee success",dsTaiKhoan_NhanVien, HttpStatus.OK);
//
//    }

    @PatchMapping("{id}")
        public ResponseEntity edit(@PathVariable String id ,@RequestBody Map<String, Object> fields){


        NhanVienDto dto=nhanVienService.findById(id);
        fields.forEach((k, v) -> {
            Field field = ReflectionUtils.findField(NhanVienDto.class, k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, dto, v);
        });
        nhanVienService.save(dto);
            return ResponseHelper.GenerateResponse(true, "Edit employee success", HttpStatus.OK);

        }
}
