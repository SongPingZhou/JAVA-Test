package com.spz.entity;

import java.util.List;

public class ListTable<T> {
	
	private List<T> stulist;

	public List<T> getStulist() {
		return stulist;
	}

	public void setStulist(List<T> stulist) {
		this.stulist = stulist;
	}

	@Override
	public String toString() {
		return "ListTable [stulist=" + stulist + "]";
	}


	

	

	
	
}
