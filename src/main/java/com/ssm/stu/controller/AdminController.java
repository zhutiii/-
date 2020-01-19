package com.ssm.stu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ssm.stu.bean.Admin;
import com.ssm.stu.bean.Msg;
import com.ssm.stu.service.AdminService;

@SessionAttributes("admin")
@Controller
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@ResponseBody
	@RequestMapping(value="/adminlog",method=RequestMethod.POST)
	public Msg adminlog(String adminName,String adminPwd) {
		Admin admin=adminService.adminlog(adminName);
		if(admin!=null&&admin.getAdminPwd().equals(adminPwd)) {
			return Msg.success();
		}else {
			return (admin == null)?Msg.fail().add("error", "用户不存在！"):Msg.fail().add("error", "密码不正确！");
		}
		
	}
	
	@RequestMapping("/logout")
    public String outLogin(HttpSession session,HttpServletRequest request,HttpServletResponse response,SessionStatus sessionStatus){
        //通过session.invalidata()方法来注销当前的session
		session.removeAttribute("admin");
        sessionStatus.setComplete();
        return "login";
    }
}
