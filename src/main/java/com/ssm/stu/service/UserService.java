package com.ssm.stu.service;

import com.ssm.stu.bean.newBean.Dormitory;
import com.ssm.stu.bean.newBean.User;
import com.ssm.stu.dao.DormitoryDao;
import com.ssm.stu.dao.FloorDao;
import com.ssm.stu.dao.UserDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName:UserService
 * Function:用户操作service
 * Reason:
 *
 */
@Service
public class UserService extends BaseService {

    @Autowired
    UserDao userDao;

    @Autowired
    FloorDao floorDao;

    @Autowired
    DormitoryDao dormitoryDao;
    /**
     * 通过账号获取用户信息
     * @param username
     * @param userType
     * @return
     */
    public User getUserInfoByUsername(String username, Integer userType) {
        return userDao.selectUserInfoByUsername(username,userType);
    }

    /**
     * 通过账号获取用户信息
     * @return
     */
    public List<User> getUserInfoPaging(String floorId,Boolean b) {
        //无楼层返回空数组
        if (floorId == null && b) {
            return new ArrayList<>(1);
        } else if (floorId == null && b){
            return userDao.getUserInfoPaging(null);
        }
        return userDao.getUserInfoPaging(listToMysqlInString(Arrays.asList(floorId.split(","))));
    }

    public boolean checkStuNum(Integer stuNum) {
        int num = userDao.checkStuNum(stuNum);
        return num == 0;

    }

    public int insert(User user) {
        Dormitory dormitory = dormitoryDao.selectByPrimaryKey(Integer.parseInt(user.getDormitoryId()));
        user.setFloorId(dormitory.getFloorId().toString());
        return userDao.insertSelective(user);
    }

    public int updateByPrimaryKeySelective(User user) {
        Dormitory dormitory = dormitoryDao.selectByPrimaryKey(Integer.parseInt(user.getDormitoryId()));
        user.setFloorId(dormitory.getFloorId().toString());
        return userDao.updateByPrimaryKeySelective(user);
    }

    public User selectAdminInfoByFloorId(String id) {
        return userDao.selectAdminInfoByFloorId(id);
    }
}
