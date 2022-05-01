package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
@Entity
@Table(name="HOA_DON_NHAP")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class HOA_DON_NHAP {
    @Id
    @GeneratedValue
    @Column(name="MAHD_NHAP")
    private Integer maHDNhap;
    @ManyToOne
    @JoinColumn(name="MANV")
    private NHAN_VIEN maNV;
    @Column(name="NGAY_NHAP")
    private Date ngayNhap;
    @Column(name="TONG_TIEN")
    private Long tongTien;
}
