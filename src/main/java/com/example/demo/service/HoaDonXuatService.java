package com.example.demo.service;

import com.example.demo.DTO.*;
import com.example.demo.entity.DON_HANG;
import com.example.demo.entity.HOA_DON_NHAP;
import com.example.demo.entity.SAN_PHAM;
import com.example.demo.entity.TAI_KHOAN_NV;
import com.example.demo.repository.DonHangRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HoaDonXuatService {
    @Autowired
    private DonHangRepository repo;
    @Autowired
    ModelMapper modelMapper;
    private DonHangDto convertEntityToDto(DON_HANG don_hang){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        DonHangDto userLocationDTO = new DonHangDto();
        userLocationDTO = modelMapper.map(don_hang, DonHangDto.class);
        return userLocationDTO;
    }
    private DON_HANG convertDtoToEntity(DonHangDto hangDto){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        DON_HANG dh = new DON_HANG();
        dh = modelMapper.map(hangDto, DON_HANG.class);
        return dh;
    }

    public List<DonHangDto> ListAll(){
        return repo.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public DonHangDto getbyID(Integer id){
        Optional<DON_HANG> e=repo.findById(id);
        DonHangDto dto = convertEntityToDto(e.get());
        return dto;
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }

    public List<DonHangDto> findBy_MaHD(int maHD){
        List<DON_HANG> e=repo.findBymaHD(maHD);
        List<DonHangDto> dto=new ArrayList<>();
        for(DON_HANG t:e){
            DonHangDto donHangDto = modelMapper.map(t, DonHangDto.class);
            dto.add(donHangDto);
        }
        return dto;
    }

    public void save(DonHangDto hoaDonXuat){
        repo.save(convertDtoToEntity(hoaDonXuat));
    }

//    public List<DonHangDto> findBy_MaHD(int maHD) {
//        return repo.findBymaHD(maHD)
//                .stream()
//                .map(this::convertEntityToDto)
//                .collect(Collectors.toList());
//    }

    public void save(DON_HANG HoaDonXuat){
        repo.save(HoaDonXuat);
    }
}
