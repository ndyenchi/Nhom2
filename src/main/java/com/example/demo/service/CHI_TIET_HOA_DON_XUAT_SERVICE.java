package com.example.demo.service;

import com.example.demo.DTO.ChiTietDonHangDto;
import com.example.demo.DTO.DonHangDto;
import com.example.demo.entity.CHI_TIET_DON_HANG;
import com.example.demo.entity.DON_HANG;
import com.example.demo.repository.ChiTietDonHangRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CHI_TIET_HOA_DON_XUAT_SERVICE {
    @Autowired
    private ChiTietDonHangRepository repo;
    @Autowired
    ModelMapper modelMapper;
    private ChiTietDonHangDto convertEntityToDto(CHI_TIET_DON_HANG don_hang){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        ChiTietDonHangDto userLocationDTO = new ChiTietDonHangDto();
        userLocationDTO = modelMapper.map(don_hang, ChiTietDonHangDto.class);
        return userLocationDTO;
    }
    private CHI_TIET_DON_HANG convertDtoToEntity(ChiTietDonHangDto hangDto){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        CHI_TIET_DON_HANG dh = new CHI_TIET_DON_HANG();
        dh = modelMapper.map(hangDto, CHI_TIET_DON_HANG.class);
        return dh;
    }
    public List<CHI_TIET_DON_HANG> ListAll(){

        return (List<CHI_TIET_DON_HANG>) repo.findAll();
    }

    public Optional<CHI_TIET_DON_HANG> get(Integer id){
        return repo.findById(id);
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }

    public void save(ChiTietDonHangDto ChiTietHoaDonXuat){
        repo.save(convertDtoToEntity(ChiTietHoaDonXuat));
    }

}
