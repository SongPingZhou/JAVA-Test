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
		 String filePath="E:\\"+initTime()+".xls";//�ļ�·��
		 HSSFWorkbook workbook = new HSSFWorkbook();//����Excel�ļ�(Workbook)
		 HSSFSheet sheet = workbook.createSheet("title");//����������(Sheet)
		 
		 
		 
		 HSSFRow row = sheet.createRow(0);// ������,��0��ʼ
		 
		 row.createCell(0).setCellValue("��־ΰ");// ���õ�Ԫ������
		 row.createCell(1).setCellValue(false);// ���õ�Ԫ������,����
		 row.createCell(2).setCellValue(new Date());// ���õ�Ԫ������,����
		 row.createCell(3).setCellValue(12.345);// ���õ�Ԫ������,����
		 
		 
		 
		 FileOutputStream out;
		try {
			out = new FileOutputStream(filePath);
			workbook.write(out);//����Excel�ļ�
			out.close();//�ر��ļ���
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
