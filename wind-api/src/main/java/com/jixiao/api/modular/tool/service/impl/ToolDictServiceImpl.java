package com.jixiao.api.modular.tool.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jixiao.api.core.util.scan.RedisUtil;
import com.jixiao.api.core.util.scan.SpringContextUtil;
import com.jixiao.api.modular.tool.service.IToolDictService;
import com.jixiao.common.ErrorCode;
import com.jixiao.common.JsonResult;
import com.jixiao.common.global.Constant;
import com.jixiao.tool.entity.vo.ToolDictVO;
import com.jixiao.tool.mapper.IToolDictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jiang
 * @since 2018-09-28
 */
@Service
public class ToolDictServiceImpl implements IToolDictService {

    @Autowired
    private IToolDictMapper toolDictMapper;

    @Override
    public JSONObject selectDefaultConfig() {
        RedisUtil redis = SpringContextUtil.getBean(RedisUtil.class);
        Object config = redis.get(Constant.API_CONFIG);
        if (null == config) {
            List<ToolDictVO> list = toolDictMapper.selectListByParentValue(Constant.API_CONFIG);

            JSONObject json = new JSONObject();
            for (ToolDictVO vo : list) {
                json.put(vo.getLabel(), vo.getValue());
            }

            redis.set(Constant.API_CONFIG, json);
            return json;
        }
        return (JSONObject) config;
    }

    @Override
    public <T> T selectDefaultConfigByKey(String key, Class<T> clazz) {
        return clazz.cast(selectDefaultConfig().get(key));
    }

    @Override
    public JsonResult list(String labelKey) {
        RedisUtil redis = SpringContextUtil.getBean(RedisUtil.class);
        Object label = redis.get(labelKey);
        if (null == label) {
            List<ToolDictVO> list = toolDictMapper.selectListByParentValue(labelKey);
            redis.set(labelKey, list);
            return JsonResult.success(list);
        }
        return JsonResult.success(label);
    }
}
