package com.example.demo.DTO;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NhanVienDto {
    private  String sdt;
    private  String hoTen;
    private  Date ngaySinh;
    private  String cmnd;
    private  String email;
    private  Boolean gioiTinh;
}
