package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="CT_HOA_DON_NHAP")
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CT_HOA_DON_NHAP {
    @Id
    @GeneratedValue
    @Column(name="ID_HD_NHAP")
    private Integer idHoaDonNhap;
    @ManyToOne
    @JoinColumn(name="MAHD_NHAP")
    private HOA_DON_NHAP maHoaDonNhap;
    @Column(name="SO_LUONG_NHAP")
    private Integer soLuongNhap;
    @ManyToOne
    @JoinColumn(name = "ID_KHO")
    private KHO_SP idKho_HDNhap;
    @Column(name = "GIA_NHAP")
    private float gia_Nhap;

}
