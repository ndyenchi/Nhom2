package com.example.demo.DTO;

import lombok.*;

import java.util.Date;
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KhachHang_TaiKhoan {
    private  String hoTen;
    private Date ngaySinh;
    private  String diaChi;
    private  String danhGiatiemNang;
    private  String luuY;
    private  String email;
    private  String maKH;
    private String username;
}
