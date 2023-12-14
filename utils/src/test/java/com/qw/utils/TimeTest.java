package com.qw.utils;

import android.net.Uri;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

    @Test
    public void format() {
        //theater_parent_update_time	Integer	37873
        long time = 64800L * 1000;
        String date = TimeHelper.getDate(System.currentTimeMillis());
        time = TimeHelper.parseDate(date).getTime() + time;
        System.out.println("old:" + time);
        System.out.println("now:" + System.currentTimeMillis());
        System.out.println("result:" + TimeHelper.getTime(time));
    }

    @Test
    public void name() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            int size = 3;
            Date date = simpleDateFormat.parse("2021-9-1");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            for (int i = 0; i < size; i++) {
                calendar.add(Calendar.DAY_OF_MONTH, 1);
                String time = simpleDateFormat.format(calendar.getTime());
                System.out.println(time);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
