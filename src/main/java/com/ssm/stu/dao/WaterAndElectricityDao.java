package com.ssm.stu.dao;

import com.ssm.stu.bean.newBean.WaterAndElectricity;
import com.ssm.stu.bean.newBean.WaterAndElectricityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WaterAndElectricityDao {
    long countByExample(WaterAndElectricityExample example);

    int deleteByExample(WaterAndElectricityExample example);

    int deleteByPrimaryKey(Integer waterElectricityId);

    int insert(WaterAndElectricity record);

    int insertSelective(WaterAndElectricity record);

    List<WaterAndElectricity> selectByExample(WaterAndElectricityExample example);

    WaterAndElectricity selectByPrimaryKey(Integer waterElectricityId);

    int updateByExampleSelective(@Param("record") WaterAndElectricity record, @Param("example") WaterAndElectricityExample example);

    int updateByExample(@Param("record") WaterAndElectricity record, @Param("example") WaterAndElectricityExample example);

    int updateByPrimaryKeySelective(WaterAndElectricity record);

    int updateByPrimaryKey(WaterAndElectricity record);
}