package com.example.demo.service;

import com.example.demo.DTO.KhachHangDto;
import com.example.demo.DTO.KhachHangDto;
import com.example.demo.DTO.KhachHangDto;
import com.example.demo.DTO.ThuongHieuDto;
import com.example.demo.entity.KHACH_HANG;
import com.example.demo.entity.KHACH_HANG;
import com.example.demo.entity.THUONG_HIEU;
import com.example.demo.repository.KhachHangRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KhachHangService {
    @Autowired
    private KhachHangRepository repo;
    @Autowired
    private ModelMapper modelMapper;
    private KHACH_HANG convertDtoToEntity(KhachHangDto userLocationDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        KHACH_HANG user = new KHACH_HANG();
        user = modelMapper.map(userLocationDTO, KHACH_HANG.class);
        return user;
    }
    private KhachHangDto convertEntityToDto(KHACH_HANG user){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        KhachHangDto userLocationDTO = new KhachHangDto();
        userLocationDTO = modelMapper.map(user, KhachHangDto.class);
        return userLocationDTO;
    }

    public List<KhachHangDto> getAll(){
        return repo.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());

    }
    public Optional<KhachHangDto> findById(String s) {
        Optional<KHACH_HANG> t = repo.findById(s);
        KhachHangDto z = new KhachHangDto();
        z=convertEntityToDto(t.get());
        Optional<KhachHangDto> x =  Optional.of(z);
        return x;
    }

    public void deleteById(String s) {
        repo.deleteById(s);
    }

//    public void edit(KhachHangDto d){
//        repo.editByMa(d.getHoTen(),d.getNgaySinh(),d.getDiaChi(),d.getDanhGiatiemNang(),d.getLuuY(), d.getMaKH());
//    }

    public <S extends KHACH_HANG> S save(S entity) {
        return repo.save(entity);
    }
}
