package com.jixiao.tool.mapper;

import com.jixiao.tool.entity.ToolDict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jixiao.tool.entity.vo.ToolDictVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jiang
 * @since 2018-09-28
 */
public interface IToolDictMapper extends BaseMapper<ToolDict> {

    /**
     * 查询字典分类
     *
     * @param value 值
     * @return list
     */
    List<ToolDictVO> selectListByParentValue(String value);

    /**
     * 根据value查询记录
     *
     * @param value 标签值
     * @param parentValue 上级标签值
     * @return toolDict
     */
    ToolDict selectByValueAndParentValue(@Param("value") String value, @Param("parentValue") String parentValue);
}
