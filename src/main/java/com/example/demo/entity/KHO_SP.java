package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="KHO_SP")
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KHO_SP {

    @Column(name = "SIZE")
    private Integer size;
    @Column(name = "SO_LUONG_TON")
    private long soLuongTon;
    @Column(name = "MAU")
    private String mau;
    @Id
    @GeneratedValue
    @Column(name = "ID_KHO")
    private Integer idKho;
    @OneToMany(mappedBy = "idKhoGioHang", cascade = CascadeType.ALL)
    Collection<GIO_HANG> gioHang;
    @OneToMany(mappedBy = "idKho_HDNhap", cascade = CascadeType.ALL)
    Collection<CT_HOA_DON_NHAP> ctHoaDonNhap;

    @OneToMany(mappedBy = "idKhoHDXuat", cascade = CascadeType.ALL)
    Collection<CHI_TIET_DON_HANG> ctHoaDonXuat;

    @ManyToOne
    @JoinColumn(name = "MASP")
    private SAN_PHAM sanPham;

    @Column(name = "ANH")
    private String hinhAnh;
//  //  private String[] hinhAnh={"","","",""};
//
//    private String[] hinhAnh=new String[4];
//    @Column(name = "ANH2")
//    private String hinhAnh2;
//    @Column(name = "ANH3")
//    private String hinhAnh3;
//    @Column(name = "ANH4")
//    private String hinhAnh4;
//}

}
