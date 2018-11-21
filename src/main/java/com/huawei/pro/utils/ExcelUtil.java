package com.huawei.pro.utils;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

    public static HSSFCellStyle getMainHssfStyle(HSSFWorkbook hwb) {

        HSSFFont headFont = hwb.createFont();
        headFont.setBold(true);
        headFont.setFontName("宋体");
        headFont.setFontHeightInPoints((short) 11);
        HSSFCellStyle headStyle = hwb.createCellStyle();
        headStyle.setFont(headFont);
        headStyle.setBorderTop(BorderStyle.THIN);
        headStyle.setBorderRight(BorderStyle.THIN);
        headStyle.setBorderBottom(BorderStyle.THIN);
        headStyle.setBorderLeft(BorderStyle.THIN);
        headStyle.setAlignment(HorizontalAlignment.CENTER);

        return headStyle;
    }

    public static HSSFCellStyle getHeaderHssfStyle(HSSFWorkbook hwb) {

        // 生成一个样式
        HSSFCellStyle style = hwb.createCellStyle();
        // 设置这些样式
//        style.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
        style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.PALE_BLUE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setAlignment(HorizontalAlignment.CENTER);

        // 生成一个字体
        HSSFFont font = hwb.createFont();
        font.setColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        font.setFontHeightInPoints((short) 12);
        font.setBold(true);

        // 把字体应用到当前的样式
        style.setFont(font);

        // 指定当单元格内容显示不下时自动换行
        style.setWrapText(true);

        return style;
    }

    public static XSSFCellStyle getMainXssfCellStyle(XSSFWorkbook xwb) {

        XSSFFont headFont = xwb.createFont();
        headFont.setBold(true);
        headFont.setFontName("宋体");
        headFont.setFontHeightInPoints((short) 11);
        XSSFCellStyle headStyle = xwb.createCellStyle();
        headStyle.setFont(headFont);
        headStyle.setBorderTop(BorderStyle.THIN);
        headStyle.setBorderRight(BorderStyle.THIN);
        headStyle.setBorderBottom(BorderStyle.THIN);
        headStyle.setBorderLeft(BorderStyle.THIN);
        headStyle.setAlignment(HorizontalAlignment.CENTER);

        return headStyle;
    }

    public static XSSFCellStyle getHeaderXssfCellStyle(XSSFWorkbook xwb) {

        // 生成一个样式
        XSSFCellStyle style = xwb.createCellStyle();
        // 设置这些样式
        style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.PALE_BLUE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setAlignment(HorizontalAlignment.CENTER);
        // 生成一个字体
        XSSFFont font = xwb.createFont();
        font.setColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        font.setFontHeightInPoints((short) 12);
        font.setBold(true);

        // 把字体应用到当前的样式
        style.setFont(font);

        // 指定当单元格内容显示不下时自动换行
        style.setWrapText(true);
        return style;

    }
}
