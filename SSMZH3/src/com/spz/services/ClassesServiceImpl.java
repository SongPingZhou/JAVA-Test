package com.spz.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spz.dao.ClassesMapper;
import com.spz.entity.Classes;
@Service
public class ClassesServiceImpl implements ClassesService {
	@Resource
	private ClassesMapper classesMapper;
	@Override
	public List<Classes> slectClass() {
		return classesMapper.slectClass();
	}

}
