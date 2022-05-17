package com.example.demo.service;

import com.example.demo.DTO.KhachHangDto;
import com.example.demo.DTO.NhanVienDto;
import com.example.demo.DTO.TaiKhoan_NhanVien;
import com.example.demo.entity.KHACH_HANG;
import com.example.demo.entity.NHAN_VIEN;
import com.example.demo.repository.NhanVienRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
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


    public List<NhanVienDto> listALL(){
        System.out.println(repo.findAll().size());
    return repo.findAll()
            .stream()
            .map(this::convertEntityToDto)
            .collect(Collectors.toList());
}

    public void save( NhanVienDto dto) {
        NHAN_VIEN ent =convertDtoToEntity(dto);
        repo.save(ent);
    }

    public NhanVienDto findById(String s) {
        Optional<NHAN_VIEN> t = repo.findById(s);
        NhanVienDto z = new NhanVienDto();
        z = convertEntityToDto(t.get());
        Optional<NhanVienDto> x = Optional.of(z);
        return z;
    }

    public void insert(String sdt, String hoten, Date ngaySInh, String cmnd, String email, boolean gioiTinh) {
        NhanVienDto dto=new NhanVienDto( sdt, hoten,  ngaySInh, cmnd, email, gioiTinh);

        NHAN_VIEN e= convertDtoToEntity(dto);
        repo.insert(e.getCmnd(),e.getEmail(),e.getGioiTinh(),e.getHoTen(),e.getNgaySinh(),e.getSdt());
    }

    public <S extends NHAN_VIEN> S save(S entity) {
        return repo.save(entity);
    }
}
