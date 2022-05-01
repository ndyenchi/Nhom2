package com.example.demo.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="KHACH_HANG")
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KHACH_HANG {

    @Column(name="HO_TEN")
    private String hoTen;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="DD/MM/YYYY")
    @Column(name="NGAY_SINH")
    private Date ngaySinh;
    @Column(name="DIA_CHI")
    private String diaChi;
    @Column(name="DANH_GIA_TIEM_NANG")
    private  String danhGiatiemNang;
    @Column(name="LUU_Y")
    private String luuY;
    @Column(name="EMAIL")
    private  String email;

    @Id
    @Column(name="MAKH")
    private String maKH;

    @OneToMany(mappedBy = "maKH_taiKhoan")
    private Collection<TAI_KHOAN_KH> taiKhoanKh;


    @OneToMany(mappedBy = "maKH_hoaDonXuat")
    private Collection<DON_HANG> donHang ;

    @OneToMany(mappedBy = "idKho_GioHang")
    private Collection<GIO_HANG> gioHang;

}
