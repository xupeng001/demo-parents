package com.example.file;
/**
 * 
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 类PropertiesUtil.java的实现描述：TODO 类实现描述 
 * @author xupeng 2017年3月25日 上午10:33:46
 */
public class PropertiesUtil {
    private static String       configPath = "/data/log4J/location.properties";
    //	private static String configPath="d:/location.properties";
    private static final Logger loger      = Logger.getLogger(PropertiesUtil.class);

    public static void main(String[] args) {

        String a = read("oOCZ1tz__qFlqxN57XjfzChO_fkI");
        System.out.println(a);
    }

    public static String read(String info) {
        synchronized (PropertiesUtil.class) {
            String value = null;
            FileInputStream pInStream = null;
            Properties p = null;
            try {
                File pFile = new File(configPath);
                pInStream = new FileInputStream(pFile);
                p = new Properties();
                p.load(pInStream);
                Enumeration enu = p.propertyNames(); // 取出所有的key
                value = p.getProperty(info);

            } catch (FileNotFoundException e) {
                loger.error("ReadProperties--read--FileNotFoundException--11-->>" + e.getMessage());
            } catch (IOException e) {
                loger.error("ReadProperties--read--IOException--11-->>" + e.getMessage());
            } catch (Exception e) {
                loger.error("ReadProperties--read--Exception--11-->>" + e.getMessage());
            } finally {
                try {
                    pInStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    loger.error("ReadProperties--read--IOException--22-->>" + e.getMessage());
                }
                p.clear();
            }
            return value;
        }
    }

    public static void saveLocationInfo(String key, String value) {
        Properties prop = null;
        InputStream fis = null;
        OutputStream fos = null;
        try {
            prop = new Properties();
            fis = new FileInputStream(configPath);
            prop.load(fis);
            fos = new FileOutputStream(configPath);
            prop.setProperty(key, value);
            prop.store(fos, "update");

        } catch (FileNotFoundException e) {
            loger.error("ReadProperties--read--FileNotFoundException--11-->>" + e.getMessage());
        } catch (IOException e) {
            loger.error("ReadProperties--read--IOException--11-->>" + e.getMessage());
        } catch (Exception e) {
            loger.error("ReadProperties--read--Exception--11-->>" + e.getMessage());
        } finally {
            try {
                //关闭文件
                fis.close();
                fos.close();
                prop.clear();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                loger.error("ReadProperties--read--IOException--22-->>" + e.getMessage());
            }

        }
    }

    public static void updateLocationInfo(String key, String value) {
        Properties prop = null;
        InputStream fis = null;
        OutputStream fos = null;
        try {
            prop = new Properties();
            fis = new FileInputStream(configPath);
            prop.load(fis);
            fos = new FileOutputStream(configPath);
            prop.setProperty(key, value);
            prop.store(fos, "update");

        } catch (FileNotFoundException e) {
            loger.error("ReadProperties--read--FileNotFoundException--11-->>" + e.getMessage());
        } catch (IOException e) {
            loger.error("ReadProperties--read--IOException--11-->>" + e.getMessage());
        } catch (Exception e) {
            loger.error("ReadProperties--read--Exception--11-->>" + e.getMessage());
        } finally {
            try {
                //关闭文件
                fis.close();
                fos.close();
                prop.clear();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                loger.error("ReadProperties--read--IOException--22-->>" + e.getMessage());
            }

        }
    }
}
