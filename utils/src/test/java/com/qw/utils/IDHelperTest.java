package com.qw.utils;

import org.junit.Test;

/**
 * Created by qinwei on 2016/11/25 13:54
 * email:qinwei_it@163.com
 */

public class IDHelperTest {
    @Test
    public void getID() throws Exception {
       String id= IDHelper.generateNew();
       System.out.println("id:"+id);
    }
    //d72e0756-a998-444c-8219-199d578eeb72
}
