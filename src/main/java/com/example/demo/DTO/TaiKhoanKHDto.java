package com.example.demo.DTO;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaiKhoanKHDto  {
    private  String username;
    private  String password;
    private  KhachHangDto maKH_taiKhoan;
}
