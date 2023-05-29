package com.itmy.edo.service.sys.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itmy.edo.dao.mapper.SysRoleMapper;
import com.itmy.edo.model.entity.SysRole;
import com.itmy.edo.service.sys.SysRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
}
