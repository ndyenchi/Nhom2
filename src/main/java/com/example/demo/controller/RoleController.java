package com.example.demo.controller;

import com.example.demo.DTO.RoleDto;
import com.example.demo.entity.ROLE;
import com.example.demo.helper.ResponseHelper;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/role/")
public class RoleController {
    @Autowired
    RoleService roleService;

    //lay toàn bộ thông tin
    @GetMapping("get")
    public List<RoleDto> get() {
        List<RoleDto> roleList = roleService.ListAll();
        return roleList;
    }
    // lay thông tin theo mã
    @GetMapping("{maQuyen}")
    public RoleDto get1(  @PathVariable String maQuyen) {
        return roleService.findByID(maQuyen);
    }
    // chỉnh sửa toàn bộ tên theo mã có sẵn trong database
    @PostMapping("/edit")
    public List<RoleDto> postThuongHieu(@RequestBody RoleDto role) {
        List<RoleDto> List = roleService.ListAll();
        List.add(role);
        roleService.save(role);
        return List;
    }

    //            edit thông tin theo mã
    @PatchMapping("/edit/{maQuyen}")
    public ResponseEntity edit1(@PathVariable String maQuyen,
                      @RequestBody RoleDto quyen) {
        quyen.setMaQuyen(maQuyen);
        roleService.save(quyen);
        return ResponseHelper.GenerateResponse(true, "Edit role success", HttpStatus.OK);

    }
    //   ======================= thêm =======================
    @PostMapping("insert")
    public ResponseEntity insert (@RequestBody ROLE role){
        roleService.insert(role.getMaQuyen(),role.getTenQuyen());
        return ResponseHelper.GenerateResponse(true, "Create role success", HttpStatus.OK);

    }
    //======================= delete =================
    @DeleteMapping("delete/{id}")
    public ResponseEntity delete (@PathVariable String id){
        roleService.delete(id);
        return ResponseHelper.GenerateResponse(true, "Delete role success", HttpStatus.OK);

    }
}
