package com.spz.controller;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.spz.entity.Students;
import com.spz.test.Test6;
import com.spz.util.ExportExcel;
import com.spz.util.Result;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class ExcelController {
	@RequestMapping(value="/ExcelDc",method=RequestMethod.POST)
	@ResponseBody
	public Integer ExcelDc(@RequestParam("stulist") String stulist,@RequestParam("title") String title) throws Exception {
		String[] split = title.split(",");
		Gson gson=new Gson();
		List<Students> stu=gson.fromJson(stulist, new TypeToken<List<Students>>() {}.getType());
		String filePath="E:\\"+initTime()+".xls";//文件路径
		HSSFWorkbook workbook = new HSSFWorkbook();//创建Excel文件(Workbook)
		HSSFSheet sheet = workbook.createSheet("title");//创建工作表(Sheet)
		
	 	//创建第一行
		HSSFRow rows=sheet.createRow(0);
		HSSFCell cell=null;
		//向表格写入title
		for(int i=0;i<split.length;i++) {
			 cell=rows.createCell(i);
			 cell.setCellValue(split[i]);
		}
		//向表格写入内容
		for(int i=0;i<stu.size();i++) {
			 HSSFRow row = sheet.createRow(i+1);//创建行,从0开始
				String[] result = Result.getResult(stu.get(i),split.length-1);
				for(int j=0;j<result.length;j++) {
					row.createCell(j).setCellValue(result[j]);
				}
		}
		 FileOutputStream out;
		try {
			out = new FileOutputStream(filePath);
			workbook.write(out);//保存Excel文件
			out.close();//关闭文件流
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.println("OK!");
		return 1;
	}
	public static String initTime() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
		return sdf.format(new Date());
	}
	@RequestMapping(value="/dc",method=RequestMethod.GET)
	@ResponseBody
	public Integer dc(HttpServletResponse response) {
		try {
			Test6.export(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}
	@RequestMapping(value="/dochu",method=RequestMethod.GET)
	@ResponseBody
	public void daochu(HttpServletResponse res,@RequestParam("stulist") String stulist,@RequestParam("title") String title) throws Exception{
		String name=initTime()+".xls";
		String[] split = title.split(",");
		Gson gson=new Gson();
		List<Students> stu=gson.fromJson(stulist, new TypeToken<List<Students>>() {}.getType());
		
		
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("title");
		HSSFRow row1 = sheet.createRow(0);
		HSSFCell cell = row1.createCell(0);
		
		for(int i=0;i<split.length;i++) {
			 cell=row1.createCell(i);
			 cell.setCellValue(split[i]);
		}
		//向表格写入内容
		for(int i=0;i<stu.size();i++) {
			 HSSFRow row = sheet.createRow(i+1);//创建行,从0开始
				String[] result = Result.getResult(stu.get(i),split.length-1);
				for(int j=0;j<result.length;j++) {
					row.createCell(j).setCellValue(result[j]);
				}
		}
		//将excel的数据写入所选的位置
		ExportExcel.myExcel(wb, res, name);
	}
}
