package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="ROLE")
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ROLE {
    @Id
    @GeneratedValue
    @Column(name="MA_QUYEN")
    private String maQuyen;
    @OneToMany(mappedBy = "QUYEN", cascade = CascadeType.ALL)
    private Collection<TAI_KHOAN_NV> taiKhoanNv;
    @Column(name="TEN_QUYEN")
    private  String tenQuyen;
}
