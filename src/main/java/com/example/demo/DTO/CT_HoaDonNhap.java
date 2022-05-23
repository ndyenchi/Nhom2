package com.example.demo.DTO;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CT_HoaDonNhap {
    private  Integer soLuongNhap;
    private  float gia_Nhap;
    private Date ngayNhap;
    private  Long tongTien;
    private  String maNV;
    private List<KhoSPDto> sanPham;
}
