package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="CHI_TIET_HOA_DON_XUAT")
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CHI_TIET_DON_HANG {
    @Id
    @GeneratedValue
    @Column(name="ID_HD_XUAT")
    private Integer idHoaDonXuat;
    @Column(name="GHI_CHU")
    private String ghiChu;
    @Column(name="SOLUONG_XUAT")
    private String soLuongXuat;

    @ManyToOne
    @JoinColumn(name="MA_HD")
    private DON_HANG maHDXuat;

    @ManyToOne
    @JoinColumn(name="ID_KHO")
    private KHO_SP idKhoHDXuat;


}
