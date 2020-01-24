package com.ssm.stu.controller;

import java.util.List;

import com.ssm.stu.bean.newBean.Dormitory;
import com.ssm.stu.bean.newBean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.stu.bean.Dorm;
import com.ssm.stu.bean.Msg;
import com.ssm.stu.service.DormService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DormController {

	@Autowired
	private DormService dormService;
	
	@RequestMapping("/dorm")
	@ResponseBody
	public Msg getDorm(HttpServletRequest request) {
		User userInfo = (User) request.getSession().getAttribute("userInfo");
		List<Dormitory> list=dormService.getDorm(userInfo.getFloorId());
		return Msg.success().add("dorm", list);
	}
}
