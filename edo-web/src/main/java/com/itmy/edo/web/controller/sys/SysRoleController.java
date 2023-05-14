package com.itmy.edo.web.controller.sys;

import com.itmy.edo.model.entity.SysRole;
import com.itmy.edo.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "角色管理")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    @Resource
    private SysRoleService sysRoleService;

    @ApiOperation(value = "获取全部角色列表")
    @GetMapping("/findAll")
    public List<SysRole> findAll() {
        List<SysRole> roleList = sysRoleService.list();
        return roleList;
    }

    @ApiOperation(value = "逻辑删除角色")
    @DeleteMapping("remove/{id}")
    public Boolean del(@PathVariable("id") Long id){
        return sysRoleService.removeById(id);
    }
}
