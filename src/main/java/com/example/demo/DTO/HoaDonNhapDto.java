package com.example.demo.DTO;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonNhapDto  {
    private  Integer maHDNhap;
    private  NhanVienDto maNV;
    private  Date ngayNhap;
    private  Long tongTien;
}
