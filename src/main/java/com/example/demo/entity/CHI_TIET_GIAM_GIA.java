package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="CHI_TIET_GIAM_GIA")
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CHI_TIET_GIAM_GIA {
    @Id
    @GeneratedValue
    @Column(name="ID_GIAM_GIA")
    private Integer idGiamGia;

    @ManyToOne
    @JoinColumn(name="MASP")
    private SAN_PHAM MA_GIAM;

    @ManyToOne
    @JoinColumn(name="MA_GIAM")
    private KHUYEN_MAI maGiamGia;
}
