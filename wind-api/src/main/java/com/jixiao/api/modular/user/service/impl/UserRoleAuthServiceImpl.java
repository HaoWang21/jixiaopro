package com.jixiao.api.modular.user.service.impl;

import com.jixiao.api.modular.user.service.IUserRoleAuthService;
import com.jixiao.user.mapper.IUserRoleAuthMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jiang
 * @since 2018-09-28
 */
@Service
public class UserRoleAuthServiceImpl implements IUserRoleAuthService {

    @Autowired
    private IUserRoleAuthMapper userRoleAuthMapper;

}
