package com.example.demo.DTO;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietDonHangDto {
    private  Integer idHoaDonXuat;
    private  String ghiChu;
    private  String soLuongXuat;
    private  DonHangDto maHDXuat;
    private  KhoSPDto idKho_HDXuat;
}
