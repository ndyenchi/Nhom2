package com.example.demo.DTO;

import com.example.demo.entity.KHO_SP;
import com.example.demo.entity.SAN_PHAM;
import lombok.*;

import javax.persistence.Column;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhoSPDto {
    private Integer size;
    private long soLuongTon;
    private String mau;
    private SanPhamDto sanPham;
  //  private String hinhAnh;
    private String[] hinhAnh={"","","",""};
    private Integer idKho;


    public KhoSPDto(Integer size, long soLuongTon, String mau, String[] hinhAnh, Integer idKho) {
        this.size = size;
        this.soLuongTon = soLuongTon;
        this.mau = mau;
        this.hinhAnh = hinhAnh;
        this.idKho = idKho;
    }
}
