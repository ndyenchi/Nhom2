package com.example.demo.controller;

import com.example.demo.DTO.*;
import com.example.demo.helper.ResponseHelper;
import com.example.demo.service.KhoSPService;
import com.example.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/san-pham/")
public class testController {
    @Autowired
    KhoSPService khoSPService;
    @Autowired
    SanPhamService sanPhamService;


    @GetMapping("{masp}")
    private A get(@PathVariable int masp){
        List<String> listColor=khoSPService.selectMauTheoMaSP(masp);
        A a=new A();
        List<B> listb=new ArrayList<>();
        for(int i=0;i<listColor.size();i++){
            List<KhoSPDto> list =khoSPService.selectbyID_Color(masp,listColor.get(i).toString());
            List<C> listSize=new ArrayList<>();
            for(KhoSPDto l:list){
                C c =new C(l.getSize(),l.getSoLuongTon());
                listSize.add(c);

            }
            String anh=list.get(i).getHinhAnh();
            String[] hinhAnh=new String[4];
            hinhAnh=anh.split(";");
            B b=new B(listColor.get(i).toString(),hinhAnh, listSize);
            listb.add(b);
        }
        a.setChiTietSP(listb);
        a.setSanpham(sanPhamService.getbyID(masp));
        return a;
    }
    @GetMapping("")
    public List<A> getAllProduct(){
        List<A> listA=new ArrayList<>();
        List<SanPhamDto> listsp=sanPhamService.getAll();
        for(SanPhamDto dto:listsp){
            List<String> listColor=khoSPService.selectMauTheoMaSP(dto.getMaSP());
            A a=new A();
            List<B> listb=new ArrayList<>();
            for(int i=0;i<listColor.size();i++){
                List<KhoSPDto> list =khoSPService.selectbyID_Color(dto.getMaSP(),listColor.get(i).toString());
                List<C> listSize=new ArrayList<>();
                for(KhoSPDto l:list){
                    C c =new C(l.getSize(),l.getSoLuongTon());
                    listSize.add(c);

                }
                String anh=list.get(i).getHinhAnh();
                String[] hinhAnh=new String[4];
                hinhAnh=anh.split(";");
                B b=new B(listColor.get(i).toString(),hinhAnh, listSize);
                listb.add(b);
            }
            a.setChiTietSP(listb);
            a.setSanpham(sanPhamService.getbyID(dto.getMaSP()));
            listA.add(a);
        }
        return listA;
    }

        @PostMapping()
    public ResponseEntity insert (@RequestBody SanPham_khoSP sp){

        int id_kho=0;
        for (KhoSPDto khoSPDto: khoSPService.ListAll()){
            if(sp.getMaSP()==khoSPDto.getSanPham().getMaSP() && sp.getSize() == khoSPDto.getSize() && sp.getMau().equals(khoSPDto.getMau()))
            {
                return ResponseHelper.GenerateResponse(false, "Cant create product", HttpStatus.OK);
            }
            else id_kho=khoSPService.ListAll().size();

        }
            System.out.println(id_kho);
            List<SanPhamDto> listsanPham=sanPhamService.getAll();
        for (int i=0;i<listsanPham.size();i++) {
            if (listsanPham.get(i).getMaSP() == sp.getMaSP()) {
                KhoSPDto b = new KhoSPDto(sp.getSize(), sp.getSoLuongTon(), sp.getMau(), sanPhamService.getbyID(sp.getMaSP()), sp.getHinhAnh(), sp.getIdKho());
                b.setIdKho(khoSPService.ListAll().size()+1);
                khoSPService.save1(b.getIdKho(), b.getHinhAnh(),b.getMau(),b.getSize(),b.getSoLuongTon(),b.getSanPham().getMaSP());

                return ResponseHelper.GenerateResponse(true, "Create product success", HttpStatus.OK);

            }
        }
        int sl=listsanPham.size();
            System.out.println(sl);
        if(listsanPham.get(sl-1).getMaSP()!= sp.getMaSP()){
                SanPhamDto a= new SanPhamDto(sp.getMaSP(),sp.getTenSP(),sp.getGioiTinh(),sp.getMoTa(),sp.getGia(),
                        sp.getMaThuongHieu());
           //     a.setMaSP(sl);
                sanPhamService.save1(a);
                KhoSPDto b= new KhoSPDto(sp.getSize(),sp.getSoLuongTon(),sp.getMau(),a,sp.getHinhAnh(),sp.getIdKho() );
                b.setIdKho(khoSPService.ListAll().size()+1);
            System.out.println(b.getIdKho());
                khoSPService.save1(b.getIdKho(), b.getHinhAnh(),b.getMau(),b.getSize(),b.getSoLuongTon(),b.getSanPham().getMaSP());
                return ResponseHelper.GenerateResponse(true, "Create product success", HttpStatus.OK);

            }
            return ResponseHelper.GenerateResponse(true, "Create product success", HttpStatus.OK);
        }

    @DeleteMapping("{maSP}")
    public ResponseEntity delete(@PathVariable int maSP){
        List<KhoSPDto> a=khoSPService.findBySanPham_MaSP(maSP);
        if (a.size()>0){
            return ResponseHelper.GenerateResponse(false, "Cant not delete product", HttpStatus.OK);

        }else{

            sanPhamService.delete(maSP);
            return ResponseHelper.GenerateResponse(true, "Delete product success", HttpStatus.OK);

        }


    }
    @PostMapping("{masp}")
    private ResponseEntity editproduct(@PathVariable int masp, @RequestBody SanPhamDto dto){
        dto.setMaSP(masp);
        sanPhamService.save(dto);
        return ResponseHelper.GenerateResponse(true, "Edit product success", HttpStatus.OK);

    }
}
