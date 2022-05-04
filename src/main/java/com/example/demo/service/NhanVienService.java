package com.example.demo.service;

import com.example.demo.DTO.NhanVienDto;
import com.example.demo.DTO.TaiKhoanNVDto;
import com.example.demo.entity.NHAN_VIEN;
import com.example.demo.entity.TAI_KHOAN_NV;
import com.example.demo.repository.NhanVienRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository repo;
    @Autowired
    private ModelMapper modelMapper;

    private NhanVienDto convertEntityToDto(NHAN_VIEN user){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        NhanVienDto userLocationDTO = new NhanVienDto();
        userLocationDTO = modelMapper.map(user, NhanVienDto.class);
        return userLocationDTO;
    }

    private NHAN_VIEN convertDtoToEntity(NhanVienDto userLocationDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        NHAN_VIEN user = new NHAN_VIEN();
        user = modelMapper.map(userLocationDTO, NHAN_VIEN.class);
        return user;
    }
    private TaiKhoanNVDto convertEntityToDto1(TAI_KHOAN_NV user){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        TaiKhoanNVDto userLocationDTO = new TaiKhoanNVDto();
        userLocationDTO = modelMapper.map(user, TaiKhoanNVDto.class);
        return userLocationDTO;
    }

    private TAI_KHOAN_NV convertDtoToEntity1(TaiKhoanNVDto userLocationDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        TAI_KHOAN_NV user = new TAI_KHOAN_NV();
        user = modelMapper.map(userLocationDTO, TAI_KHOAN_NV.class);
        return user;
    }
    public List<NhanVienDto> getALlNhanVien(){
        return repo.getAllNhanVien().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
//    public List<NhanVienDto> getByID(String id){
//        return repo.getbyID(id).stream()
//                .map(this::convertEntityToDto)
//                .collect(Collectors.toList());
//    }
//    public void insert( String a,  String b,  boolean c, String hoten,
//                       Date d, String e0, String f,
//                        String g, boolean h, String i) {
//        NhanVienDto dto=new NhanVienDto(e0,hoten,d,a,b,c);
//        TaiKhoanNVDto dto1=new TaiKhoanNVDto(f,g,h,i);
//        NHAN_VIEN e= convertDtoToEntity(dto);
//        TAI_KHOAN_NV e1=convertDtoToEntity1(dto1);
//        repo.insert(e.getCmnd(),e.getEmail(),e.getGioiTinh()
//                ,e.getHoTen(),e.getNgaySinh(),e.getSdt(),e1.getUsername(),e1.getPassword(),e1.getTrangThai(),
//                e1.getQUYEN().getMaQuyen());
//    }



}
