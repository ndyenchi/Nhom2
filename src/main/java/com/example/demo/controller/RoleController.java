package com.example.demo.controller;

import com.example.demo.entity.ROLE;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<ROLE> get() {
        List<ROLE> roleList = roleService.ListAll();
        return roleList;
    }
    // lay thông tin theo mã
    @GetMapping("{maQuyen}")
    public String get1(  @PathVariable int maQuyen) {
        Optional<ROLE> t=roleService.get(maQuyen);
        String a=t.toString();
        return a;
    }
    // chỉnh sửa toàn bộ tên theo mã có sẵn trong database
    @PostMapping("/edit")
    public List<ROLE> postThuongHieu(@RequestBody ROLE role) {
        List<ROLE> List = roleService.ListAll();
        List.add(role);
        roleService.save(role);
        return List;
    }

    //            edit thông tin theo mã
    @PostMapping("/edit/{maQuyen}")
    public void edit1(@PathVariable @RequestBody int maQuyen,
                      @RequestBody String tenQuyen) {
        roleService.editByMa(maQuyen, tenQuyen);
    }
    //   ======================= thêm =======================
    @PostMapping("insert")
    public void insert (@RequestBody ROLE role){
        roleService.insert(role.getMaQuyen(),role.getTenQuyen());
    }
    //======================= delete =================
    @DeleteMapping("delete")
    public void delete (@RequestBody int id){
        roleService.delete(id);
    }
}
