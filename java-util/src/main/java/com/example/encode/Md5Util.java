package com.example.encode;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {
    public static void main(String args[]) {
        System.out.println(encode("metAndroid"));
    }

    public static String encode(String content) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(content.getBytes());
            return getEncode16(digest);
            //			return getEncode32(digest);
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block

        }
        return null;
    }

    /**
     * 32位加密
     * 
     * @param digest
     * @return
     */
    private static String getEncode32(MessageDigest digest) {
        StringBuilder builder = new StringBuilder();
        for (byte b : digest.digest()) {
            builder.append(Integer.toHexString((b >> 4) & 0xf));
            builder.append(Integer.toHexString(b & 0xf));
        }
        // return builder.toString().toLowerCase(); // 小写
        // return builder.toString().toUpperCase(); // 大写
        // java.lang.String.toUpperCase(Locale locale)
        // 方法将在此字符串中的所有字符为大写的规则给定的Locale.
        // return builder.toString().toUpperCase(Locale.getDefault()); // 大写
        return builder.toString();
    }

    /**
     * 16位加密
     * 
     * @param digest
     * @return
     */
    private static String getEncode16(MessageDigest digest) {
        StringBuilder builder = new StringBuilder();
        for (byte b : digest.digest()) {
            builder.append(Integer.toHexString((b >> 4) & 0xf));
            builder.append(Integer.toHexString(b & 0xf));
        }
        // 16位加密，从第9位到25位
        // return builder.substring(8, 24).toString().toUpperCase();
        return builder.substring(8, 24).toString();
    }
}
