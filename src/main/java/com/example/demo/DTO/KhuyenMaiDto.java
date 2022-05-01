package com.example.demo.DTO;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhuyenMaiDto  {
    private  String maGiam;
    private  Date ngayBatDau;
    private  Date ngayKetThuc;
    private  Integer phanTram;
}
