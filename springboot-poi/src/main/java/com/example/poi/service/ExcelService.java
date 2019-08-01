package com.example.poi.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author sgh
 * @date 2019/7/14 14:35
 */
public interface ExcelService {

    /**
     * 读取excel文件
     *
     * @param file excel文件
     * @return java.lang.Boolean 读取是否成功
    */
    Boolean readExcelFile(MultipartFile file);
}
