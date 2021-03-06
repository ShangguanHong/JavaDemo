package com.example.poi.service.impl;

import com.example.poi.domain.User;
import com.example.poi.mapper.UserMapper;
import com.example.poi.service.ExcelService;
import com.example.poi.utils.ExcelUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sgh
 * @date 2019/7/14 14:38
 */
@Service
public class ExcelServiceImpl implements ExcelService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Boolean readExcelFile(MultipartFile file) {
        boolean result;
        ExcelUtil excel = new ExcelUtil();
        List<User> userList = excel.getExcelInfo(file);
        if (userList != null && !userList.isEmpty()) {
            //不为空的话添加到数据库
            for (User user : userList) {
                userMapper.insert(user);
            }
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
