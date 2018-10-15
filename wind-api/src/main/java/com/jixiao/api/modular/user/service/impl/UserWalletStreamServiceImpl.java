package com.jixiao.api.modular.user.service.impl;

import com.jixiao.api.modular.user.service.IUserWalletStreamService;
import com.jixiao.common.JsonResult;
import com.jixiao.user.mapper.IUserWalletStreamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jiang
 * @since 2018-09-28
 */
@Service
public class UserWalletStreamServiceImpl implements IUserWalletStreamService {

    @Autowired
    private IUserWalletStreamMapper userWalletStreamMapper;

}
