package com.example.poi.utils;

import com.example.poi.domain.User;
import lombok.Data;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sgh
 * @date 2019/7/14 13:48
 */
@Data
public class ExcelUtil {
    /**
     * 得到excel文件内的用户集合
     *
     * @param mFile 上传的文件
     * @return 用户集合
    */
    public List<User> getExcelInfo(MultipartFile mFile) {
        // 获取文件名
        String fileName = mFile.getOriginalFilename();
        List<User> userList = null;
        try {
            if (!validateExcel(fileName)) {
                return null;
            }
            userList = createExcel(mFile.getInputStream(), fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    /**
     * 判断是不是xls后缀的excel文件
     *
     * @param fileName 文件名
     */
    public static Boolean isXlsExcel(String fileName) {
        return fileName.matches("^.+\\.(?i)(xls)$");
    }

    /**
     * 判断是不是xlsx后缀的excel文件
     *
     * @param fileName 文件名
     */
    public static Boolean isXlsxExcel(String fileName) {
        return fileName.matches("^.+\\.(?i)(xlsx)$");
    }

    /**
     * 验证该文件是否为excel文件
     *
     * @param fileName 文件名
    */
    public Boolean validateExcel(String fileName) {
        Boolean isExcelFile = (fileName != null && (isXlsExcel(fileName) || isXlsxExcel(fileName)));
        return isExcelFile;
    }

    /**
     *
     * @param inputStream excel文件输入流
     * @param fileName 文件名
     * @return 用户集合
    */
    public List<User> createExcel(InputStream inputStream, String fileName) {
        List<User> userList = null;
        try {
            Workbook wb = null;
            // 判断类型，使用不同的Workbook
            if (isXlsExcel(fileName)) {
                wb = new HSSFWorkbook(inputStream);
            } else {
                wb = new XSSFWorkbook(inputStream);
            }
            userList = readExcelValue(wb);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    /**
     *
     * @param wb 工作薄
     * @return 用户集合
    */
    public List<User> readExcelValue(Workbook wb) {
        List<User> userList = new ArrayList<>();
        // 总行数 总列数
        int totalRows, totalCells = 0;
        // 先得到一个sheet
        Sheet sheet = wb.getSheetAt(0);
        // 得到行数
        totalRows = sheet.getPhysicalNumberOfRows();
        // 得到excel里面的列，前提是有行
        // 大于1是因为我从第二行就是数据了，这个大家看情况而定
        if (totalRows > 1 && sheet.getRow(0) != null) {
            totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }
        for (int i = 1; i < totalRows; i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
                continue;//如果行为空的话直接中断
            }
            User user = new User();
            for (int j = 0; j < totalCells; j++) {
                Cell cell = row.getCell(j);
                if (cell != null) {
                    if (j == 0) {
                        // 取姓名
                        user.setName(cell.getStringCellValue());
                    } else if (j == 1) {
                        // 取年龄，先转化为String类型
                        cell.setCellType(CellType.STRING);
                        user.setAge(Byte.parseByte(cell.getStringCellValue()));
                    } else if (j == 2) {
                        // 取地址
                        user.setAddr(cell.getStringCellValue());
                    }
                }
            }
            userList.add(user);
        }
        return userList;
    }
}
