package com.qw.utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 文本工具
 */
public class TextUtil {
    public static boolean isValidate(String content) {
        return content != null && !content.trim().isEmpty();
    }

    public static boolean isValidate(String... contents) {
        for (String content : contents) {
            if (content == null || content.trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidate(ArrayList<?> list) {
        return list != null && !list.isEmpty();
    }

    /**
     * 判断是否为金额
     *
     * @param money 钱字符
     * @return true 是，false 否
     */
    public static boolean isMoneyStr(String money) {
        return money.matches("^(([1-9]\\d{0,5})|0)(\\.\\d{0,2})?$");
    }

    /**
     * String 转int
     *
     * @param intStr       int字符串
     * @param defaultValue 强转失败 默认值
     * @return 强转后的int类型数据，非int类型返回0
     */
    public static int toInt(String intStr, int defaultValue) {
        try {
            return Integer.parseInt(intStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return defaultValue;
        }
    }

    public static int toInt(String intStr) {
        return toInt(intStr, 0);
    }
}
