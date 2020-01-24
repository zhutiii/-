package com.ssm.stu.service;

import com.ssm.stu.bean.newBean.User;
import com.ssm.stu.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.stu.bean.Admin;
import com.ssm.stu.dao.AdminMapper;
@Service
public class AdminService extends BaseService {

	@Autowired
	AdminMapper adminMapper;

	@Autowired
	UserDao userDao;

	public Admin adminlog(String adminName) {
		// TODO Auto-generated method stub
		return adminMapper.getAdminByName(adminName);
	}


}
