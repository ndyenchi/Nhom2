package com.example.demo.service;

import com.example.demo.DTO.ChiTieHoaDonNhapDto;
import com.example.demo.DTO.HoaDonNhapDto;
import com.example.demo.entity.CT_HOA_DON_NHAP;
import com.example.demo.entity.HOA_DON_NHAP;
import com.example.demo.repository.HoaDonNhapRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HoaDonNhapService {
    @Autowired
    private HoaDonNhapRepository repo;
    @Autowired
    private ModelMapper modelMapper;

    private HoaDonNhapDto convertEntityToDto(HOA_DON_NHAP user){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        HoaDonNhapDto userLocationDTO = new HoaDonNhapDto();
        userLocationDTO = modelMapper.map(user, HoaDonNhapDto.class);
        return userLocationDTO;
    }

    private HOA_DON_NHAP convertDtoToEntity(HoaDonNhapDto userLocationDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        HOA_DON_NHAP user = new HOA_DON_NHAP();
        user = modelMapper.map(userLocationDTO, HOA_DON_NHAP.class);
        return user;
    }


    public List<HOA_DON_NHAP> ListAll(){
        return (List<HOA_DON_NHAP>) repo.findAll();
    }

    public Optional<HOA_DON_NHAP> get(Integer id){
        return repo.findById(id);
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }

    public void save(HoaDonNhapDto HoaDonNhap){
        repo.save(convertDtoToEntity(HoaDonNhap));
    }
}
