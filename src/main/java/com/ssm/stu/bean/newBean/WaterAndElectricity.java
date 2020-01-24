package com.ssm.stu.bean.newBean;

import java.io.Serializable;
import java.util.Date;

/**
 * water_and_electricity
 * @author 
 */
public class WaterAndElectricity implements Serializable {
    private Integer waterElectricityId;

    /**
     * 使用的度数
     */
    private Float amount;

    /**
     * 宿舍id
     */
    private Integer dormitoryId;

    /**
     * 类型  0用水   1用电
     */
    private Integer type;

    /**
     * 状态  0/无效  1/有效
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getWaterElectricityId() {
        return waterElectricityId;
    }

    public void setWaterElectricityId(Integer waterElectricityId) {
        this.waterElectricityId = waterElectricityId;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Integer getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(Integer dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        WaterAndElectricity other = (WaterAndElectricity) that;
        return (this.getWaterElectricityId() == null ? other.getWaterElectricityId() == null : this.getWaterElectricityId().equals(other.getWaterElectricityId()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getDormitoryId() == null ? other.getDormitoryId() == null : this.getDormitoryId().equals(other.getDormitoryId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWaterElectricityId() == null) ? 0 : getWaterElectricityId().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getDormitoryId() == null) ? 0 : getDormitoryId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", waterElectricityId=").append(waterElectricityId);
        sb.append(", amount=").append(amount);
        sb.append(", dormitoryId=").append(dormitoryId);
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}