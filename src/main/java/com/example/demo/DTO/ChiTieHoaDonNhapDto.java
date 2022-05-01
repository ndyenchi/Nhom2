package com.example.demo.DTO;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChiTieHoaDonNhapDto  {
    private  Integer idHoaDonNhap;
    private  HoaDonNhapDto maHoaDonNhap;
    private  Integer soLuongNhap;
    private  KhoSPDto idKho_HDNhap;
    private  float gia_Nhap;
}
