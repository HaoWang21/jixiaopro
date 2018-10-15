package com.jixiao.api.modular.tool.controller;

import com.jixiao.api.modular.tool.service.IToolDistrictService;
import com.jixiao.common.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiang
 * @since 2018-09-28
 */
@RestController
@RequestMapping("/toolDistrict")
public class ToolDistrictController extends BaseController {

    @Autowired
    private IToolDistrictService toolDistrictService;

}
