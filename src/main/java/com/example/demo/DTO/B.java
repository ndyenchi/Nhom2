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
    private List<C> soluong;
}
