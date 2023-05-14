package com.itmy.edo.web.controller.sys;

import com.itmy.edo.model.entity.SysRole;
import com.itmy.edo.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    @Resource
    private SysRoleService sysRoleService;

    @GetMapping("/findAll")
    public List<SysRole> findAll() {
        List<SysRole> roleList = sysRoleService.list();
        return roleList;
    }

    @DeleteMapping("remove/{id}")
    public Boolean del(@PathVariable("id") Long id){
        return sysRoleService.removeById(id);
    }
}
