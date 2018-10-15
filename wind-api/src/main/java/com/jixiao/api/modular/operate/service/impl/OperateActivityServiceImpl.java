package com.jixiao.api.modular.operate.service.impl;

import com.jixiao.api.modular.operate.service.IOperateActivityService;
import com.jixiao.operate.mapper.IOperateActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jiang
 * @since 2018-10-09
 */
@Service
public class OperateActivityServiceImpl implements IOperateActivityService {

    @Autowired
    private IOperateActivityMapper operateActivityMapper;

}
