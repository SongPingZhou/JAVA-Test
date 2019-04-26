package com.spz.util;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExportExcel {
	/**
	 * 
	 * @param wb 创建HSSFWorkbook对象(excel的文档对象)
	 * @param res HttpServletResponse相应
	 * @param name 需要保存的文件名称
	 * @throws IOException 异常抛出
	 */
	public static void myExcel(HSSFWorkbook wb,HttpServletResponse res,String name) throws IOException {
		ByteArrayOutputStream fos = null;
		byte[] retArr = null;
		try {
			fos = new ByteArrayOutputStream();
			wb.write(fos);
			retArr = fos.toByteArray();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		OutputStream os = res.getOutputStream();
		try {
			res.reset();
			res.setHeader("Content-Disposition", "attachment; filename="+name);//要保存的文件名
			res.setContentType("application/octet-stream;charset=ISO-8859-1");
			os.write(retArr);
			os.flush();
		} finally {
			if (os != null) {
				os.close();
			}
		}
	}
}
