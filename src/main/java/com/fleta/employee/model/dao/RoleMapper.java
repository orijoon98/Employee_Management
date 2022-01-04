package com.fleta.employee.model.dao;

import com.fleta.employee.model.dto.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RoleMapper {
    public void createRole(Role role);
    public void deleteRole(String 사번);
}
