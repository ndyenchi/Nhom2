package com.example.demo.service;

import com.example.demo.DTO.RoleDto;
import com.example.demo.DTO.ThuongHieuDto;
import com.example.demo.entity.ROLE;
import com.example.demo.entity.THUONG_HIEU;
import com.example.demo.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleService {
    @Autowired
    private RoleRepository repo;
    @Autowired
    private ModelMapper modelMapper;

    private RoleDto convertEntityToDto(ROLE user){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        RoleDto userLocationDTO = new RoleDto();
        userLocationDTO = modelMapper.map(user, RoleDto.class);
        return userLocationDTO;
    }

    private ROLE convertDtoToEntity(RoleDto userLocationDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        ROLE user = new ROLE();
        user = modelMapper.map(userLocationDTO, ROLE.class);
        return user;
    }

    public List<RoleDto> ListAll(){
        return repo.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());

    }

    public RoleDto findByID(String id){
        Optional<ROLE> e=repo.findById(id);
        RoleDto dto=convertEntityToDto(e.get());
        return dto;
    }

    public void delete(String id){
        repo.deleteById(id);
    }

    public void save(RoleDto role){
        ROLE e=convertDtoToEntity(role);
        repo.save(e);
    }

    public void insert(String maQuyen, String tenQuyen) {
        repo.insert(maQuyen,tenQuyen);
    }


    public void editByMa(String maQuyen, String tenQuyen){
        repo.editByMa(maQuyen,tenQuyen);
    }

}
