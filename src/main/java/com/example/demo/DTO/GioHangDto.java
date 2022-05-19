package com.example.demo.DTO;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GioHangDto{
    private  Integer idGioHang;
    private  Integer soLuong;
    private  KhoSPDto idKho_GioHang;
    private  String maKH;
}
