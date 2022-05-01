package com.example.demo.DTO;

import lombok.*;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DanhGiaDto {
    private  Integer idDanhGia;
    private  String danhGia;
    private  Integer diemDanhGia;
    private  ChiTietDonHangDto idHoaDonXuat;
}
