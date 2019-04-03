package com.qw.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void money() throws Exception {
        String input = "0";
        if (TextUtil.isMoneyStr(input)) {
            System.out.println("金额格式：" + input);
        } else {
            System.out.println("非金额格式：" + input);
        }
    }

    @Test
    public void user() throws Exception {
        User user = new User();
        user.id = "123456";
        clear(user);
        System.out.print(user.toString());
    }

    public void clear(User user) {
        user.id = "222222";
        user = null;
    }

    public class User {
        String id;

        @Override
        public String toString() {
            return "User{" +
                    "id='" + id + '\'' +
                    '}';
        }
    }
}