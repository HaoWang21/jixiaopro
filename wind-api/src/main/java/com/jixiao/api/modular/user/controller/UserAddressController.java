package com.jixiao.api.modular.user.controller;

import com.jixiao.api.core.annotation.RequireUser;
import com.jixiao.api.modular.user.service.IUserAddressService;
import com.jixiao.common.JsonResult;
import com.jixiao.common.base.BaseController;
import com.jixiao.user.entity.dto.UserAddressUpdateDTO;
import com.jixiao.user.entity.vo.UserAddressVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jiang
 * @since 2018-10-01
 */
@Api(tags = "用户地址", description = "UserAddressController")
@RestController
@RequireUser
@RequestMapping("/userAddress")
public class UserAddressController extends BaseController {

    @Autowired
    private IUserAddressService userAddressService;

    @ApiOperation(value = "列表(user)", notes = "查询列表")
    @GetMapping("/list")
    public JsonResult<List<UserAddressVO>> list() {
        return userAddressService.list(getUserId());
    }

    @ApiOperation(value = "添加(user)", notes = "添加记录")
    @PostMapping
    public JsonResult save(UserAddressUpdateDTO dto) {
        return userAddressService.save(dto, getUserId());
    }

    @ApiOperation(value = "删除(user)", notes = "删除记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "地址Id", required = true, dataType = "long", paramType = "query")
    })
    @DeleteMapping
    public JsonResult remove(Long id) {
        return userAddressService.remove(id, getUserId());
    }

    @ApiOperation(value = "修改(user)", notes = "修改记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "地址Id", required = true, dataType = "long", paramType = "query")
    })
    @PutMapping
    public JsonResult update(Long id, UserAddressUpdateDTO dto) {
        return userAddressService.update(id, dto, getUserId());
    }

    @ApiOperation(value = "详情(user)", notes = "查询详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "地址Id", required = true, dataType = "long", paramType = "query")
    })
    @GetMapping
    public JsonResult details(Long id) {
        return userAddressService.details(id, getUserId());
    }
}
