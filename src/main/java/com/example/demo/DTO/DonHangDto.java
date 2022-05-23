package com.example.demo.DTO;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DonHangDto {
    private  Integer maHD;
    private  long tongTien;
    private  Date ngay;
    private  String trangThai;
    private  NhanVienDto ma_NV;
    private  KhachHangDto maKH_hoaDonXuat;
}
