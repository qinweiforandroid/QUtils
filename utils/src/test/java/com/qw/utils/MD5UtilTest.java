package com.qw.utils;

import org.junit.Test;

/**
 * Created by qinwei on 2016/11/25 14:09
 * email:qinwei_it@163.com
 */

public class MD5UtilTest {
    @Test
    public void getMD5String() throws Exception {
        String md5String = MD5Util.getMD5String("153750720601522403178381203556831");
        md5String = MD5Util.getMD5String(md5String + 831);
        System.out.println(md5String);
    }


}
