package com.spz.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Test {

	public static void main(String[] args) {
		//定义表头
		String[] title={"序号","姓名","年龄"};
		//创建excel工作簿
		HSSFWorkbook workbook=new HSSFWorkbook();
		//创建工作表sheet
		HSSFSheet sheet=workbook.createSheet();
		//创建第一行
		HSSFRow row=sheet.createRow(0);
		HSSFCell cell=null;
		//插入第一行数据的表头
		for(int i=0;i<title.length;i++){
		    cell=row.createCell(i);
		    cell.setCellValue(title[i]);
		}
		//写入数据
		for (int i=1;i<=10;i++){
		    HSSFRow nrow=sheet.createRow(i);
		    HSSFCell ncell=nrow.createCell(0);
		    ncell.setCellValue(""+i);
		    ncell=nrow.createCell(1);
		    ncell.setCellValue("user"+i);
		    ncell=nrow.createCell(2);
		    ncell.setCellValue("24");
		}
		//创建excel文件
		File file=new File("E://poi.xlsx");
		try {
			file.createNewFile();
			    //将excel写入
			    /*FileOutputStream stream= FileUtils.openOutputStream(file);
			    workbook.write(stream);
			    stream.close();*/
			    
			    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*String path = "E:MyTest.txt";
		String createText = "Hello and Welcome";
		File.WriteAllText(path, createText,Encoding);
		File file=new File("E:/20190423.txt");
		if(file.exists()) {//判断是否存在
			file.delete();
		}else {
			try {
				file.createNewFile();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(file.getName());*/
	}

}
