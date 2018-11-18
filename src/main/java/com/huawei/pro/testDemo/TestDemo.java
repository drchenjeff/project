package com.huawei.pro.testDemo;

import com.huawei.pro.ProjectApp;
import com.huawei.pro.bean.ExcelTmp;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
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
            OutputStream out = new FileOutputStream("E:\\test.xls");
            List<List<String>> data = new ArrayList<List<String>>();
            for (int i = 1; i < 5; i++) {
                List rowData = new ArrayList();
                rowData.add(String.valueOf(i));
                rowData.add("东霖柏鸿");
                data.add(rowData);
            }
            String[] headers = {"ID", "用户名"};

            HSSFWorkbook workbook = new HSSFWorkbook();

            new ExcelTmp(workbook, 0, "上海", headers, data, out);
            new ExcelTmp(workbook, 1, "深圳", headers, data, out);
            new ExcelTmp(workbook, 2, "广州", headers, data, out);

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

}