package com.ssm.stu.service;

import com.ssm.stu.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.ssm.stu.bean.DormExample.Criteria;
import com.ssm.stu.bean.Student;
import com.ssm.stu.bean.StudentExample;
import com.ssm.stu.dao.StudentMapper;

@Service
public class StudentService extends BaseService {

	@Autowired
	StudentMapper studentMapper;

	@Autowired
	UserDao userDao;

//	查询全部学生信息
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return studentMapper.selectByExampleWithDorm(null);
	}
//	学生信息保存
	public void saveStu(Student student) {
		// TODO Auto-generated method stub
		studentMapper.insertSelective(student);
	}
//	检验学号是否重复
	public boolean checkStuNum(Integer stuNum) {
		// TODO Auto-generated method stub
		
		StudentExample example =new StudentExample();
		com.ssm.stu.bean.StudentExample.Criteria criteria= example.createCriteria();
		criteria.andStuNumEqualTo(stuNum);	
		long count=studentMapper.countByExample(example);
		return count==0;
	}
	//按照ID查询学生信息
	public Student getStu(Integer id) {
		// TODO Auto-generated method stub
		Student student=studentMapper.selectByPrimaryKey(id);
		return student;
	}
	
	//更新保存信息
	public void updateStu(Student student) {
		// TODO Auto-generated method stub
		studentMapper.updateByPrimaryKeySelective(student);
	}
	//删除信息
	public void deleteStu(Integer id) {
		// TODO Auto-generated method stub
		userDao.deleteByPrimaryKey(id);
	}
	//批量删除
	public void deleteBatch(List<Integer> ids) {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		for (Integer id:
		ids) {
			builder.append(String.format("'%d',",id));
		}
		builder.setLength(builder.length()-1);
		userDao.deleteByPrimaryKeys(builder.toString());
	}


}
