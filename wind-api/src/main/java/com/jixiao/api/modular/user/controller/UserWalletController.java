package com.jixiao.api.modular.user.controller;

import com.jixiao.api.modular.user.service.IUserWalletService;
import com.jixiao.common.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiang
 * @since 2018-09-28
 */
@RestController
@RequestMapping("/userWallet")
public class UserWalletController extends BaseController {

    @Autowired
    private IUserWalletService userWalletService;

}
