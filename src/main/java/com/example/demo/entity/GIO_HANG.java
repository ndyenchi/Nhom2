package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="GIO_HANG")
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GIO_HANG {
    @Id
    @GeneratedValue
    @Column(name="ID_GIO_HANG")
    private Integer idGioHang;
    @Column(name="SO_LUONG")
    private  Integer soLuong;

    @ManyToOne
    @JoinColumn(name="ID_KHO")
    private KHO_SP idKho_GioHang;
    @ManyToOne
    @JoinColumn(name="MAKH")
    private KHACH_HANG maKH_GioHang;
}
