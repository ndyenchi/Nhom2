package com.example.demo.service;


import com.example.demo.DTO.TaiKhoanNVDto;
import com.example.demo.entity.TAI_KHOAN_NV;
import com.example.demo.repository.TaiKhoanNVRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Optional<TAI_KHOAN_NV> get(String id) {
        return repo.findById(id);
    }

    public void delete(String id) {
        repo.deleteById(id);
    }

    public void save(TAI_KHOAN_NV TaiKhoanNV) {
        repo.save(TaiKhoanNV);
    }

    public void deleteNhanVien(String id) {
        repo.deleteNhanVien(id);
    }

}
