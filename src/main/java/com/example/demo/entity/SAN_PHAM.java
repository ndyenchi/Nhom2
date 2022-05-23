package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="SAN_PHAM")
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SAN_PHAM {
    @Id
    @GeneratedValue
    @Column(name="MASP")
    private Integer maSP;
    @Column(name="TENSP")
    private String tenSP;
    @Column(name="GIOITINH")
    private String gioiTinh;
    @Column(name="MOTA")
    private String moTa;
    @Column(name="GIA")
    private String gia;
    @ManyToOne
    @JoinColumn(name="MA_THUONG_HIEU")
    private THUONG_HIEU thuongHieu;


    @OneToMany(mappedBy = "MA_GIAM")
    private Collection<CHI_TIET_GIAM_GIA> chiTietGiamGia;

    @OneToMany(mappedBy = "sanPham")
    private Collection<KHO_SP> khoSP;

}
