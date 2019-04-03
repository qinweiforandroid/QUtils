package com.qw.utils;

import com.qw.utils.safe.AESUtil;

import org.junit.Test;

/**
 * Created by qinwei on 2018/3/30.
 */

public class SafeUnitTest {
    @Test
    public void name() throws Exception {
        String content = "{\"mobile\":\"15375072060\",\"random\":741,\"shopId\":\"203556\",\"timestamp\":1522399633736}";
        String key = "GnY5iyuhj6BPfDSG";
        String encrypted = AESUtil.encrypt(key, content);
        System.out.println("加密后：" + encrypted);

        String decrypted = AESUtil.decrypt("GnY5iyuhj6BPfDSG", encrypted);
        System.out.println("解密后：" + decrypted);
    }

}
