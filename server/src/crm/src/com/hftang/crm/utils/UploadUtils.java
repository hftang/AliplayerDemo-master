package com.hftang.crm.utils;

import java.util.UUID;

/**
 * 文件上传工具类
 */
public class UploadUtils {


    /**
     * 获取随机文件名
     *
     * @param fileName
     * @return
     */
    public static String getUuidFileName(String fileName) {

        int idx = fileName.lastIndexOf(".");//aa.txt
        String extions = fileName.substring(idx);//得到扩展名
        return UUID.randomUUID().toString().replace("-", "") + extions;

    }

    public static String getPath(String uuidFileName) {
        int code1 = uuidFileName.hashCode();

        int d1 = code1 & 0xf;//作为一级目录
        int code2 = d1 >>> 4;
        int d2 = code2 & 0xf;//作为二级目录

        return "/" + d1 + "/" + d2;

    }


}
