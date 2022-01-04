package com.fleta.employee.model.dao;

import com.fleta.employee.model.dto.Auth;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AuthMapper {
    public void createAuth(Auth auth);
    public void deleteAuth(String 사번);
}
