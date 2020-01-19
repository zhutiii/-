package com.ssm.stu.bean;

public class Dorm {
    private Integer dormId;

    private Integer dormNum;

    public Dorm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dorm(Integer dormId, Integer dormNum) {
		super();
		this.dormId = dormId;
		this.dormNum = dormNum;
	}

	public Integer getDormId() {
        return dormId;
    }

    public void setDormId(Integer dormId) {
        this.dormId = dormId;
    }

    public Integer getDormNum() {
        return dormNum;
    }

    public void setDormNum(Integer dormNum) {
        this.dormNum = dormNum;
    }
}