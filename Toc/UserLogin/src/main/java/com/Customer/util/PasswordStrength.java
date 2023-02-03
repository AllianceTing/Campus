package com.Customer.util;


public class PasswordStrength {

    /**
     * 判断输入密码字符的类型。
     *
     * @param ch 密码字符
     * @return
     */

    private static int charMode(char ch) {
        int mode = 3;
        if (ch >= 65 && ch <= 90 || ch >= 97 && ch <= 122) {// 大写 小写
            mode--;
        } else if (ch < 48 || ch > 57) {//特殊字符
            mode--;
        }
        return mode;
    }

    /**
     * 检测密码强度(数字、大写字母、小写字母、特殊符号四种类型的个数)。：3.弱；2：中；1：强
     *
     * @param password 密码
     * @return 密码字符类型种类：1~3；0：表示密码太短不检测
     */

    public static int checkStrength(String password) {
        int modes = 0;
        for (int i = 0; i < password.length(); i++) {
            modes |= charMode(password.charAt(i));
        }
        return modes;
    }
}
