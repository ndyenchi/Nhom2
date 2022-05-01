package com.example.demo.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="KHUYEN_MAI")
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KHUYEN_MAI {
    @Id
    @Column(name="MA_GIAM")
    private String maGiam;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="DD/MM/YYYY")
    @Column(name="NGAY_BAT_DAU")
    private Date ngayBatDau;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="DD/MM/YYYY")
    @Column(name="NGAY_KET_THUC")
    private Date ngayKetThuc;
    @Column(name="PHAN_TRAM")
    private Integer phanTram;

    @OneToMany(mappedBy = "maGiamGia")
    private Collection<CHI_TIET_GIAM_GIA> chiTietGiamGia;
}
