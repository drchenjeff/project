package com.huawei.pro.bean;

import com.huawei.pro.utils.ExcelUtil;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Component;

import java.io.OutputStream;
import java.util.List;

@Component
public class ExcelTmp {

    private HSSFWorkbook hwb;
    private XSSFWorkbook xwb;

    //设置表格列宽
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
    private XSSFCellStyle xheaderStyle;

    //正文栏表格风格
    private HSSFCellStyle hmainStyle;
    private XSSFCellStyle xmainStyle;

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

    public HSSFWorkbook getHwb() {
        return hwb;
    }

    public void setHwb(HSSFWorkbook hwb) {
        this.hwb = hwb;
    }

    public XSSFWorkbook getXwb() {
        return xwb;
    }

    public void setXwb(XSSFWorkbook xwb) {
        this.xwb = xwb;
    }

    public int getColumnWidth() {
        return columnWidth;
    }

    public void setColumnWidth(int columnWidth) {
        this.columnWidth = columnWidth;
    }

    public void setXheaderStyle(XSSFCellStyle xheaderStyle) {
        this.xheaderStyle = xheaderStyle;
    }

    public XSSFCellStyle getXheaderStyle() {
        return xheaderStyle;
    }

    public XSSFCellStyle getXmainStyle() {
        return xmainStyle;
    }

    public void setXmainStyle(XSSFCellStyle xmainStyle) {
        this.xmainStyle = xmainStyle;
    }

    public ExcelTmp(XSSFWorkbook xwb, int sheetNum, String[] headers,
                    List<List<String>> result, OutputStream out) {
        this.xwb = xwb;
        this.headers = headers;
        this.result = result;
        this.sheetNum = sheetNum;
        this.out = out;

        exportExcel(xwb);
    }

    public ExcelTmp(HSSFWorkbook wb, int sheetNum, String[] headers,
                    List<List<String>> result, OutputStream out) {
        this.hwb = wb;
        this.headers = headers;
        this.result = result;
        this.sheetNum = sheetNum;
        this.out = out;

        exportExcel(hwb);
    }

    public ExcelTmp(XSSFWorkbook xwb, int sheetNum, String sheetTitle, int columnWidth, String[] headers,
                    XSSFCellStyle xheaderStyle, List<List<String>> result, XSSFCellStyle xmainStyle,
                    OutputStream out) {
        this.xwb = xwb;
        this.columnWidth = columnWidth;
        this.sheetTitle = sheetTitle;
        this.headers = headers;
        this.result = result;
        this.sheetNum = sheetNum;
        this.xheaderStyle = xheaderStyle;
        this.xmainStyle = xmainStyle;
        this.out = out;

        exportExcel(xwb);
    }

    public ExcelTmp(HSSFWorkbook hwb, int sheetNum, String sheetTitle, int columnWidth, String[] headers,
                    HSSFCellStyle hheaderStyle, List<List<String>> result, HSSFCellStyle hmainStyle,
                    OutputStream out) {
        this.hwb = hwb;
        this.columnWidth = columnWidth;
        this.sheetTitle = sheetTitle;
        this.headers = headers;
        this.result = result;
        this.sheetNum = sheetNum;
        this.hheaderStyle = hheaderStyle;
        this.hmainStyle = hmainStyle;
        this.out = out;

        exportExcel(hwb);
    }

    public ExcelTmp(XSSFWorkbook xwb, String sheetTitle, int columnWidth, String[] headers,
                    XSSFCellStyle xheaderStyle, List<List<String>> result, XSSFCellStyle xmainStyle,
                    OutputStream out) {
        this.xwb = xwb;
        this.columnWidth = columnWidth;
        this.sheetTitle = sheetTitle;
        this.headers = headers;
        this.result = result;
        this.sheetNum = sheetNum;
        this.xheaderStyle = xheaderStyle;
        this.xmainStyle = xmainStyle;
        this.out = out;

        exportExcel(xwb);
    }

    public ExcelTmp(HSSFWorkbook hwb, String sheetTitle, int columnWidth, String[] headers,
                    HSSFCellStyle hheaderStyle, List<List<String>> result, HSSFCellStyle hmainStyle,
                    OutputStream out) {
        this.hwb = hwb;
        this.columnWidth = columnWidth;
        this.sheetTitle = sheetTitle;
        this.headers = headers;
        this.result = result;
        this.sheetNum = sheetNum;
        this.hheaderStyle = hheaderStyle;
        this.hmainStyle = hmainStyle;
        this.out = out;

        exportExcel(hwb);
    }

    public ExcelTmp(XSSFWorkbook xwb, int sheetNum, int columnWidth, String[] headers,
                    XSSFCellStyle xheaderStyle, List<List<String>> result, XSSFCellStyle xmainStyle,
                    OutputStream out) {
        this.xwb = xwb;
        this.columnWidth = columnWidth;
        this.sheetTitle = sheetTitle;
        this.headers = headers;
        this.result = result;
        this.sheetNum = sheetNum;
        this.xheaderStyle = xheaderStyle;
        this.xmainStyle = xmainStyle;
        this.out = out;

        exportExcel(xwb);
    }

    public ExcelTmp(HSSFWorkbook hwb, int sheetNum, int columnWidth, String[] headers,
                    HSSFCellStyle hheaderStyle, List<List<String>> result, HSSFCellStyle hmainStyle,
                    OutputStream out) {
        this.hwb = hwb;
        this.columnWidth = columnWidth;
        this.sheetTitle = sheetTitle;
        this.headers = headers;
        this.result = result;
        this.sheetNum = sheetNum;
        this.hheaderStyle = hheaderStyle;
        this.hmainStyle = hmainStyle;
        this.out = out;

        exportExcel(hwb);
    }

    public ExcelTmp(XSSFWorkbook xwb, int sheetNum, String sheetTitle, String[] headers,
                    XSSFCellStyle xheaderStyle, List<List<String>> result, XSSFCellStyle xmainStyle,
                    OutputStream out) {
        this.xwb = xwb;
        this.columnWidth = columnWidth;
        this.sheetTitle = sheetTitle;
        this.headers = headers;
        this.result = result;
        this.sheetNum = sheetNum;
        this.xheaderStyle = xheaderStyle;
        this.xmainStyle = xmainStyle;
        this.out = out;

        exportExcel(xwb);
    }

    public ExcelTmp(HSSFWorkbook hwb, int sheetNum, String sheetTitle, String[] headers,
                    HSSFCellStyle hheaderStyle, List<List<String>> result, HSSFCellStyle hmainStyle,
                    OutputStream out) {
        this.hwb = hwb;
        this.columnWidth = columnWidth;
        this.sheetTitle = sheetTitle;
        this.headers = headers;
        this.result = result;
        this.sheetNum = sheetNum;
        this.hheaderStyle = hheaderStyle;
        this.hmainStyle = hmainStyle;
        this.out = out;

        exportExcel(hwb);
    }

    public ExcelTmp(XSSFWorkbook xwb, int sheetNum, String sheetTitle, int columnWidth, String[] headers,
                    List<List<String>> result, XSSFCellStyle xmainStyle,
                    OutputStream out) {
        this.xwb = xwb;
        this.columnWidth = columnWidth;
        this.sheetTitle = sheetTitle;
        this.headers = headers;
        this.result = result;
        this.sheetNum = sheetNum;
        this.xheaderStyle = xheaderStyle;
        this.xmainStyle = xmainStyle;
        this.out = out;

        exportExcel(xwb);
    }

    public ExcelTmp(HSSFWorkbook hwb, int sheetNum, String sheetTitle, int columnWidth, String[] headers,
                    List<List<String>> result, HSSFCellStyle hmainStyle,
                    OutputStream out) {
        this.hwb = hwb;
        this.columnWidth = columnWidth;
        this.sheetTitle = sheetTitle;
        this.headers = headers;
        this.result = result;
        this.sheetNum = sheetNum;
        this.hheaderStyle = hheaderStyle;
        this.hmainStyle = hmainStyle;
        this.out = out;

        exportExcel(hwb);
    }

    public ExcelTmp(XSSFWorkbook xwb, int sheetNum, String sheetTitle, int columnWidth, String[] headers,
                    XSSFCellStyle xheaderStyle, List<List<String>> result,
                    OutputStream out) {
        this.xwb = xwb;
        this.columnWidth = columnWidth;
        this.sheetTitle = sheetTitle;
        this.headers = headers;
        this.result = result;
        this.sheetNum = sheetNum;
        this.xheaderStyle = xheaderStyle;
        this.xmainStyle = xmainStyle;
        this.out = out;

        exportExcel(xwb);
    }

    public ExcelTmp(HSSFWorkbook hwb, int sheetNum, String sheetTitle, int columnWidth, String[] headers,
                    HSSFCellStyle hheaderStyle, List<List<String>> result,
                    OutputStream out) {
        this.hwb = hwb;
        this.columnWidth = columnWidth;
        this.sheetTitle = sheetTitle;
        this.headers = headers;
        this.result = result;
        this.sheetNum = sheetNum;
        this.hheaderStyle = hheaderStyle;
        this.hmainStyle = hmainStyle;
        this.out = out;

        exportExcel(hwb);
    }

    public ExcelTmp(XSSFWorkbook xwb, int columnWidth, String[] headers,
                    XSSFCellStyle xheaderStyle, List<List<String>> result, XSSFCellStyle xmainStyle,
                    OutputStream out) {
        this.xwb = xwb;
        this.columnWidth = columnWidth;
        this.sheetTitle = sheetTitle;
        this.headers = headers;
        this.result = result;
        this.sheetNum = sheetNum;
        this.xheaderStyle = xheaderStyle;
        this.xmainStyle = xmainStyle;
        this.out = out;

        exportExcel(xwb);
    }

    public ExcelTmp(HSSFWorkbook hwb, int columnWidth, String[] headers,
                    HSSFCellStyle hheaderStyle, List<List<String>> result, HSSFCellStyle hmainStyle,
                    OutputStream out) {
        this.hwb = hwb;
        this.columnWidth = columnWidth;
        this.sheetTitle = sheetTitle;
        this.headers = headers;
        this.result = result;
        this.sheetNum = sheetNum;
        this.hheaderStyle = hheaderStyle;
        this.hmainStyle = hmainStyle;
        this.out = out;

        exportExcel(hwb);
    }

    public ExcelTmp(XSSFWorkbook xwb, String[] headers,
                    XSSFCellStyle xheaderStyle, List<List<String>> result, XSSFCellStyle xmainStyle,
                    OutputStream out) {
        this.xwb = xwb;
        this.columnWidth = columnWidth;
        this.sheetTitle = sheetTitle;
        this.headers = headers;
        this.result = result;
        this.sheetNum = sheetNum;
        this.xheaderStyle = xheaderStyle;
        this.xmainStyle = xmainStyle;
        this.out = out;

        exportExcel(xwb);
    }

    public ExcelTmp(HSSFWorkbook hwb, String[] headers,
                    HSSFCellStyle hheaderStyle, List<List<String>> result, HSSFCellStyle hmainStyle,
                    OutputStream out) {
        this.hwb = hwb;
        this.sheetTitle = sheetTitle;
        this.headers = headers;
        this.result = result;
        this.sheetNum = sheetNum;
        this.hheaderStyle = hheaderStyle;
        this.hmainStyle = hmainStyle;
        this.out = out;

        exportExcel(hwb);
    }

    public ExcelTmp(XSSFWorkbook xwb, int sheetNum, String sheetTitle, String[] headers,
                    XSSFCellStyle xheaderStyle, List<List<String>> result,
                    OutputStream out) {
        this.xwb = xwb;
        this.columnWidth = columnWidth;
        this.sheetTitle = sheetTitle;
        this.headers = headers;
        this.result = result;
        this.sheetNum = sheetNum;
        this.xheaderStyle = xheaderStyle;
        this.xmainStyle = xmainStyle;
        this.out = out;

        exportExcel(xwb);
    }

    public ExcelTmp(HSSFWorkbook hwb, int sheetNum, String sheetTitle, String[] headers,
                    HSSFCellStyle hheaderStyle, List<List<String>> result,
                    OutputStream out) {
        this.hwb = hwb;
        this.columnWidth = columnWidth;
        this.sheetTitle = sheetTitle;
        this.headers = headers;
        this.result = result;
        this.sheetNum = sheetNum;
        this.hheaderStyle = hheaderStyle;
        this.hmainStyle = hmainStyle;
        this.out = out;

        exportExcel(hwb);
    }

    public ExcelTmp(XSSFWorkbook xwb, int sheetNum, int columnWidth, String[] headers,
                    XSSFCellStyle xheaderStyle, List<List<String>> result,
                    OutputStream out) {
        this.xwb = xwb;
        this.columnWidth = columnWidth;
        this.sheetTitle = sheetTitle;
        this.headers = headers;
        this.result = result;
        this.sheetNum = sheetNum;
        this.xheaderStyle = xheaderStyle;
        this.xmainStyle = xmainStyle;
        this.out = out;

        exportExcel(xwb);
    }

    public ExcelTmp(HSSFWorkbook hwb, int sheetNum, int columnWidth, String[] headers,
                    HSSFCellStyle hheaderStyle, List<List<String>> result,
                    OutputStream out) {
        this.hwb = hwb;
        this.columnWidth = columnWidth;
        this.sheetTitle = sheetTitle;
        this.headers = headers;
        this.result = result;
        this.sheetNum = sheetNum;
        this.hheaderStyle = hheaderStyle;
        this.hmainStyle = hmainStyle;
        this.out = out;

        exportExcel(hwb);
    }

    public ExcelTmp(XSSFWorkbook xwb, String[] headers,
                    XSSFCellStyle xheaderStyle, List<List<String>> result,
                    OutputStream out) {
        this.xwb = xwb;
        this.columnWidth = columnWidth;
        this.sheetTitle = sheetTitle;
        this.headers = headers;
        this.result = result;
        this.sheetNum = sheetNum;
        this.xheaderStyle = xheaderStyle;
        this.xmainStyle = xmainStyle;
        this.out = out;

        exportExcel(xwb);
    }

    public ExcelTmp(HSSFWorkbook hwb, String[] headers,
                    HSSFCellStyle hheaderStyle, List<List<String>> result,
                    OutputStream out) {
        this.hwb = hwb;
        this.columnWidth = columnWidth;
        this.sheetTitle = sheetTitle;
        this.headers = headers;
        this.result = result;
        this.sheetNum = sheetNum;
        this.hheaderStyle = hheaderStyle;
        this.hmainStyle = hmainStyle;
        this.out = out;

        exportExcel(hwb);
    }

    public ExcelTmp(XSSFWorkbook xwb, int sheetNum, String sheetTitle, String[] headers,
                    List<List<String>> result, OutputStream out) {
        this.xwb = xwb;
        this.sheetTitle = sheetTitle;
        this.headers = headers;
        this.result = result;
        this.sheetNum = sheetNum;
        this.out = out;

        exportExcel(xwb);
    }

    public ExcelTmp(HSSFWorkbook wb, int sheetNum, String sheetTitle, String[] headers,
                    List<List<String>> result, HSSFCellStyle hmainStyle, OutputStream out) {
        this.hwb = wb;
        this.sheetTitle = sheetTitle;
        this.headers = headers;
        this.result = result;
        this.sheetNum = sheetNum;
        this.out = out;
        this.hmainStyle = hmainStyle;

        exportExcel(hwb);
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

    public ExcelTmp(XSSFWorkbook xwb, String sheetTitle, String[] headers,
                    List<List<String>> result, OutputStream out) {
        this.xwb = xwb;
        this.sheetTitle = sheetTitle;
        this.headers = headers;
        this.result = result;
        this.out = out;

        exportExcel(xwb);
    }

    public ExcelTmp(HSSFWorkbook wb, String sheetTitle, String[] headers,
                    List<List<String>> result, OutputStream out) {
        this.hwb = wb;
        this.sheetTitle = sheetTitle;
        this.headers = headers;
        this.result = result;
        this.out = out;

        exportExcel(hwb);
    }

    public ExcelTmp(XSSFWorkbook xwb, String[] headers,
                    List<List<String>> result, OutputStream out) {
        this.xwb = xwb;
        this.headers = headers;
        this.result = result;
        this.out = out;

        exportExcel(xwb);
    }

    public ExcelTmp(HSSFWorkbook wb, String[] headers,
                    List<List<String>> result, OutputStream out) {
        this.hwb = wb;
        this.headers = headers;
        this.result = result;
        this.out = out;

        exportExcel(hwb);
    }

    private void exportExcel(XSSFWorkbook xwb) {

        // 生成一个表格
        XSSFSheet sheet = xwb.createSheet();

        if (sheetTitle == null) {
            sheetTitle = String.format("sheet%s", String.valueOf(sheetNum));
        }

        if (xwb.getNumberOfSheets() < sheetNum) {
            sheetNum = xwb.getNumberOfSheets() - 1;
        }

        xwb.setSheetName(sheetNum, sheetTitle);
        // 设置表格默认列宽度为20个字节
        sheet.setDefaultColumnWidth(columnWidth);

        if (xheaderStyle == null) {
            xheaderStyle = ExcelUtil.getHeaderXssfCellStyle(xwb);
        }

        if (xmainStyle == null) {
            xmainStyle = ExcelUtil.getMainXssfCellStyle(xwb);
        }

        // 产生表格标题行
        XSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            XSSFCell cell = row.createCell(i);

            cell.setCellStyle(xheaderStyle);
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

                    cell.setCellStyle(xmainStyle);
                    
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

        if (sheetTitle == null) {
            sheetTitle = String.format("sheet%s", String.valueOf(sheetNum));
        }

        if (hwb.getNumberOfSheets() < sheetNum) {
            sheetNum = hwb.getNumberOfSheets() - 1;
        }

        hwb.setSheetName(sheetNum, sheetTitle);
        // 设置表格默认列宽度为20个字节
        sheet.setDefaultColumnWidth(columnWidth);


        if (hheaderStyle == null) {
            hheaderStyle = ExcelUtil.getHeaderHssfStyle(hwb);
        }

        if (hmainStyle == null) {
            hmainStyle = ExcelUtil.getMainHssfStyle(hwb);
        }
        // 产生表格标题行
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);

            cell.setCellStyle(hheaderStyle);
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
