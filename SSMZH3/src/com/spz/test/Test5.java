package com.spz.test;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Test5 {
	public static void main(String[] args) {
		fileChooser();
	}
	public static void fileChooser() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
		//�����ļ�����
		chooser.setFileFilter(filter);
		//��ѡ�������
		int returnVal = chooser.showOpenDialog(new JPanel());
		//�����ļ����������֣���������ļ���
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println("��򿪵��ļ���: " + chooser.getSelectedFile().getName());
		}
	}
}