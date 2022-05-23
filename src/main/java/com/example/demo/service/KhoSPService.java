package com.example.demo.service;

import com.example.demo.DTO.KhoSPDto;
import com.example.demo.entity.KHO_SP;
import com.example.demo.repository.KhoSPRepository;
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
public class KhoSPService {

    @Autowired
    private KhoSPRepository repo;
    @Autowired
    ModelMapper modelMapper;

    private KhoSPDto convertEntityToDto(KHO_SP user){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        KhoSPDto userLocationDTO = new KhoSPDto();
        userLocationDTO = modelMapper.map(user, KhoSPDto.class);
        return userLocationDTO;
    }

    private KHO_SP convertDtoToEntity(KhoSPDto userLocationDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        KHO_SP user = new KHO_SP();
        user = modelMapper.map(userLocationDTO, KHO_SP.class);
        return user;
    }
    public List<KhoSPDto> ListAll(){
        return  repo.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());

    }

    public KhoSPDto getbyID(Integer id){
        Optional<KHO_SP> e=repo.findById(id);
        KhoSPDto dto = convertEntityToDto(e.get());
        return dto;
    }

    public List<KhoSPDto> findByMau(String mau) {
        return repo.findByMau(mau)
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
    public List<KhoSPDto> findBySize(int size) {
        return repo.findBySize(size)
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }

    public void save(KhoSPDto dto){
        KHO_SP e=convertDtoToEntity(dto);
        repo.save(e);
    }


    public void save1(int masp, String gia, String gioiTinh, int mota, long tensp, int mathuonghieu) {
        repo.save1(masp, gia, gioiTinh, mota, tensp, mathuonghieu);
    }

    public List<KhoSPDto> findBySanPham_MaSP(int maSP) {
        return repo.findBySanPham_MaSP(maSP)
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }


    public List<String> selectMauTheoMaSP(int ma) {
        return repo.selectMauTheoMaSP(ma);
    }

    public List<KhoSPDto> selectbyID_Color(int id, String mau) {
        return repo.selectbyID_Color(id, mau)
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
}
