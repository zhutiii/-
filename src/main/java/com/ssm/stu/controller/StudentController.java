package com.ssm.stu.controller;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

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
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	//删除 即可单个id删 也可批量删
	@ResponseBody
	@RequestMapping(value="/stus/{ids}",method=RequestMethod.DELETE)
	public Msg deleteStu(@PathVariable("ids")String ids) {
		if(ids.contains("-")) {
			List<Integer> del_ids=new ArrayList<>();
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
	public Msg updateStu(Student student) {
		studentService.updateStu(student);
		return Msg.success();
	}
	
	//查询所有学生信息
	@RequestMapping(value="/stus/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getStu(@PathVariable("id")Integer id) {
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
		boolean b=studentService.checkStuNum(stuNum);
		
		if(b) {
			return Msg.success();
		}else {
			return Msg.fail().add("va_msg", "此学号已存在");
		}
	}
	
//	学生信息保存
	@RequestMapping(value="/stus",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveStu(Student student) {	
			studentService.saveStu(student);
			return Msg.success();			
	}
	
//	显示分页信息
	@RequestMapping("/stu")
	@ResponseBody
	public Msg getStuWithJson(@RequestParam(value="pn",defaultValue="1")Integer pn) {
		PageHelper.startPage(pn,5);
		List<Student> stu=studentService.getAll();
		PageInfo page=new PageInfo(stu,5);
		return Msg.success().add("pageInfo",page);
	}
	
}
