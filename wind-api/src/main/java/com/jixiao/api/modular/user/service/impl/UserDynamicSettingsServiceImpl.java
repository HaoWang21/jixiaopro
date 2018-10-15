package com.jixiao.api.modular.user.service.impl;

import com.jixiao.api.modular.user.service.IUserDynamicSettingsService;
import com.jixiao.user.mapper.IUserDynamicSettingsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jiang
 * @since 2018-10-08
 */
@Service
public class UserDynamicSettingsServiceImpl implements IUserDynamicSettingsService {

    @Autowired
    private IUserDynamicSettingsMapper userDynamicSettingsMapper;

}
