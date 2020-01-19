package com.ssm.stu.bean;

import javax.validation.constraints.Pattern;

public class Student {
    private Integer stuId;

    //后端校验规则
	/* @Pattern(regexp="^[1-9]\\d{9}$",message="学号请输入10位有效数字") */
    private Integer stuNum;
   // @Pattern(regexp="^[\\u2E80-\\u9FFF]{2,5}$",message="请输入正确姓名")
    private String stuName;

    private String gender;
    //@Pattern(regexp="^[\\u2E80-\\u9FFF]{3,10}\\d{0,2}$",message="请输入正确班级")
    private String classname;
    //@Pattern(regexp="^[\\u2E80-\\u9FFF]{3,10}$",message="请输入正确学院")
    private String college;

    private Integer dId;
    
    private Dorm dorm;
    

    public Student() {
		super();
	}

	public Student(Integer stuId, Integer stuNum, String stuName, String gender, String classname, String college,
			Integer dId) {
		super();
		this.stuId = stuId;
		this.stuNum = stuNum;
		this.stuName = stuName;
		this.gender = gender;
		this.classname = classname;
		this.college = college;
		this.dId = dId;
	}

	public Dorm getDorm() {
		return dorm;
	}

	public void setDorm(Dorm dorm) {
		this.dorm = dorm;
	}

	public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Integer getStuNum() {
        return stuNum;
    }

    public void setStuNum(Integer stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }
}