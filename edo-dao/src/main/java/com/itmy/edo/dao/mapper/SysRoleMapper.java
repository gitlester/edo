package com.itmy.edo.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.itmy.edo.model.entity.SysRole;
import com.itmy.edo.model.param.SysRoleParam;
import com.itmy.edo.model.vo.SysRoleVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Role Table Mapper 接口
 * </p>
 *
 * @author leo
 * @since 2022-10-17
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    SysRole selectSysRole(@Param("userId") int userId);

    IPage<SysRoleVO> listByPage(IPage page, @Param("query") SysRoleParam query);

}
