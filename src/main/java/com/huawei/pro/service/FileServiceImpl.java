package com.huawei.pro.service;

import com.huawei.pro.utils.FileUtil;
import com.huawei.pro.utils.LogUtil;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileServiceImpl implements FileService
{
    @Override
    public void parse(String dir)
    {
        LogUtil.log.info("解析目录路径");
        File fisrtDir = new File(dir);

//        FileUtil.printDir(fisrtDir, 0);

//        ArrayList<File> nextDir= FileUtil.getNextDir(fisrtDir);


        ArrayList<File> files = FileUtil.getByDepth(fisrtDir, 2);

        for (File file : files) {
            System.out.println(file);
        }

        ArrayList<File> nextDir= FileUtil.getNextDir(fisrtDir);
        for (File file : nextDir) {
            System.out.println("目录 ："+ file);
        }
    }


}
