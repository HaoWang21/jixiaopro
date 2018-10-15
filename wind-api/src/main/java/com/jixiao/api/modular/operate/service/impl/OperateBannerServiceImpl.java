package com.jixiao.api.modular.operate.service.impl;

import com.jixiao.api.core.util.scan.RedisUtil;
import com.jixiao.api.core.util.scan.SpringContextUtil;
import com.jixiao.api.modular.operate.service.IOperateBannerService;
import com.jixiao.api.modular.tool.service.IToolDictService;
import com.jixiao.common.JsonResult;
import com.jixiao.common.global.Constant;
import com.jixiao.operate.entity.vo.OperateBannerVO;
import com.jixiao.operate.mapper.IOperateBannerMapper;
import com.jixiao.tool.entity.vo.ToolDictVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiang
 * @since 2018-10-09
 */
@Service
public class OperateBannerServiceImpl implements IOperateBannerService {

    @Autowired
    private IOperateBannerMapper operateBannerMapper;
    @Autowired
    private IToolDictService toolDictService;

    @Override
    public JsonResult list() {
        RedisUtil redis = SpringContextUtil.getBean(RedisUtil.class);
        Object banner = redis.get(Constant.INDEX_BANNER);

        Map<String, Object> map = new HashMap<>(2);
        if (null == banner) {
            List<OperateBannerVO> bannerList = operateBannerMapper.selectVoListByValid(new Date());
            redis.set(Constant.INDEX_BANNER, bannerList);
            map.put("bannerList", bannerList);
        } else {
            map.put("bannerList", banner);
        }

        JsonResult result = toolDictService.list(Constant.INDEX_LABEL);
        map.put("labelList", result.getData());
        return JsonResult.success(map);
    }
}
