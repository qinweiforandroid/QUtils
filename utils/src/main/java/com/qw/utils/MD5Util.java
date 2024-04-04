package com.qw.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by qinwei on 2016/11/25 13:53
 * email:qinwei_it@163.com
 */

public class MD5Util {
    /**
     * 转md5字符
     *
     * @param s 需要转的字符
     * @return md5加密后字符
     */
    public static String getMD5String(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(s.getBytes());
            byte[] b = md.digest();
            int i;
            StringBuilder buf = new StringBuilder();
            for (byte value : b) {
                i = value;
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            s = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return s.toLowerCase();
    }
}
