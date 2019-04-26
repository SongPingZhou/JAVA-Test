package com.spz.test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

public class Test6 {
	
	public static void export(HttpServletResponse res) throws IOException {
		// ����HSSFWorkbook����(excel���ĵ�����)
		HSSFWorkbook wb = new HSSFWorkbook();
		// �����µ�sheet����excel�ı���
		HSSFSheet sheet = wb.createSheet("student");
		// ��sheet�ﴴ����һ�У�����Ϊ������(excel����)��������0��65535֮����κ�һ��
		HSSFRow row1 = sheet.createRow(0);
		// ������Ԫ��excel�ĵ�Ԫ�񣬲���Ϊ��������������0��255֮����κ�һ��
		HSSFCell cell = row1.createCell(0);
		// ���õ�Ԫ������
		cell.setCellValue("ѧ����Ϣ��");
		// �ϲ���Ԫ��CellRangeAddress����������α�ʾ��ʼ�У������У���ʼ�У� ������
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
		// ��sheet�ﴴ���ڶ���
		HSSFRow row2 = sheet.createRow(1);
		// ������Ԫ�����õ�Ԫ������
		row2.createCell(0).setCellValue("����");
		row2.createCell(1).setCellValue("�༶");
		// ��sheet�ﴴ��������
		HSSFRow row3 = sheet.createRow(2);
		row3.createCell(0).setCellValue("����");
		row3.createCell(1).setCellValue("һ�꼶һ��");
 
		//��excel������д���ļ�
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
			res.setHeader("Content-Disposition", "attachment; filename=agent_book.xls");//Ҫ������ļ���
			res.setContentType("application/octet-stream; charset=utf-8");
			os.write(retArr);
			os.flush();
		} finally {
			if (os != null) {
				os.close();
			}
		}
	}
}
