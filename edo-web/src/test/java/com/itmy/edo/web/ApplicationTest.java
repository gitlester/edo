package com.itmy.edo.web;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.google.gson.Gson;
import com.itmy.edo.dao.mapper.SysRoleMapper;
import com.itmy.edo.model.entity.SysRole;
import com.itmy.edo.service.SysRoleService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest
@ContextConfiguration
public class ApplicationTest {

//    @Autowired
//    PasswordEncoder passwordEncoder;

    @Resource
    private Gson gson;

    @Test
    @Disabled
    public void test1() {
        //System.out.println(new BCryptPasswordEncoder().encode("123456"));
        //对比明文和密文是否匹配，若匹配则为True
//        System.out.println(new BCryptPasswordEncoder().matches("123456","$10$qMgrmYzLzCu1/rqVa2iwZugp98abgbBfNNdOPzxR9.62b9fLfk.bW"));
    }

    @Test
    @Disabled
    public void test2() {
        //System.out.println(passwordEncoder.encode("123456"));
//        System.out.println(new BCryptPasswordEncoder().encode("123456"));
        //对比明文和密文是否匹配，若匹配则为True
//        System.out.println(new BCryptPasswordEncoder().matches("123456","$10$qMgrmYzLzCu1/rqVa2iwZugp98abgbBfNNdOPzxR9.62b9fLfk.bW"));
    }

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Test
    public void testSelectList() {
        System.out.println(("----- selectAll method test ------"));
        //UserMapper 中的 selectList() 方法的参数为 MP 内置的条件封装器 Wrapper
        //所以不填写就是无任何条件
        List<SysRole> sysRoles = sysRoleMapper.selectList(null);
        for (SysRole sysRole : sysRoles) {
            System.out.println("sysRole = " + sysRole);
        }
    }
    @Test
    public void testInsert(){
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("角色管理员1");
        sysRole.setRoleCode("roleManager");
        sysRole.setDescription("角色管理员1");
        sysRole.setCreateTime((new Date()));
        int result = sysRoleMapper.insert(sysRole);
        System.out.println(result); //影响的行数
        System.out.println(sysRole.getId()); //id自动回填
    }

    @Test
    public void testUpdateById(){
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysRole::getId,36);
        SysRole sysRole = sysRoleMapper.selectOne(wrapper);
        System.out.println(sysRole);
        sysRole.setRoleName("角色管理员12");
        sysRole.setDescription("角色管理员12");
        sysRole.setIsDeleted(1);
        sysRole.setUpdateTime(new Date());
        int result = sysRoleMapper.updateById(sysRole);
        System.out.println(result);

    }

    /**
     * application-dev.yml 加入配置
     * 此为默认值，如果你的默认值和默认的一样，则不需要该配置
     * mybatis-plus:
     *   global-config:
     *     db-config:
     *       logic-delete-value: 1
     *       logic-not-delete-value: 0
     */
    @Test
    public void testDeleteById(){
        int result = sysRoleMapper.deleteById(1657734450286505985L);
        System.out.println(result);
    }

    @Test
    public void testDeleteBatchIds() {
        int result = sysRoleMapper.deleteBatchIds(Arrays.asList(1, 2));
        System.out.println(result);
    }

    @Test
    public void testQueryWrapper() {
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("role_code", "role");
        List<SysRole> users = sysRoleMapper.selectList(queryWrapper);
        List<SysRole> role = sysRoleMapper.selectList(new LambdaQueryWrapper<SysRole>().eq(SysRole::getRoleCode,
                "role"));

        System.out.println(users);
        /**
         * 1、关于 Mybatis plus 的使用，在使用条件构造器的时候，完全可以用 LambdaQueryWrapper 条件构造器，这样可以不用写死数据库中的字段名，减少后续字段名发生改动后，影响较大
         * 2、关于 controller 中，使用swagger的时候，controller暴露的参数 建议用 vo 封装，前端需要什么后端就给他封装什么，不用把整个实体类都放在参数中，比如 sysUser 实体类中就有很多属性是后台生成的，那么在前端人员使用 swagger测试的时候，那么多字段不友好
         * 3、关于前端，前端中使用了 vue-admin-template 框架，我更加期待的是，能稍微讲解一下，而不是跟着改，因为后续万一我们要基于vue-admin-template来加内容，难度大
         * 4、命名需统一，比如在 controller层 查询就 find  在 mapper 或者 service 层 查询就用 select，养成统一命名对后续规范化开发有很大的帮助
         *
         * 总体来说：还是值得学习的，向尚硅谷学院点赞
         */
    }

    @Autowired
    private SysRoleService sysRoleService;

    @Test
    public void testServiceSelectList() {
        System.out.println(("----- selectAll method test ------"));
        //UserMapper 中的 selectList() 方法的参数为 MP 内置的条件封装器 Wrapper
        //所以不填写就是无任何条件
        List<SysRole> roles = sysRoleService.list();
        for (SysRole role : roles) {
            System.out.println("role = " + role);
        }
    }

    @Test
    public void testServiceInsert(){
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("角色管理员");
        sysRole.setRoleCode("role");
        sysRole.setDescription("角色管理员");

        boolean result = sysRoleService.save(sysRole);
        System.out.println(result); //成功还是失败
    }

    @Test
    public void testServiceUpdateById(){
        SysRole sysRole = new SysRole();
        sysRole.setId(String.valueOf(1L));
        sysRole.setRoleName("角色管理员1");

        boolean result = sysRoleService.updateById(sysRole);
        System.out.println(result);

    }

    @Test
    public void testServiceDeleteById(){
        boolean result = sysRoleService.removeById(2L);
        System.out.println(result);
    }

    @Test
    public void testServiceQueryWrapper() {
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("role_code", "role");
        List<SysRole> users = sysRoleService.list(queryWrapper);
        System.out.println(users);
    }


}
