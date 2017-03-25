package com.example.file;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;


/**
 * 类FileStreamUtil.java的实现描述：TODO 类实现描述 
 * @author xupeng 2017年3月25日 上午10:34:22
 */
public class FileStreamUtil {
	/**
	 * 执行文件的读写操作
	 * @param file 要读取的文件
	 * @param target 写文件的地址
	 * @param newName 新文件的名称
	 */
	public static boolean executeFile(File file,String target,String newName){
		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;
		boolean flag = false;
		try {
			inputStream = new FileInputStream(file);
			outputStream = new FileOutputStream(target +file.separator+newName);
			byte[] buf = new byte[1024];
			int length = 0;
			   try {
				while ((length = inputStream.read(buf)) != -1) {
				    outputStream.write(buf, 0, length);
				   }
				 outputStream.flush();
				 flag = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			if(null != inputStream){
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(null != outputStream){
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}
	/**
	 * 删除附件
	 * @param path 路径
	 * @param name 文件名
	 * @return
	 */
	public static boolean deleteFile(String path,String name){
		boolean flag = true;//true 表示从服务器上删除附件成功,false则表示失败
		File file = new File(path+File.separator+name);
		if(file.exists())
			flag = file.delete();
		return flag;
	}
	public static void main(String[] args) {
		File file1 = new File("D:\\deskbg\\702.jpg");
		//boolean flag = executeFile(file1, "D:\\", "12.jpg");
//		if(flag){
//			System.out.println(11111);
//		}else{
//			System.out.println(2222);
//		}
		
//		 String path = ServletActionContext.getRequest().getRealPath("/");
//		 System.out.println(path);
		/*File file = new File("C:\\Users\\PC599\\workspace\\dxpt\\webapp\\upload\\1329199247500qqd6g.rar");
		file.delete();*/
	}
}