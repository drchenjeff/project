package com.huawei.pro.utils;

import java.util.logging.Logger;

public interface LogUtil {
    //得到log，用于打印日志
    Logger log = (Logger) Logger.getLogger(String.valueOf(LogUtil.class));
}
