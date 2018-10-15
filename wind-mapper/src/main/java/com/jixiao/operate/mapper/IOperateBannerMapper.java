package com.jixiao.operate.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jixiao.operate.entity.OperateBanner;
import com.jixiao.operate.entity.vo.OperateBannerVO;

import java.util.Date;
import java.util.List;

/**
 * @author jiang
 * @since 2018-10-09
 */
public interface IOperateBannerMapper extends BaseMapper<OperateBanner> {

    /**
     * 有效的轮播
     *
     * @param date 当前时间
     * @return list
     */
    List<OperateBannerVO> selectVoListByValid(Date date);

}
