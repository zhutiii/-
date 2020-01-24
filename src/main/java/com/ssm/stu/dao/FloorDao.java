package com.ssm.stu.dao;


import com.ssm.stu.bean.newBean.Floor;
import com.ssm.stu.bean.newBean.FloorExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FloorDao {
    long countByExample(FloorExample example);

    int deleteByExample(FloorExample example);

    int deleteByPrimaryKey(Integer floorId);

    int insert(Floor record);

    int insertSelective(Floor record);

    List<Floor> selectByExample(FloorExample example);

    Floor selectByPrimaryKey(Integer floorId);

    int updateByExampleSelective(@Param("record") Floor record, @Param("example") FloorExample example);

    int updateByExample(@Param("record") Floor record, @Param("example") FloorExample example);

    int updateByPrimaryKeySelective(Floor record);

    int updateByPrimaryKey(Floor record);
}