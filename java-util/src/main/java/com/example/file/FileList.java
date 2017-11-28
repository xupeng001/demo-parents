package com.example.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * 类FileList.java的实现描述：TODO 类实现描述
 * 
 * @author xupeng 2017年4月11日 下午3:31:30
 */
public class FileList {

	public static void main(String[] args) {
		String source = "D:\\jar\\taobao-hsf.sar";

		System.out.println("---------------------");
		list(Lists.newArrayList(source), 1);
		// listNIO(source);
		System.out.println("---------------------");

	}

	public static void list(List<String> source, int x) {
		StringBuffer sb = new StringBuffer();
		for (String path : source) {
			File f = new File(path);
			List<String> dirs = new ArrayList<String>();

			sb.setLength(0);
			for (int i = 0; i < x; i++) {
				sb.append("---");
			}
			sb.append(f.getAbsolutePath());
			System.out.println(sb.toString());

			for (File temp : f.listFiles()) {
				if (temp.isDirectory()) {
					dirs.add(temp.getAbsolutePath());
				}

				if (temp.isFile()) {
					sb.setLength(0);
					for (int i = 0; i < x; i++) {
						sb.append("  ");
					}
					sb.append(temp.getName());
					System.out.println(sb.toString());
				}
			}

			if (!dirs.isEmpty()) {
				list(dirs, x++);
			}

		}

	}

	public static void list(String source, int x) {
		StringBuffer sb = new StringBuffer();
		File f = new File(source);

		for (File temp : f.listFiles()) {
			if (temp.isDirectory()) {
				sb.setLength(0);
				for (int i = 0; i < x; i++) {
					sb.append("---");
				}
				sb.append(temp.getName());
				System.out.println(sb.toString());
				list(temp.getAbsolutePath(), x++);
			}
			if (temp.isFile()) {
				sb.setLength(0);
				for (int i = 0; i < x; i++) {
					sb.append("  ");
				}
				sb.append(temp.getName());
				System.out.println(sb.toString());
			}
		}
	}

	public static void listNIO(String source) {
		Path initPath = Paths.get(source);
		try {
			Files.walkFileTree(initPath, new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile(Path file,
						BasicFileAttributes attrs) {
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
