package com.ssm.stu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.stu.bean.Dorm;
import com.ssm.stu.bean.Msg;
import com.ssm.stu.service.DormService;

@Controller
public class DormController {

	@Autowired
	private DormService dormService;
	
	@RequestMapping("/dorm")
	@ResponseBody
	public Msg getDorm() {
		List<Dorm> list=dormService.getDorm();
		return Msg.success().add("dorm", list);
	}
}
