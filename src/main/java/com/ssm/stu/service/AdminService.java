package com.ssm.stu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.stu.bean.Admin;
import com.ssm.stu.dao.AdminMapper;
@Service
public class AdminService {

	@Autowired
	AdminMapper adminMapper;
	public Admin adminlog(String adminName) {
		// TODO Auto-generated method stub
		return adminMapper.getAdminByName(adminName);
	}

}
