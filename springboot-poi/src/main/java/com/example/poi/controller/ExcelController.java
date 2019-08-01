package com.example.poi.controller;

import com.example.poi.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sgh
 * @date 2019/7/14 14:43
 */
@Controller
@RequestMapping("/excel")
public class ExcelController {
    @Autowired
    private ExcelService excelService;


    @RequestMapping("/in")
    public String toExcel() {
        return "uploadexcelfile";
    }

    /**
     * 文件上传的方法
     *
     * @param file
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        Boolean result = excelService.readExcelFile(file);
        String message;
        if (result) {
            message = "读取excel文件成功";
        } else {
            message = "读取excel文件失败";
        }
        return message;
    }
}
