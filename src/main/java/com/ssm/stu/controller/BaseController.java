package com.ssm.stu.controller;

import com.ssm.stu.bean.newBean.User;
import com.ssm.stu.common.Constant;

/**
 * ClassName:BaseController
 * Function:公共conroller
 * Reason:
 */
public class BaseController {

    /**
     * 判断是不是宿管
     * @param user
     * @return
     */
    protected Boolean isAdmin(User user){
        return user.getIsAdmin() == Constant.USER_TYPE_SUPERVISOR_OF_DORM;
    }

    /**
     * 判断是不是学生
     * @param user
     * @return
     */
    protected Boolean isStudent(User user){
        return user.getIsAdmin() == Constant.USER_TYPE_STUDENT;
    }

    /**
     * 判断是不是维修员
     * @param user
     * @return
     */
    protected Boolean isMaintainer(User user){
        return user.getIsAdmin() == Constant.USER_TYPE_MAINTAINER;
    }
}
