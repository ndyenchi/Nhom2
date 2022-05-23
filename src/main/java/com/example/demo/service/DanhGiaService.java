package com.example.demo.service;


import com.example.demo.DTO.DanhGiaDto;
import com.example.demo.DTO.RoleDto;
import com.example.demo.entity.DANH_GIA;
import com.example.demo.entity.ROLE;
import com.example.demo.repository.DanhGiaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DanhGiaService {
    @Autowired
    private DanhGiaRepository repo;
    @Autowired
    private ModelMapper modelMapper;

    private DanhGiaDto convertEntityToDto(DANH_GIA user){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        DanhGiaDto userLocationDTO = new DanhGiaDto();
        userLocationDTO = modelMapper.map(user, DanhGiaDto.class);
        return userLocationDTO;
    }

    private DANH_GIA convertDtoToEntity(DanhGiaDto userLocationDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        DANH_GIA user = new DANH_GIA();
        user = modelMapper.map(userLocationDTO, DANH_GIA.class);
        return user;
    }

    public void save(DanhGiaDto dto) {
        repo.save(convertDtoToEntity(dto));
    }

    public List<DanhGiaDto> findByIdHoaDonXuat_IdKho_HDXuat_SanPham_MaSP(int maSP) {
        return repo.findByIdHoaDonXuat_IdKhoHDXuat_SanPham_MaSP(maSP)
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());

    }


    public void insert(int id, String nd, int diem, int hd) {
        repo.insert(id, nd, diem, hd);
    }

    public int getId(int id, String nd) {
        return repo.getId(id, nd);
    }

    public List<DanhGiaDto> findAll() {
        return repo.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());

    }
}
