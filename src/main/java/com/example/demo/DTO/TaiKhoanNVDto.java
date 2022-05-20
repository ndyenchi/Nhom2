package com.example.demo.DTO;

import lombok.*;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaiKhoanNVDto {
    private  String username;
    private  String password;
    private  Boolean trangThai;
    private  String QUYENMaQuyen;
    private  NhanVienDto maNV;
}
