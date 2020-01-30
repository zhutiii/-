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
public class DormController extends BaseController {

	@Autowired
	private DormService dormService;
	
	@RequestMapping("/dorm")
	@ResponseBody
	public Msg getDorm(HttpServletRequest request) {
		User userInfo = (User) request.getSession().getAttribute("userInfo");
//		不是管理员，也不是超管。直接返回无权限
		if (!(isAdmin(userInfo) || isBoss(userInfo))) {
			return Msg.insufficientPrivileges();
		}
		List<Dormitory> list=dormService.getDorm(userInfo.getFloorId());
		return Msg.success().add("dorm", list);
	}
}
