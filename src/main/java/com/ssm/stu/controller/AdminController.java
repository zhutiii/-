package com.ssm.stu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssm.stu.bean.newBean.User;
import com.ssm.stu.common.Constant;
import com.ssm.stu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import com.ssm.stu.bean.Admin;
import com.ssm.stu.bean.Msg;
import com.ssm.stu.service.AdminService;

@SessionAttributes("/admin")
@Controller
public class AdminController extends BaseController {

	@Autowired
	AdminService adminService;

	@Autowired
	UserService userService;
/*	@ResponseBody
	@RequestMapping(value="/adminlog",method=RequestMethod.POST)
	public Msg adminlog(HttpServletRequest request,String adminName,String adminPwd) {
		Admin admin=adminService.adminlog(adminName);
		if(admin!=null&&admin.getAdminPwd().equals(adminPwd)) {
			request.getSession().setAttribute("userInfo",admin);
			return Msg.success();
		}else {
			return (admin == null)?Msg.fail().add("error", "用户不存在！"):Msg.fail().add("error", "密码不正确！");
		}

	}*/

	@ResponseBody
	@RequestMapping(value="/adminlog",method=RequestMethod.POST)
	public Msg adminlog(HttpServletRequest request,String adminName,String adminPwd) {
		User user = userService.getUserInfoByUsername(adminName, Constant.USER_TYPE_SUPERVISOR_OF_DORM);
		if(user != null && user.getPassword().equals(adminPwd)) {
			request.getSession().setAttribute("userInfo",user);
			return Msg.success();
		}else {
			return (user == null)?Msg.fail().add("error", "用户不存在！"):Msg.fail().add("error", "密码不正确！");
		}

	}

	@ResponseBody
	@RequestMapping(value="/studentLogin",method=RequestMethod.POST)
	public Msg studentLogin(HttpServletRequest request,String adminName,String adminPwd) {
		User user = userService.getUserInfoByUsername(adminName, Constant.USER_TYPE_STUDENT);
		if(user != null && user.getPassword().equals(adminPwd)) {
			request.getSession().setAttribute("userInfo",user);
			return Msg.success();
		}else {
			return (user == null)?Msg.fail().add("error", "用户不存在！"):Msg.fail().add("error", "密码不正确！");
		}

	}

	@ResponseBody
	@RequestMapping(value="/maintainerLogin",method=RequestMethod.POST)
	public Msg maintainerLogin(HttpServletRequest request,String adminName,String adminPwd) {
		User user = userService.getUserInfoByUsername(adminName, Constant.USER_TYPE_MAINTAINER);
		if(user != null && user.getPassword().equals(adminPwd)) {
			request.getSession().setAttribute("userInfo",user);
			return Msg.success();
		}else {
			return (user == null)?Msg.fail().add("error", "用户不存在！"):Msg.fail().add("error", "密码不正确！");
		}

	}

	@RequestMapping("/logout")
    public String outLogin(HttpSession session,HttpServletRequest request,HttpServletResponse response,SessionStatus sessionStatus){
        //通过session.invalidata()方法来注销当前的session
		session.removeAttribute("admin");
		session.removeAttribute("userInfo");
        sessionStatus.setComplete();
        return "login";
    }
}
