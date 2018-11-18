package com.huawei.pro.utils;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

public class ExcelUtil {

    public static HSSFCellStyle getDefaultHssfHeaderStyle(HSSFWorkbook hwb) {
        HSSFCellStyle hheaderStyle = getDefaultHssfCellStyle(hwb);

        HSSFFont font = getDefaultHssfFont(hwb);

        // 把字体应用到当前的样式
        hheaderStyle.setFont(font);

        // 指定当单元格内容显示不下时自动换行
        hheaderStyle.setWrapText(true);

        return hheaderStyle;
    }

    public static HSSFFont getDefaultHssfFont(HSSFWorkbook hwb) {
        // 生成一个字体
        HSSFFont font = hwb.createFont();
        font.setColor(HSSFColor.BLACK.index);
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        return font;
    }

    public static HSSFCellStyle getDefaultHssfCellStyle(HSSFWorkbook hwb) {
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
        return style;
    }

    public static HSSFCellStyle getDefaultHssfMainStyle(HSSFWorkbook hwb) {
        HSSFCellStyle hmainStyle = hwb.createCellStyle();

        HSSFFont font = getDefaultHssfFont(hwb);

        // 把字体应用到当前的样式
        hmainStyle.setFont(font);

        // 指定当单元格内容显示不下时自动换行
        hmainStyle.setWrapText(true);

        return hmainStyle;
    }
}
