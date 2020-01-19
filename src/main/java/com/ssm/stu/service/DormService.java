package com.ssm.stu.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.stu.bean.Dorm;
import com.ssm.stu.dao.DormMapper;

@Service
public class DormService {

	@Autowired
	private DormMapper dormMapper;
	public List<Dorm> getDorm() {
		// TODO Auto-generated method stub
		List<Dorm> list=dormMapper.selectByExample(null);
		return list;
	}

}
