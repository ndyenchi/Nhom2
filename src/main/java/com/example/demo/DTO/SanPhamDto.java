package com.example.demo.DTO;

import com.example.demo.entity.SAN_PHAM;
import com.example.demo.entity.THUONG_HIEU;
import lombok.*;

import javax.persistence.Column;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SanPhamDto {

    private Integer maSP;
    private String tenSP;
    private String gioiTinh;
    private String moTa;
    private Long gia;
    private String thuongHieuMaThuongHieu;



}
