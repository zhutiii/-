package com.ssm.stu.dao;

import com.ssm.stu.bean.Dorm;
import com.ssm.stu.bean.DormExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DormMapper {
    long countByExample(DormExample example);

    int deleteByExample(DormExample example);

    int deleteByPrimaryKey(Integer dormId);

    int insert(Dorm record);

    int insertSelective(Dorm record);

    List<Dorm> selectByExample(DormExample example);

    Dorm selectByPrimaryKey(Integer dormId);

    int updateByExampleSelective(@Param("record") Dorm record, @Param("example") DormExample example);

    int updateByExample(@Param("record") Dorm record, @Param("example") DormExample example);

    int updateByPrimaryKeySelective(Dorm record);

    int updateByPrimaryKey(Dorm record);
}