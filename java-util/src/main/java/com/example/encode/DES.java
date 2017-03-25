package com.example.encode;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;

/**
 * 类DES.java的实现描述：TODO 类实现描述
 * 
 * @author xupeng 2017年3月25日 上午10:48:08
 */
public class DES {
    private static final Logger loger = Logger.getLogger(DES.class);

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub  
        String key = "key";
        String text = "徐朋";
        String result1 = DES.encryptDES(text, key);
        String result2 = DES.decryptDES(result1, key);
        loger.info(result1);
        loger.info(result2);
    }

    private static byte[] iv = { 1, 2, 3, 4, 5, 6, 7, 8 };

    public static String encryptDES(String encryptString, String encryptKey) throws Exception {
        //      IvParameterSpec zeroIv = new IvParameterSpec(new byte[8]);  
        IvParameterSpec zeroIv = new IvParameterSpec(iv);
        SecretKeySpec key = new SecretKeySpec(encryptKey.getBytes(), "DES");
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);
        byte[] encryptedData = cipher.doFinal(encryptString.getBytes());

        return Base64.encode(encryptedData);
    }

    public static synchronized String decryptDES(String decryptString, String decryptKey) throws Exception {
        byte[] byteMi = new Base64().decode(decryptString);
        IvParameterSpec zeroIv = new IvParameterSpec(iv);
        //      IvParameterSpec zeroIv = new IvParameterSpec(new byte[8]);  
        SecretKeySpec key = new SecretKeySpec(decryptKey.getBytes(), "DES");
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            loger.error("DES--decryptDES--NoSuchAlgorithmException--11-->>" + e.getMessage());

        } catch (NoSuchPaddingException e) {
            // TODO Auto-generated catch block
            loger.error("DES--decryptDES--NoSuchPaddingException--11-->>" + e.getMessage());

        }

        try {
            cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);
        } catch (InvalidKeyException e) {
            // TODO Auto-generated catch block
            loger.error("DES--decryptDES--InvalidKeyException--11-->>" + e.getMessage());

        } catch (InvalidAlgorithmParameterException e) {
            // TODO Auto-generated catch block
            loger.error("DES--decryptDES--InvalidAlgorithmParameterException--11-->>" + e.getMessage());

        }
        byte decryptedData[] = null;
        try {
            decryptedData = cipher.doFinal(byteMi);
        } catch (IllegalBlockSizeException e) {
            // TODO Auto-generated catch block
            loger.error("DES--decryptDES--IOException--11-->>" + e.getMessage());

        } catch (BadPaddingException e) {
            // TODO Auto-generated catch block
            loger.error("DES--decryptDES--IOException--11-->>" + e.getMessage());

        }

        return new String(decryptedData);
    }

}
