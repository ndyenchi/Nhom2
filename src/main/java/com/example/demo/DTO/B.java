package com.example.demo.DTO;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class B {
    private String color;
    private String[] hinhAnh=new String[4];
    private List<C> soluong;
}
