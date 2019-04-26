package com.spz.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Test1 {
	public static void main(String[] args) {
		 String filePath="E:\\"+initTime()+".xls";//文件路径
		 HSSFWorkbook workbook = new HSSFWorkbook();//创建Excel文件(Workbook)
		 HSSFSheet sheet = workbook.createSheet("title");//创建工作表(Sheet)
		 
		 
		 
		 HSSFRow row = sheet.createRow(0);// 创建行,从0开始
		 
		 row.createCell(0).setCellValue("李志伟");// 设置单元格内容
		 row.createCell(1).setCellValue(false);// 设置单元格内容,重载
		 row.createCell(2).setCellValue(new Date());// 设置单元格内容,重载
		 row.createCell(3).setCellValue(12.345);// 设置单元格内容,重载
		 
		 
		 
		 FileOutputStream out;
		try {
			out = new FileOutputStream(filePath);
			workbook.write(out);//保存Excel文件
			out.close();//关闭文件流
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 System.out.println("OK!");
	}
	
	public static String initTime() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
		return sdf.format(new Date());
	}
}
