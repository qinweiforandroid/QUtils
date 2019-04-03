package com.qw.utils;

import org.junit.Test;

/**
 * Created by qinwei on 2019/4/3 4:22 PM
 * email: qin.wei@mwee.cn
 */
public class TimeTest {
    @Test
    public void test() {
        long time = 3600000 * 2;
        System.out.println("getDate    " + TimeHelper.getDate(System.currentTimeMillis()));
        System.out.println("getTime    " + TimeHelper.getTime());
        System.out.println("getTimeRule1 " + TimeHelper.getTimeRule1(System.currentTimeMillis() - time));
        System.out.println("getTimeRule2 " + TimeHelper.getTimeRule2(System.currentTimeMillis() - time));
    }
}
