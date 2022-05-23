package com.example.demo.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="HOA_DON_XUAT")
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DON_HANG {
    @Id
    @GeneratedValue
    @Column(name="MA_HD")
    private Integer maHD;
    @Column(name="TONG_TIEN")
    private long tongTien;
    @Column(name="NGAY")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="YYYY-MM-DD")
    private Date ngay;
    @Column(name="TRANG_THAI")
    private String trangThai;
    @ManyToOne
    @JoinColumn(name="CMND")
    private NHAN_VIEN ma_NV;
    @ManyToOne
    @JoinColumn(name="MAKH")
    private KHACH_HANG maKH_hoaDonXuat;


}
