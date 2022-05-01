package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="THUONG_HIEU")
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class THUONG_HIEU {
    @Id
    @GeneratedValue
    @Column(name="MA_THUONG_HIEU")
    private String maThuongHieu;
    @OneToMany(mappedBy = "thuongHieu")
    private Collection<SAN_PHAM> sanPham;
    @Column(name="TEN_THUONG_HIEU")
    private String tenThuongHieu;
}
