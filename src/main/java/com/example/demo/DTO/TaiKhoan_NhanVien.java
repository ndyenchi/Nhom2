package com.example.demo.DTO;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaiKhoan_NhanVien {
    private String username;
    private Boolean trangThai;
    private  String sdt;
    private  String hoTen;
    private Date ngaySinh;
    private  String cmnd;
    private  String email;
    private  Boolean gioiTinh;
    private String password;
    private String maQuyen;

    public TaiKhoan_NhanVien( String sdt, String hoTen, Date ngaySinh, String cmnd, String email, Boolean gioiTinh,String username, Boolean trangThai, String QUYENMaQuyen) {
        this.username = username;
        this.trangThai = trangThai;
        this.maQuyen = QUYENMaQuyen;
        this.sdt = sdt;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.cmnd = cmnd;
        this.email = email;
        this.gioiTinh = gioiTinh;
    }

}
