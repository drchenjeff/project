package com.huawei.pro.utils;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

    public static HSSFCellStyle getMainHssfStyle(HSSFWorkbook hwb) {

        HSSFFont headFont = hwb.createFont();
        headFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headFont.setFontName("宋体");
        headFont.setFontHeightInPoints((short) 11);
        HSSFCellStyle headStyle = hwb.createCellStyle();
        headStyle.setFont(headFont);
        headStyle.setBorderTop((short) 1);
        headStyle.setBorderRight((short) 1);
        headStyle.setBorderBottom((short) 1);
        headStyle.setBorderLeft((short) 1);
        headStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        return headStyle;
    }

    public static HSSFCellStyle getHeaderHssfStyle(HSSFWorkbook hwb) {

        // 生成一个样式
        HSSFCellStyle style = hwb.createCellStyle();
        // 设置这些样式
        style.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        // 生成一个字体
        HSSFFont font = hwb.createFont();
        font.setColor(HSSFColor.BLACK.index);
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        // 把字体应用到当前的样式
        style.setFont(font);

        // 指定当单元格内容显示不下时自动换行
        style.setWrapText(true);

        return style;
    }

    public static XSSFCellStyle getMainXssfCellStyle(XSSFWorkbook xwb) {

        XSSFFont headFont = xwb.createFont();
        headFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headFont.setFontName("宋体");
        headFont.setFontHeightInPoints((short) 11);
        XSSFCellStyle headStyle = xwb.createCellStyle();
        headStyle.setFont(headFont);
        headStyle.setBorderTop((short) 1);
        headStyle.setBorderRight((short) 1);
        headStyle.setBorderBottom((short) 1);
        headStyle.setBorderLeft((short) 1);
        headStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        return headStyle;
    }

    public static XSSFCellStyle getHeaderXssfCellStyle(XSSFWorkbook xwb) {

        // 生成一个样式
        XSSFCellStyle style = xwb.createCellStyle();
        // 设置这些样式
        style.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 生成一个字体
        XSSFFont font = xwb.createFont();
        font.setColor(HSSFColor.BLACK.index);
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        style.setFont(font);

        // 指定当单元格内容显示不下时自动换行
        style.setWrapText(true);
        return style;

    }
}
