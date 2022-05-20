package com.example.demo.service;

import com.example.demo.DTO.GioHangDto;
import com.example.demo.DTO.KhachHangDto;
import com.example.demo.DTO.KhoSPDto;
import com.example.demo.entity.GIO_HANG;
import com.example.demo.entity.KHACH_HANG;
import com.example.demo.entity.KHO_SP;
import com.example.demo.repository.GioHangRepository;
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
public class GioHangService {
    @Autowired
    private GioHangRepository repo;

    @Autowired
    private ModelMapper modelMapper;
    private GIO_HANG convertDtoToEntity(GioHangDto userLocationDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        GIO_HANG user = new GIO_HANG();
        user = modelMapper.map(userLocationDTO, GIO_HANG.class);
        return user;
    }
    private GioHangDto convertEntityToDto(GIO_HANG user){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        GioHangDto userLocationDTO = new GioHangDto();
        userLocationDTO = modelMapper.map(user, GioHangDto.class);
        return userLocationDTO;
    }


    public List<GioHangDto> ListAll(){
        return  repo.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());

    }

    public List<GioHangDto> findByMaKH_GioHang_MaKH(String maKH) {
        return repo.findByKhachHang_MaKH(maKH)
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public void save (GioHangDto dto) {
       GIO_HANG entity =convertDtoToEntity(dto);
       repo.save(entity);
    }


    public GioHangDto getByMaKH_IdSanPham(String maKH, Integer id) {
        GIO_HANG e=repo.getByMaKH_IdSanPham(maKH, id);
        return convertEntityToDto(e);
    }

    public void delete(GioHangDto dto) {
        repo.delete(convertDtoToEntity(dto));
    }
}
