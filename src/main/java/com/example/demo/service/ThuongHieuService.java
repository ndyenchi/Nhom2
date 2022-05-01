package com.example.demo.service;

import com.example.demo.DTO.SanPhamDto;
import com.example.demo.DTO.ThuongHieuDto;
import com.example.demo.entity.THUONG_HIEU;
import com.example.demo.repository.ThuongHieuRepository;
import net.bytebuddy.description.NamedElement;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ThuongHieuService {
    @Autowired
    private ThuongHieuRepository repo;
    @Autowired
    private ModelMapper modelMapper;
    public List<ThuongHieuDto> getAll(){
        return repo.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());

    }

    public void delete(String id) {
        repo.deleteById(id);
    }

   public ThuongHieuDto selectbyID(String id){
        List<THUONG_HIEU> e=repo.selectbyID(id);
       ThuongHieuDto dto = modelMapper.map(e.get(0), ThuongHieuDto.class);
       return dto;
   }

    public void save(THUONG_HIEU thuongHieu) {
            repo.save(thuongHieu);
    }

    public void insert(String maThuongHieu, String tenThuongHieu) {
        repo.insert(maThuongHieu,tenThuongHieu);
    }


    public void editByMa(String maThuongHieu, String tenThuongHieu){
        repo.editByMa(maThuongHieu,tenThuongHieu);
    }


    private ThuongHieuDto convertEntityToDto(THUONG_HIEU user){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        ThuongHieuDto userLocationDTO = new ThuongHieuDto();
        userLocationDTO = modelMapper.map(user, ThuongHieuDto.class);
        return userLocationDTO;
    }

    private THUONG_HIEU convertDtoToEntity(ThuongHieuDto userLocationDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        THUONG_HIEU user = new THUONG_HIEU();
        user = modelMapper.map(userLocationDTO, THUONG_HIEU.class);
        return user;
    }
}
