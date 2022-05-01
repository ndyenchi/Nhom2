package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="DANH_GIA")
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DANH_GIA {
    @Id
    @GeneratedValue
    @Column(name="ID_DANH_GIA")
    private Integer idDanhGia;
    @Column(name="DANH_GIA")
    private String danhGia;
    @Column(name="DIEM_DANH_GIA")
    private Integer diemDanhGia;

    @ManyToOne
    @JoinColumn(name="ID_HD_XUAT")
    private CHI_TIET_DON_HANG idHoaDonXuat;

}
