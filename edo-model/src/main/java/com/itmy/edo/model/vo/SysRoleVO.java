package com.itmy.edo.model.vo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author leo
 * @since 2023-05-14 17:58:31
 */
@Data
public class SysRoleVO {

    private Integer id;

    private String roleName;

    private LocalDateTime createAt;

    private Integer createBy;

    private Integer updateBy;

    private LocalDateTime updateAt;

    private String description;

    private Integer isDeleted;

    private Integer status;

    private List<Integer> menu;
}
