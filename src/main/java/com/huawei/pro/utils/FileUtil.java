package com.huawei.pro.utils;

import java.io.File;
import java.util.ArrayList;

public class FileUtil
{
    private static ArrayList<File> files = new ArrayList<File>();

    public static void printDir(File f, int depth)
    {
        if (isDir(f)) return;
        if (!f.isDirectory())
        {
            System.out.println(f);
        }
        else
        {
            System.out.println(f);
            File[] fs = f.listFiles();

            depth++;
            for (int i = 0; i < fs.length; i++)
            {
                File file = fs[i];

                printDir(file, depth);

            }
        }
    }

    /**
     * @Description: 获取下一级目录
     * @Param: dir 目录路径
     * @return: ArrayList<File>
     * @Author: jeffChen
     * @Date: 2018/11/18
     */
    public static ArrayList<File> getNextDir(File dir)
    {
        files = new ArrayList<File>();
        ArrayList<File> nextDirs = new ArrayList<>();

        if (isDir(dir)) return nextDirs;

        LogUtil.log.info("获取下级目录 : " + dir);
        ArrayList<File> nextDir= getByDepth(dir,1);

        for (File file : nextDir) {
            if (file.isDirectory())
            {
                nextDirs.add(file);
            }
        }

        return nextDirs;
    }

    /**
     * @Description: 判断传入参数是否是一个目录，或者是否存在
     * @Param:  dir 目录地址
     * @return: boolean
     * @Author: jeffChen
     * @Date: 2018/11/18 14:12
     */
    private static boolean isDir(File dir)
    {
        if (!dir.isDirectory())
        {
            LogUtil.log.info("ERROR : " + dir + " 目录不存在");
            return true;
        }
        return false;
    }

    /**
     * @Description: 获取下一级文件
     * @Param: dir
     * @return: ArrayList<File>
     * @Author: jeffChen
     * @Date: 2018/11/18
     */
    public static ArrayList<File> getNextFile(File dir)
    {
        files = new ArrayList<File>();
        ArrayList<File> nextFiles = new ArrayList<>();

        if (isDir(dir)) return nextFiles;

        LogUtil.log.info("获取下级文件 : " + dir);
        ArrayList<File> nextDir= getByDepth(dir,1);

        for (File file : nextDir) {
            if (!file.isDirectory()) {
                nextFiles.add(file);
            }
        }

        return nextFiles;
    }

    /**
     * @Description: 通过传入路径和深度，获取该目录下的几级文件和目录信息
     * @Param: dir 目录路径；depth 目录级数
     * @return: File[]
     * @Author: jeffChen
     * @Date: 2018/11/18
     */
    public static ArrayList<File> getByDepth(File dir, int depth)
    {
        if (depth != 0 && dir.isDirectory())
        {
            File[] fs = dir.listFiles();

            for (int i = 0; i < fs.length; i++)
            {
                File file = fs[i];

                files.add(file);
                getByDepth(file, depth - 1);

            }
        }
        return files;

    }

}
