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
    private  String QUYENMaquyen;
    private  NhanVienDto maNV;

    public TaiKhoanNVDto(String username, String password, Boolean trangThai, String QUYENMaquyen) {
        this.username = username;
        this.password = password;
        this.trangThai = trangThai;
        this.QUYENMaquyen = QUYENMaquyen;
    }
}
