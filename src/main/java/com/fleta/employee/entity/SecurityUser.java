package com.fleta.employee.entity;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class SecurityUser extends User {
    public SecurityUser(com.fleta.employee.entity.User user) {
        super(user.getLoginId(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getAuthority().toString()));
    }
}
