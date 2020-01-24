package com.ssm.stu.service;


import java.util.Arrays;
import java.util.List;

import com.ssm.stu.bean.newBean.Dormitory;
import com.ssm.stu.dao.DormitoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.stu.bean.Dorm;
import com.ssm.stu.dao.DormMapper;

@Service
public class DormService extends  BaseService{

	@Autowired
	private DormMapper dormMapper;

	@Autowired
	private DormitoryDao dormitoryDao;
	public List<Dormitory> getDorm(String floorId) {
		if (floorId == null) {
			return null;
		}
		// TODO Auto-generated method stub
		List<Dormitory> list=dormitoryDao.selectDormitoryListByFloorIds(listToMysqlInString(Arrays.asList(floorId.split(","))));
		return list;
	}

}
