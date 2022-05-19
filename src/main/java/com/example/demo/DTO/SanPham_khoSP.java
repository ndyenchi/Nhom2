package com.example.demo.DTO;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SanPham_khoSP {
    private Integer maSP;
    private String tenSP;
    private String gioiTinh;
    private String moTa;
    private Long gia;
    private String maThuongHieu;
    private Integer size;
    private long soLuongTon;
    private String mau;
    private String hinhAnh;
    private Integer IdKho;


}
