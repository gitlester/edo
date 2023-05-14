package com.itmy.edo.model.param;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author leo
 * @since 2023-05-14
 */
@Data
public class SysRoleParam {

    private Integer id;

    private Integer page;

    private Integer pageSize;

    private String roleName;

    private LocalDateTime createAt;

    private Integer createBy;

    private Integer updateBy;

    private Integer status;

    private LocalDateTime updateAt;

    private String description;

    private Integer isDeleted;

    private List<Integer> menu;

    private Boolean isAdmin;

    private Integer userId;
}
