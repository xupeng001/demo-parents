package com.example.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 类FileCopy.java的实现描述：文件拷贝
 * 
 * @author xupeng 2017年4月11日 下午3:21:17
 */
public class FileUtils {

    private FileUtils() {
        throw new AssertionError();
    }

    public static void fileCopy(String source, String target) throws IOException {
        try (InputStream in = new FileInputStream(source)) {
            try (OutputStream out = new FileOutputStream(target)) {
                byte[] buffer = new byte[4096];
                int bytesToRead;
                while ((bytesToRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesToRead);
                }
            }
        }
    }

    public static void fileCopyNIO(String source, String target) throws IOException {
        try (FileInputStream in = new FileInputStream(source)) {
            try (FileOutputStream out = new FileOutputStream(target)) {
                FileChannel inChannel = in.getChannel();
                FileChannel outChannel = out.getChannel();
                ByteBuffer buffer = ByteBuffer.allocate(4096);
                while (inChannel.read(buffer) != -1) {
                    buffer.flip();
                    outChannel.write(buffer);
                    buffer.clear();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //        String source = "D:\\test\\Koala.jpg";
        //        String targetIO = "D:\\test\\KoalaIO.jpg";
        //        String targetNIO = "D:\\test\\KoalaNIO.jpg";
        //        fileCopy(source, targetIO);
        //        fileCopyNIO(source, targetNIO);
        String source = "D:\\test\\任务搜索手工函数.sql";
        System.out.println(countWordInFile(source, "c"));
        System.out.println(countWordInFile(source, "C"));

    }

    public static int countWordInFile(String filename, String word) {
        int counter = 0;
        try (FileReader fr = new FileReader(filename)) {
            try (BufferedReader br = new BufferedReader(fr)) {
                String line = null;
                while ((line = br.readLine()) != null) {
                    int index = -1;
                    while (line.length() >= word.length() && (index = line.indexOf(word)) >= 0) {
                        counter++;
                        line = line.substring(index + word.length());
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return counter;
    }

}
