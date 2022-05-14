package com.example.demo.entity;

import lombok.*;


import javax.persistence.*;

@Entity
@Table(name="TAI_KHOAN_NV")
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TAI_KHOAN_NV {
    @Id
    @Column(name="USERNAME")
    private String username;
    @Column(name="MAT_KHAU")
    private String  password;
    @Column(name="TRANG_THAI")
    private Boolean trangThai;
    @ManyToOne
    @JoinColumn(name = "MA_QUYEN")
    private ROLE QUYEN;
    @ManyToOne
    @JoinColumn(name="CMND")
    private NHAN_VIEN maNV;

    public TAI_KHOAN_NV(String username,String password, Boolean trangThai) {
        this.username=username;
        this.password = password;
        this.trangThai = trangThai;

    }
}
