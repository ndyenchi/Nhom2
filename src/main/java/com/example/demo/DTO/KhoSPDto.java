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
    private Integer maSPMaSP;
    private String hinhAnh;
    private Integer idKho;
}
