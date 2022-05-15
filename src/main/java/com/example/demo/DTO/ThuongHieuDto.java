package com.example.demo.DTO;

import com.example.demo.entity.THUONG_HIEU;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThuongHieuDto {
    public String maThuongHieu;
    public String tenThuongHieu;
}
