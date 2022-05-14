package com.example.demo.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="NHAN_VIEN")
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NHAN_VIEN {
    @Column(name="SDT")
    private String sdt;
    @Column(name="HO_TEN")
    private String hoTen;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="DD/MM/YYYY")
    @Column(name="NGAY_SINH")
    private Date ngaySinh;
    @Id
    @Column(name="CMND")
    private String cmnd;
    @OneToMany(mappedBy = "maNV", cascade = CascadeType.ALL)
    private Collection<TAI_KHOAN_NV> taiKhoanNv;
    @OneToMany(mappedBy = "ma_NV", cascade = CascadeType.ALL)
    private Collection<DON_HANG> hoaDonXuat;
    @Column(name="EMAIL")
    private String email;
    @Column(name="GIOI_TINH")
    private Boolean gioiTinh;

    public NHAN_VIEN(String sdt, String hoTen, Date ngaySinh, String cmnd, String email, Boolean gioiTinh) {
        this.sdt = sdt;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.cmnd = cmnd;
        this.email = email;
        this.gioiTinh = gioiTinh;
    }
}
