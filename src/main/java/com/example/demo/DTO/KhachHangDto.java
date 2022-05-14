package com.example.demo.DTO;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhachHangDto  {
    private  String hoTen;
    private  Date ngaySinh;
    private  String diaChi;
    private  String danhGiatiemNang;
    private  String luuY;
    private  String email;
    private  String maKH;

    public KhachHangDto(String hoTen, Date ngaySinh, String diaChi, String danhGiatiemNang, String luuY, String email) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.danhGiatiemNang = danhGiatiemNang;
        this.luuY = luuY;
        this.email = email;
    }
}
