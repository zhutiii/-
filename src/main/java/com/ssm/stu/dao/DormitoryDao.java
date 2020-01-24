package com.ssm.stu.dao;


import com.ssm.stu.bean.newBean.Dormitory;
import com.ssm.stu.bean.newBean.DormitoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DormitoryDao {
    long countByExample(DormitoryExample example);

    int deleteByExample(DormitoryExample example);

    int deleteByPrimaryKey(Integer dormitoryId);

    int insert(Dormitory record);

    int insertSelective(Dormitory record);

    List<Dormitory> selectByExample(DormitoryExample example);

    Dormitory selectByPrimaryKey(Integer dormitoryId);

    int updateByExampleSelective(@Param("record") Dormitory record, @Param("example") DormitoryExample example);

    int updateByExample(@Param("record") Dormitory record, @Param("example") DormitoryExample example);

    int updateByPrimaryKeySelective(Dormitory record);

    int updateByPrimaryKey(Dormitory record);

    List<Dormitory> selectDormitoryListByFloorIds(@Param("ids") String ids);
}