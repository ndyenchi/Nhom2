package com.example.demo.service;


import com.example.demo.DTO.KhoSPDto;
import com.example.demo.DTO.SanPhamDto;
import com.example.demo.DTO.ThuongHieuDto;
import com.example.demo.entity.KHO_SP;
import com.example.demo.entity.SAN_PHAM;
import com.example.demo.entity.THUONG_HIEU;
import com.example.demo.repository.SanPhamRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SanPhamService {
    @Autowired
    private SanPhamRepository repo;
    @Autowired
    private ModelMapper modelMapper;

    public List<SanPhamDto> getAll(){
        return repo.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());

    }

    public SanPhamDto getbyID(Integer id){
        Optional<SAN_PHAM> e=repo.findById(id);
        SanPhamDto dto = convertEntityToDto(e.get());
        return dto;
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }

    public void save(SanPhamDto sp){
        SAN_PHAM e = convertDtoToEntity(sp);
        repo.save(e);
    }

    public List<SanPhamDto> select(String gioiTinh){
        List<SAN_PHAM> e=repo.selectGioiTinh(gioiTinh);
        List<SanPhamDto> dto=new ArrayList<>();
        for(SAN_PHAM t:e){
            SanPhamDto sanPhamDto = modelMapper.map(t, SanPhamDto.class);
            dto.add(sanPhamDto);
        }
        return dto;
    }

    private SanPhamDto convertEntityToDto(SAN_PHAM user){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        SanPhamDto userLocationDTO = new SanPhamDto();
        userLocationDTO = modelMapper.map(user, SanPhamDto.class);
        return userLocationDTO;
    }

    private SAN_PHAM convertDtoToEntity(SanPhamDto userLocationDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        SAN_PHAM user = new SAN_PHAM();
        user = modelMapper.map(userLocationDTO, SAN_PHAM.class);
        return user;
    }

}
