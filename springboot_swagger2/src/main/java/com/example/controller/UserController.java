package com.example.controller;

import com.example.domain.User;
import com.example.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author sgh
 * @date 2019/7/16 20:52
 */
@RestController
@RequestMapping("/api/user")
@Api(value = "用户接口")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "获取用户", notes = "根据id查询用户信息")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Int")
    @GetMapping(value = "/{id}")
    public User get(@PathVariable(name = "id") Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "更新用户", notes = "根据输入的用户信息更新用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Int"),
            @ApiImplicitParam(name = "user", value = "用户详细实体", required = true, dataType = "User")
    })
    @PutMapping(value = "/{id}")
    public String update(@PathVariable(name = "id") Integer id, @RequestBody User user) {
        String message;
        if (!id.equals(user.getId())) {
            message = "更新信息失败";
        } else {
            if (userMapper.updateByPrimaryKeySelective(user) == 1) {
                message = "更新信息成功";
            } else {
                message = "更新信息失败";
            }
        }
        return message;
    }

    @ApiOperation(value = "新增用户", notes = "根据输入的用户信息增加用户")
    @ApiImplicitParam(name = "user", value = "用户信息", required = true, dataType = "User")
    @PostMapping(value = "")
    public String insert(@RequestBody User user) {
        String message;
        if (userMapper.insertSelective(user) == 1) {
            message = "增加用户成功";
        } else {
            message = "增加用户失败";
        }
        return message;
    }

    @ApiOperation(value = "删除用户", notes = "根据id删除用户")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Int")
    @PostMapping(value = "/{id}")
    public String delete(@PathVariable(name = "id") Integer id) {
        String message;
        if (userMapper.deleteByPrimaryKey(id) == 1) {
            message = "删除用户成功";
        } else {
            message = "删除用户失败";
        }
        return message;
    }

}
