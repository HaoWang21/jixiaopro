package com.jixiao.api.modular.operate.controller;

import com.jixiao.api.modular.operate.service.IOperateActivityService;
import com.jixiao.common.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiang
 * @since 2018-10-09
 */
@RestController
@RequestMapping("/operateActivity")
public class OperateActivityController extends BaseController {

    @Autowired
    private IOperateActivityService operateActivityService;

}
