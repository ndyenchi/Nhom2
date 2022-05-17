package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="TAI_KHOAN_KH")
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TAI_KHOAN_KH {
    @Id
    @Column(name="USERNAME")
    private String username;
    @Column(name="MAT_KHAU")
    private String password;
    @ManyToOne
    @JoinColumn(name="MAKH")
    private KHACH_HANG maKH_taiKhoan;


}
