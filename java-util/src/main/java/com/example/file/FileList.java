package com.example.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * 类FileList.java的实现描述：TODO 类实现描述
 * 
 * @author xupeng 2017年4月11日 下午3:31:30
 */
public class FileList {

    public static void main(String[] args) {
        String source="D:\\service\\mariana-dao";
//        list(source);
        System.out.println("---------------------");
        listNIO(source);
        System.out.println("---------------------");
//        showDirectory(new File(source));
        
    }

    public static void list(String source) {
        File f = new File(source);
        for (File temp : f.listFiles()) {
            if (temp.isFile()) {
                System.out.println(temp.getName());
            }
        }
    }

    public static void listNIO(String source) {
        Path initPath = Paths.get(source);
        try {
            Files.walkFileTree(initPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    System.out.println(file.getFileName().toString());
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showDirectory(File f) {
        _walkDirectory(f, 0);
    }

    private static void _walkDirectory(File f, int level) {
        if (f.isDirectory()) {
            for (File temp : f.listFiles()) {
                _walkDirectory(temp, level + 1);
            }
        } else {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("\t");
            }
            System.out.println(f.getName());
        }
    }
}
