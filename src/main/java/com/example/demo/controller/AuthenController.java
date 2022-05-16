package com.example.demo.controller;

import com.example.demo.DTO.*;
import com.example.demo.entity.KHACH_HANG;
import com.example.demo.entity.TAI_KHOAN_KH;
import com.example.demo.entity.TAI_KHOAN_NV;
import com.example.demo.helper.JwtTokenProvider;
import com.example.demo.helper.ResponseHelper;
import com.example.demo.repository.TaiKhoanKHRepository;
import com.example.demo.service.KhachHangService;
import com.example.demo.service.TaiKhoanKHService;
import com.example.demo.service.TaiKhoanNVService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

import java.util.Date;
import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/api/authen/")
public class AuthenController {
    @Autowired
    private TaiKhoanKHService taiKhoanKHService;
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private TaiKhoanNVService taiKhoanNVService;


    @Autowired
    private ModelMapper modelMapper;

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static Random rnd = new Random();

    String randomString(int len){
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public List<TaiKhoanKHDto> listUser(){
        List<TAI_KHOAN_KH> KH = taiKhoanKHService.ListAll();
        List<TaiKhoanKHDto> user = new ArrayList<TaiKhoanKHDto>();
        for(int i =0; i < KH.size(); i++ ){
            TaiKhoanKHDto dto = modelMapper.map(KH.get(i), TaiKhoanKHDto.class);
            user.add(dto);
        }
        return  user;
    }

    public List<TaiKhoanNVDto> listNV(){
        List<TAI_KHOAN_NV> NV = taiKhoanNVService.ListAll1();
        List<TaiKhoanNVDto> TKNV = new ArrayList<TaiKhoanNVDto>();
        for(int i =0; i < NV.size(); i++ ){
            TaiKhoanNVDto dto = modelMapper.map(NV.get(i), TaiKhoanNVDto.class);
            TKNV.add(dto);
        }
        return TKNV;
    }



    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Date DoB = new Date();

    @PostMapping("login")
    public ResponseEntity<Object> Login(@Valid @RequestBody LoginRequest loginRequest){


        System.out.println(randomString(3));

        TaiKhoanKHDto KHData = new TaiKhoanKHDto();
        String username = loginRequest.getUsername();
        for(int i= 0; i < listUser().size(); i++ ) {
            System.out.println("STT." + i + " " + username + " " + listUser().get(i).getUsername());
            for (int j = 0; j < listNV().size(); j++) {
                if (username.compareTo(listUser().get(i).getUsername()) == 0 || username.compareTo(listNV().get(j).getUsername()) == 0) {
                    KHData = listUser().get(i);
                }
            }
        }
        System.out.println(KHData);



        try {
            if(KHData == null){
                return ResponseHelper.GenerateResponse(false, "user doesn't exist", HttpStatus.BAD_REQUEST);
            }
//            Boolean isCorrectPassword = BCrypt.checkpw(loginRequest.getPassword(), KHData.getPassword());
//            if (!isCorrectPassword) {
//                return ResponseHelper.GenerateResponse(false, "user or passsword isn't correct", HttpStatus.BAD_REQUEST);
//            }

            if(loginRequest.getPassword().equals(KHData.getPassword())) {

                HashMap<String, String> claims = new HashMap<String, String>();
                claims.put("username", KHData.getUsername());
                claims.put("password", KHData.getPassword());

                String jwtToken = JwtTokenProvider.GenerateToken(claims);

                LoginResponse response = new LoginResponse();
                response.setToken(jwtToken);

                return ResponseHelper.GenerateResponse(true, "login success", response, HttpStatus.OK);
            }
            return ResponseHelper.GenerateResponse(false, "user or passsword isn't correct", HttpStatus.BAD_REQUEST);

        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return ResponseHelper.GenerateResponse(false, "There are some internal error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }


    @PostMapping("register")
    public ResponseEntity<Object> Register(@Valid @RequestBody RegisterUserRequest request) {

        TaiKhoanKHDto Data = new TaiKhoanKHDto();
        String username = request.getUsername();
        for(int i= 0; i < listUser().size(); i++ ){
            if(username.compareTo(listUser().get(i).getUsername()) == 0 ){
                Data = listUser().get(i);
            }
        }


        try {
            if (Data.getUsername() == null) {
                KHACH_HANG KHNew = new KHACH_HANG();
                TAI_KHOAN_KH tkKH_new = new TAI_KHOAN_KH();

                String maKH = randomString(3);

                KHNew.setHoTen(request.getName());
                KHNew.setDiaChi(request.getAddress());
                KHNew.setEmail(request.getEmail());
                KHNew.setMaKH(maKH);

                khachHangService.insert(request.getName(), request.getAddress(), request.getEmail(), maKH);

//                tkKH_new.setUsername(request.getUsername());
//                tkKH_new.setPassword(request.getPassword());
                taiKhoanKHService.insert(request.getUsername(), request.getPassword(), maKH);

                return ResponseHelper.GenerateResponse(true, "register user successfully", HttpStatus.OK);

            }

            return ResponseHelper.GenerateResponse(false, "user exists", HttpStatus.BAD_REQUEST);


        } catch (Exception ex) {

            return ResponseHelper.GenerateResponse(false, "There are some internal error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
