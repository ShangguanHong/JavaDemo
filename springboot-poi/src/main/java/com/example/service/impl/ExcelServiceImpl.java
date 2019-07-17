package com.example.service.impl;

import com.example.domain.User;
import com.example.mapper.UserMapper;
import com.example.service.ExcelService;
import com.example.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author sgh
 * @date 2019/7/14 14:38
 */
@Service
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean readExcelFile(MultipartFile file) {
        Boolean result;
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
