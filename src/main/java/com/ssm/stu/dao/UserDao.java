package com.ssm.stu.dao;

import com.ssm.stu.bean.newBean.User;
import com.ssm.stu.bean.newBean.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectAdminInfoByFloorId(@Param("floorId") String id);
    /**
     * 通过用户名获取用户信息
     * @param username
     * @return
     */
    User selectUserInfoByUsername(@Param("username") String username,@Param("userType") Integer userType);

    /**
     * 分页获取数据
     * @param floorId
     * @return
     */
    List<User> getUserInfoPaging(@Param("ids") String floorId);

    int deleteByPrimaryKeys(@Param("ids") String ids);

    int checkStuNum(Integer stuNum);
}