package com.huawei.pro.bean;

import com.huawei.pro.utils.ExcelUtil;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Component;

import java.io.OutputStream;
import java.util.List;

@Component
public class ExcelTmp {

    private ExcelTmp excel;

    private HSSFWorkbook hwb;

    private XSSFWorkbook xwb;

    private int columnWidth = 20;

    //sheet名称
    private String sheetTitle;

    //标题栏
    private String[] headers;

    //设置表格数据
    private List<List<String>> result;

    //设置sheet位置
    private int sheetNum = 0;

    //标题栏表格风格
    private HSSFCellStyle hheaderStyle;

    //正文栏表格风格
    private HSSFCellStyle hmainStyle;

    private OutputStream out;

    public String getSheetTitle() {
        return sheetTitle;
    }

    public void setSheetTitle(String sheetTitle) {
        this.sheetTitle = sheetTitle;
    }

    public String[] getHeaders() {
        return headers;
    }

    public void setHeaders(String[] headers) {
        this.headers = headers;
    }

    public List<List<String>> getResult() {
        return result;
    }

    public void setResult(List<List<String>> result) {
        this.result = result;
    }

    public int getSheetNum() {
        return sheetNum;
    }

    public void setSheetNum(int sheetNum) {
        this.sheetNum = sheetNum;
    }

    public HSSFCellStyle getHheaderStyle() {
        return hheaderStyle;
    }

    public void setHheaderStyle(HSSFCellStyle hheaderStyle) {
        this.hheaderStyle = hheaderStyle;
    }

    public HSSFCellStyle getHmainStyle() {
        return hmainStyle;
    }

    public void setHmainStyle(HSSFCellStyle hmainStyle) {
        this.hmainStyle = hmainStyle;
    }

    public OutputStream getOut() {
        return out;
    }

    public void setOut(OutputStream out) {
        this.out = out;
    }

    public ExcelTmp() {
    }

    public ExcelTmp(HSSFWorkbook wb, int sheetNum, String sheetTitle, String[] headers,
                    List<List<String>> result, OutputStream out) {
        this.hwb = wb;
        this.sheetTitle = sheetTitle;
        this.headers = headers;
        this.result = result;
        this.sheetNum = sheetNum;
        this.out = out;

        exportExcel(hwb);
    }

    //TODO 重构代码
    private void exportExcel(XSSFWorkbook xwb) {

        // 生成一个表格
        XSSFSheet sheet = xwb.createSheet();
        xwb.setSheetName(sheetNum, sheetTitle);
        // 设置表格默认列宽度为20个字节
        sheet.setDefaultColumnWidth(20);
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

        // 产生表格标题行
        XSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            XSSFCell cell = row.createCell(i);

            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text.toString());
        }
        // 遍历集合数据，产生数据行
        if (result != null) {
            int index = 1;
            for (List<String> m : result) {
                row = sheet.createRow(index);
                int cellIndex = 0;
                for (String str : m) {
                    XSSFCell cell = row.createCell(cellIndex);
                    cell.setCellValue(str);
                    cellIndex++;
                }
                index++;
            }
        }
    }

    private void exportExcel(HSSFWorkbook hwb) {

        // 生成一个表格
        HSSFSheet sheet = hwb.createSheet();
        hwb.setSheetName(sheetNum, sheetTitle);
        // 设置表格默认列宽度为20个字节
        sheet.setDefaultColumnWidth(columnWidth);


        if (hheaderStyle == null) {
            hheaderStyle = ExcelUtil.getDefaultHssfHeaderStyle(hwb);
        }
        // 产生表格标题行
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);

            cell.setCellStyle(hheaderStyle);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text.toString());
        }

        if (hmainStyle == null) {
            hmainStyle = ExcelUtil.getDefaultHssfMainStyle(hwb);
        }

        // 遍历集合数据，产生数据行
        if (result != null) {
            int index = 1;
            for (List<String> m : result) {
                row = sheet.createRow(index);
                int cellIndex = 0;
                for (String str : m) {
                    HSSFCell cell = row.createCell(cellIndex);
                    cell.setCellStyle(hmainStyle);
                    cell.setCellValue(str);
                    cellIndex++;
                }
                index++;
            }
        }
    }


}
