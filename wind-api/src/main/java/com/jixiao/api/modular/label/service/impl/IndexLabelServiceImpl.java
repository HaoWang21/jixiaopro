package com.jixiao.api.modular.label.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jixiao.api.modular.label.service.IIndexLabelService;
import com.jixiao.common.JsonResult;
import com.jixiao.common.global.Constant;
import com.jixiao.common.util.DateUtil;
import com.jixiao.common.util.StringUtil;
import com.jixiao.tool.entity.ToolDict;
import com.jixiao.tool.mapper.IToolDictMapper;
import com.jixiao.user.entity.vo.UserDynamicFollowVO;
import com.jixiao.user.entity.vo.UserDynamicHotVO;
import com.jixiao.user.entity.vo.UserFollowVO;
import com.jixiao.user.mapper.IUserDynamicMapper;
import com.jixiao.user.mapper.IUserFollowMapper;
import com.jixiao.user.mapper.IUserUploadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiang
 * @since 2018-10-09
 */
@Service
public class IndexLabelServiceImpl implements IIndexLabelService {

    @Autowired
    private IUserDynamicMapper userDynamicMapper;
    @Autowired
    private IToolDictMapper toolDictMapper;
    @Autowired
    private IUserFollowMapper userFollowMapper;
    @Autowired
    private IUserUploadMapper userUploadMapper;

    @Override
    public JsonResult hot(Long current, Long size, String labelValue, Long userId) {
        Long typeId = null;
        if (StringUtil.isNotBlank(labelValue)) {
            ToolDict toolDict = toolDictMapper.selectByValueAndParentValue(labelValue, Constant.INDEX_LABEL);
            if (null != toolDict) {
                typeId = toolDict.getId();
            }
        }
        IPage<UserDynamicHotVO> page = userDynamicMapper.selectVoListIsHotByUserId(new Page<>(current, size), typeId, userId);
        List<UserDynamicHotVO> list = page.getRecords();
        for (UserDynamicHotVO vo : list) {
            if (StringUtil.isNotBlank(vo.getContent())) {
                vo.setContent(StringUtil.abbr(StringUtil.decodeBase64(vo.getContent()), 20));
            }
            vo.setNickName(StringUtil.decodeBase64(vo.getNickName()));
        }
        page.setRecords(list);
        return JsonResult.success(page);
    }

    @Override
    public JsonResult follow(Long current, Long size, Long followUserId, Long userId) {
        List<UserFollowVO> followUserList = userFollowMapper.selectListByUserId(userId);
        for(UserFollowVO vo : followUserList) {
            vo.setNickName(StringUtil.decodeBase64(vo.getNickName()));
        }
        IPage<UserDynamicFollowVO> page = userDynamicMapper.selectVoListIsFollowByUserId(new Page<>(current, size), followUserId, userId);
        List<UserDynamicFollowVO> list = page.getRecords();
        for (UserDynamicFollowVO vo : list) {
            vo.setUrlList(userUploadMapper.selectStringListByUserDynamicId(vo.getId()));
            if (StringUtil.isNotBlank(vo.getContent())) {
                vo.setContent(StringUtil.abbr(StringUtil.decodeBase64(vo.getContent()), 20));
            }
            vo.setNickName(StringUtil.decodeBase64(vo.getNickName()));
            vo.setGmtCreate(DateUtil.formatDate(vo.getGmtCreate()));
        }
        page.setRecords(list);

        Map<String, Object> map = new HashMap<>(2);
        map.put("followList", followUserList);
        map.put("dynamicList", list);
        return JsonResult.success(map);
    }

    @Override
    public JsonResult nearby(Long current, Long size, BigDecimal lng, BigDecimal lat, Integer distance, Long userId) {
        List<UserDynamicHotVO> list = userDynamicMapper.selectVoListIsNearbyByUserId(current, size, lng, lat, distance, userId);
        for (UserDynamicHotVO vo : list) {
            if (StringUtil.isNotBlank(vo.getContent())) {
                vo.setContent(StringUtil.abbr(StringUtil.decodeBase64(vo.getContent()), 20));
            }
            vo.setNickName(StringUtil.decodeBase64(vo.getNickName()));
        }
        return JsonResult.success(list);
    }
}
