package com.ssm.stu.controller;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.ssm.stu.bean.newBean.User;
import com.ssm.stu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.stu.bean.Msg;
import com.ssm.stu.bean.Student;
import com.ssm.stu.service.StudentService;

@Controller
public class StudentController extends BaseController {
	
	@Autowired
	StudentService studentService;

	@Autowired
	UserService userService;


	//删除 即可单个id删 也可批量删
	@ResponseBody
	@RequestMapping(value="/stus/{ids}",method=RequestMethod.DELETE)
	public Msg deleteStu(HttpServletRequest request,@PathVariable("ids")String ids) {
		User userInfo = (User) request.getSession().getAttribute("userInfo");
//		不是管理员，也不是超管。直接返回无权限
		if (!(isAdmin(userInfo) || isBoss(userInfo))) {
			return Msg.insufficientPrivileges();
		}
		if(ids.contains("-")) {
			List<Integer> del_ids=new ArrayList<Integer>();
			String[] str_ids=ids.split("-");
			for(String string:str_ids) {
				del_ids.add(Integer.parseInt(string));
			}
			studentService.deleteBatch(del_ids);
		}else {
			Integer id =Integer.parseInt(ids);
			studentService.deleteStu(id);			
		}

		return Msg.success();
	}
	
	//保存更新信息
	@ResponseBody
	@RequestMapping(value="/stus/{stuId}",method=RequestMethod.PUT)
	public Msg updateStu(HttpServletRequest request,User user) {
		User userInfo = (User) request.getSession().getAttribute("userInfo");
//		不是管理员，也不是超管。直接返回无权限
		if (!(isAdmin(userInfo) || isBoss(userInfo))) {
			return Msg.insufficientPrivileges();
		}
		userService.updateByPrimaryKeySelective(user);
		return Msg.success();
	}
	
	//查询所有学生信息
	@RequestMapping(value="/stus/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getStu(HttpServletRequest request,@PathVariable("id")Integer id) {
		User userInfo = (User) request.getSession().getAttribute("userInfo");
//		不是管理员，也不是超管。直接返回无权限
		if (!(isAdmin(userInfo) || isBoss(userInfo))) {
			return Msg.insufficientPrivileges();
		}
		Student student=studentService.getStu(id);
		return Msg.success().add("stu", student);
	}
	
//	检查学号是否重复
	@ResponseBody
	@RequestMapping("/checkstunum")
	public Msg checkstunum(Integer stuNum) {
		//判断学号是否合理
		String regx="^[1-9]\\d{9}$";
		String stuNum1=String.valueOf(stuNum);
		if(!stuNum1.matches(regx)) {
			return Msg.fail().add("va_msg","学号请输入10位有效数字");
		}

		//判断学号是否重复
		boolean b=userService.checkStuNum(stuNum);
		
		if(b) {
			return Msg.success();
		}else {
			return Msg.fail().add("va_msg", "此学号已存在");
		}
	}
	
//	学生信息保存
	@RequestMapping(value="/stus",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveStu(HttpServletRequest request,User user) {
		User userInfo = (User) request.getSession().getAttribute("userInfo");
//		不是管理员，也不是超管。直接返回无权限
		if (!(isAdmin(userInfo) || isBoss(userInfo))) {
			return Msg.insufficientPrivileges();
		}
		userService.insert(user);
		return Msg.success();
	}
	
//	显示分页信息
	@RequestMapping("/stu")
	@ResponseBody
	public Msg getStuWithJson(@RequestParam(value="pn",defaultValue="1")Integer pn, HttpServletRequest request) {
		User userInfo = (User) request.getSession().getAttribute("userInfo");
//		不是管理员，也不是超管。直接返回无权限
		if (!(isAdmin(userInfo) || isBoss(userInfo))) {
			return Msg.insufficientPrivileges();
		}
		PageHelper.startPage(pn,5);
		List<User> stu=userService.getUserInfoPaging(userInfo.getFloorId());
		PageInfo page=new PageInfo(stu,5);
		return Msg.success().add("pageInfo",page);
	}
	
}
