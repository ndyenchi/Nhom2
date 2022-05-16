package com.example.demo.service;


import com.example.demo.DTO.NhanVienDto;
import com.example.demo.DTO.TaiKhoanNVDto;
import com.example.demo.entity.NHAN_VIEN;
import com.example.demo.entity.TAI_KHOAN_NV;
import com.example.demo.repository.TaiKhoanNVRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaiKhoanNVService {
    @Autowired
    private TaiKhoanNVRepository repo;
    @Autowired
    ModelMapper modelMapper;
    private TaiKhoanNVDto convertEntityToDto(TAI_KHOAN_NV user){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        TaiKhoanNVDto userLocationDTO = new TaiKhoanNVDto();
        userLocationDTO = modelMapper.map(user, TaiKhoanNVDto.class);
        return userLocationDTO;
    }

    private TAI_KHOAN_NV convertDtoToEntity(TaiKhoanNVDto userLocationDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        TAI_KHOAN_NV user = new TAI_KHOAN_NV();
        user = modelMapper.map(userLocationDTO, TAI_KHOAN_NV.class);
        return user;
    }


    public List<TaiKhoanNVDto> ListAll() {
        return repo.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
    public List<TAI_KHOAN_NV> ListAll1() {
        return repo.findAll();
    }



    public void insert(String f, String g, Boolean h, String i, String k) {
        TaiKhoanNVDto dto=new TaiKhoanNVDto(f,g,h,i,k);
        TAI_KHOAN_NV e= convertDtoToEntity(dto);
        repo.insert(e.getUsername(),e.getPassword(),e.getTrangThai(),e.getQUYEN().getMaQuyen(),e.getMaNV().getCmnd());
    }
    public void deleteNhanVien(String id) {
        repo.deleteNhanVien(id);
    }

    public <S extends TAI_KHOAN_NV> S save(S entity) {
        return repo.save(entity);
    }
}
