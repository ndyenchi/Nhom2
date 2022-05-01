package com.example.demo.DTO;

import lombok.*;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietGiamGiaDto {
    private  Integer idGiamGia;
    private  SanPhamDto MA_GIAM;
    private  KhuyenMaiDto maGiamGia;
}
