package com.example.demo.DTO;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class A {
    private List<B> chiTietSP;
    private SanPhamDto sanpham;
}
