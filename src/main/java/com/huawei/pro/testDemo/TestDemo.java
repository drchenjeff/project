package com.huawei.pro.testDemo;

import com.huawei.pro.ProjectApp;
import com.huawei.pro.utils.ExcelTmp;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProjectApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestDemo {

    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";


    @Test
    public void poiTest() {

        try {
            List<List<String>> data = new ArrayList<List<String>>();
            for (int i = 1; i < 5; i++) {
                List rowData = new ArrayList();
                rowData.add(String.valueOf(i));
                rowData.add("东霖柏鸿");
                data.add(rowData);
            }
            String[] headers = {"ID", "用户名"};

            OutputStream out = new FileOutputStream("E:\\test.xls");
            HSSFWorkbook workbook = new HSSFWorkbook();

//            new ExcelTmp(workbook, 0, headers, data, out);
//            new ExcelTmp(workbook, 1, headers, data, out);
//            new ExcelTmp(workbook, 2, "广州", headers, data, out);

            // 生成一个样式
            HSSFCellStyle style = workbook.createCellStyle();
            // 设置这些样式
            style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.PALE_BLUE.getIndex());
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            style.setBorderBottom(BorderStyle.THIN);
            style.setBorderLeft(BorderStyle.THIN);
            style.setBorderTop(BorderStyle.THIN);
            style.setBorderRight(BorderStyle.THIN);
            style.setAlignment(HorizontalAlignment.CENTER);

            // 生成一个字体
            HSSFFont font = workbook.createFont();
            font.setColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
            font.setFontHeightInPoints((short) 12);
            font.setBold(true);

            // 把字体应用到当前的样式
            style.setFont(font);

            ExcelTmp tmp = new ExcelTmp(workbook, 2, "广州", headers, data, style, out);

            //原理就是将所有的数据一起写入，然后再关闭输入流。
            workbook.write(out);

            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 判断Excel的版本,获取Workbook
     *
     * @param in
     * @param file
     * @return
     * @throws IOException
     */
    public static Workbook getWorkbok(InputStream in, File file) throws IOException {
        Workbook wb = null;
        if (file.getName().endsWith(EXCEL_XLS)) {  //Excel 2003
            wb = new HSSFWorkbook(in);
        } else if (file.getName().endsWith(EXCEL_XLSX)) {  // Excel 2007/2010
            wb = new XSSFWorkbook(in);
        }
        return wb;
    }

    /**
     * 数据库操作测试
     *
     * @param args
     * @throws ClassNotFoundException, SQLException
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");

        //一开始必须填一个已经存在的数据库
//        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";
        String url = "jdbc:h2:file:./test";
        Connection conn = DriverManager.getConnection(url, "root", "root");
        Statement stat = conn.createStatement();


        //创建数据库hello
        stat.executeUpdate("create schema if not exists test;");
//        stat.executeUpdate("create database hello");

        //打开创建的数据库
        stat.close();
        conn.close();
        url = "jdbc:h2:file:./test";
        conn = DriverManager.getConnection(url, "root", "root");
        stat = conn.createStatement();

        //创建表test
        stat.executeUpdate("create table test(id int, name varchar(80))");

        //添加数据
        stat.executeUpdate("insert into test values(1, '张三')");
        stat.executeUpdate("insert into test values(2, '李四')");

        //查询数据
        ResultSet result = stat.executeQuery("select * from test");
        while (result.next()) {
            System.out.println(result.getInt("id") + " " + result.getString("name"));
        }

        //关闭数据库
        result.close();
        stat.close();
        conn.close();
    }

}