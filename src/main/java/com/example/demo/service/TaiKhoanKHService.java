package com.example.demo.service;


import com.example.demo.DTO.KhachHangDto;
import com.example.demo.DTO.TaiKhoanKHDto;
import com.example.demo.DTO.TaiKhoanNVDto;
import com.example.demo.entity.KHACH_HANG;
import com.example.demo.entity.TAI_KHOAN_KH;
import com.example.demo.repository.TaiKhoanKHRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TaiKhoanKHService {
    @Autowired
    private TaiKhoanKHRepository repo;
    @Autowired
    private ModelMapper modelMapper;
    private TAI_KHOAN_KH convertDtoToEntity(TaiKhoanKHDto userLocationDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        TAI_KHOAN_KH user = new TAI_KHOAN_KH();
        user = modelMapper.map(userLocationDTO, TAI_KHOAN_KH.class);
        return user;
    }
    private TaiKhoanKHDto convertEntityToDto(TAI_KHOAN_KH user){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        TaiKhoanKHDto userLocationDTO = new TaiKhoanKHDto();
        userLocationDTO = modelMapper.map(user, TaiKhoanKHDto.class);
        return userLocationDTO;
    }

    public List<TAI_KHOAN_KH> ListAll(){
        return (List<TAI_KHOAN_KH>) repo.findAll();
    }

    public Optional<TAI_KHOAN_KH> get(String id){
        return repo.findById(id);
    }

    public void delete(String id){
        repo.deleteById(id);
    }

    public void save(TaiKhoanKHDto dto){
        TAI_KHOAN_KH ent=convertDtoToEntity(dto);
        repo.save(ent);
    }
    public void insert(String username, String password, String maKH){
        repo.insert(username, password, maKH);
    }
}
