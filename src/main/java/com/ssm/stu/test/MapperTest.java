package com.ssm.stu.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssm.stu.bean.Dorm;
import com.ssm.stu.bean.Student;
import com.ssm.stu.dao.DormMapper;
import com.ssm.stu.dao.StudentMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

	@Autowired
	DormMapper dormMapper;
	@Autowired
	StudentMapper studentMapper;
	
	@Test
	public void testCRUD() {
		System.out.println(dormMapper);
		
		
		dormMapper.insertSelective(new Dorm(null,14201));
		dormMapper.insertSelective(new Dorm(null,14202));
		
		studentMapper.insertSelective(new Student(null,1620502201,"韩梅梅","女","计算机科学与技术","医药信息工程学院",1));
		studentMapper.insertSelective(new Student(null,1620502202,"李雪","女","计算机科学与技术","医药信息工程学院",1));
		studentMapper.insertSelective(new Student(null,1620502203,"李磊","男","计算机科学与技术","医药信息工程学院",1));
		studentMapper.insertSelective(new Student(null,1620502204,"赵柳","女","计算机科学与技术","医药信息工程学院",2));
		studentMapper.insertSelective(new Student(null,1620502205,"王五","男","计算机科学与技术","医药信息工程学院",2));
	}
}
