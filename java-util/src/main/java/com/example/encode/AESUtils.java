package com.example.encode;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESUtils {

    public static String encrypt4AES(String source, String key) {
        try {
            key = Md5Util.encode(key);
            IvParameterSpec zeroIv = new IvParameterSpec(key.getBytes());
            SecretKeySpec key1 = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key1, zeroIv);
            byte[] encryptedData = cipher.doFinal(source.getBytes());
            String encryptResultStr = Base64.encode(encryptedData);
            return encryptResultStr;
            // 加密 
        } catch (NoSuchAlgorithmException e) {
        } catch (NoSuchPaddingException e) {
        } catch (InvalidKeyException e) {
        } catch (IllegalBlockSizeException e) {
        } catch (BadPaddingException e) {
        } catch (Exception e) {
        }
        return null;
    }

    public static String decrypt4AES(String content, String key) {
        try {
            key = Md5Util.encode(key);
            byte[] decryptFrom = Base64.decode(content);
            IvParameterSpec zeroIv = new IvParameterSpec(key.getBytes());
            SecretKeySpec key1 = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key1, zeroIv);
            byte decryptedData[] = cipher.doFinal(decryptFrom);
            return new String(decryptedData); // 加密 
        } catch (NoSuchAlgorithmException e) {
        } catch (NoSuchPaddingException e) {

        } catch (InvalidKeyException e) {

        } catch (UnsupportedEncodingException e) {

        } catch (IllegalBlockSizeException e) {

        } catch (BadPaddingException e) {

        } catch (Exception e) {

        }
        return null;
    }

    public static void main(String args[]) {
        try {
            System.out
                    .println(decrypt4AES(
                            "bM9teVZOvUnu+1i20/gdNd/r6ZQhEDBZASbckJz/eWDl3lgo4iMKloWg29zT NM6Ch4HUu+dWtsf0ft+ucfb03aWSEaNJshegZrYuLVOjQAx4ypxkAtgVnGyf EiexWSsZGTe9vx3U945A6fXLQsGa7GJO09ocMa62dKvnpcDMFZUny6oMHfLN xCsCzXVEuI8E3jGuBKggUAy4BXWN62Qbx+mJzyCMks9GVWy5zn9J8j2EFGlv NJJey/gM2uY+4Q9QHut0PM1GPAXoc1/2izrUbcjksuOoscq1zeLY3ibK7u/Y YjliABPWxG3QIBpc3B2XBdlJHy+c7k8iOlEBN4nWoMPwZnZ8aP6jTXm8K6uk PoxPiqw1EoOQlrhMgkd4Om/Bl2OSxJpGPTY84/tpqGDxYJ5opABpYXMmrARV Ti+Zg+SlQ2+d4bOtPSQZTiZB42K9brj83/G5Sq0tFG2meaEuJUNfqGs4ZrKS Yxez4F3Ge3Xkt5V6EA5oEsjPCsKMV8nO0uOZ0+cHTSZFkhsSy2Vp7k+I+M6t fh+ZQkKsiZv3Q4+RegD5U7rAq65i6Lm8LmSbvwMRM1oQ1D5W7Gejrlsf0fGj okHg5ej3djOvSbp2Ju43F2xqeCr4g9hckUqGhF+vPrc4PDI9Iq7ylPMXAiQY hemS77yuyJD8Ik0avlt3jkaeHrhTzMIbFeVk4y/h8TFi",
                            "key"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
