package com.jixiao.api.modular.tool.service.impl;

import com.jixiao.api.modular.tool.service.IToolDistrictService;
import com.jixiao.tool.mapper.IToolDistrictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jiang
 * @since 2018-09-28
 */
@Service
public class ToolDistrictServiceImpl implements IToolDistrictService {

    @Autowired
    private IToolDistrictMapper toolDistrictMapper;

}
