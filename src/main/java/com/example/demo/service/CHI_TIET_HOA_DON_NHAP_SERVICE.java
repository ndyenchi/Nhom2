package com.example.demo.service;


import com.example.demo.DTO.ChiTieHoaDonNhapDto;
import com.example.demo.DTO.NhanVienDto;
import com.example.demo.entity.CT_HOA_DON_NHAP;
import com.example.demo.entity.NHAN_VIEN;
import com.example.demo.repository.CHI_TIET_HOA_DON_NHAP_REPOSITORY;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CHI_TIET_HOA_DON_NHAP_SERVICE {
    @Autowired
    private CHI_TIET_HOA_DON_NHAP_REPOSITORY repo;
    @Autowired
    private ModelMapper modelMapper;

    private ChiTieHoaDonNhapDto convertEntityToDto(CT_HOA_DON_NHAP user){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        ChiTieHoaDonNhapDto userLocationDTO = new ChiTieHoaDonNhapDto();
        userLocationDTO = modelMapper.map(user, ChiTieHoaDonNhapDto.class);
        return userLocationDTO;
    }

    private CT_HOA_DON_NHAP convertDtoToEntity(ChiTieHoaDonNhapDto userLocationDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        CT_HOA_DON_NHAP user = new CT_HOA_DON_NHAP();
        user = modelMapper.map(userLocationDTO, CT_HOA_DON_NHAP.class);
        return user;
    }



    public List<ChiTieHoaDonNhapDto> ListAll(){
        return repo.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());

    }

    public ChiTieHoaDonNhapDto get(Integer id){
        return convertEntityToDto(repo.findById(id).get());
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }

    public void save(ChiTieHoaDonNhapDto CTHoaDonNhap){
        repo.save(convertDtoToEntity(CTHoaDonNhap));
    }

    public List<ChiTieHoaDonNhapDto> findByHoaDon_MaHDNhap(int maHDNhap) {
        return repo.findByHoaDon_MaHDNhap(maHDNhap)
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());

    }
}
