package com.fleta.employee.model.dao;

import com.fleta.employee.model.dto.Bank;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BankMapper {
    public void createBank(Bank bank);
    public void deleteBank(String 사번);
}
