package com.ssm.stu.bean.newBean;

import java.io.Serializable;

/**
 * dormitory
 * @author 
 */
public class Dormitory implements Serializable {
    private Integer dormitoryId;

    /**
     * 宿舍名字
     */
    private String dormitoryName;

    /**
     * 楼层id
     */
    private Integer floorId;

    /**
     * 状态  0无效  1有效
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(Integer dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public String getDormitoryName() {
        return dormitoryName;
    }

    public void setDormitoryName(String dormitoryName) {
        this.dormitoryName = dormitoryName;
    }

    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        Dormitory other = (Dormitory) that;
        return (this.getDormitoryId() == null ? other.getDormitoryId() == null : this.getDormitoryId().equals(other.getDormitoryId()))
            && (this.getDormitoryName() == null ? other.getDormitoryName() == null : this.getDormitoryName().equals(other.getDormitoryName()))
            && (this.getFloorId() == null ? other.getFloorId() == null : this.getFloorId().equals(other.getFloorId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDormitoryId() == null) ? 0 : getDormitoryId().hashCode());
        result = prime * result + ((getDormitoryName() == null) ? 0 : getDormitoryName().hashCode());
        result = prime * result + ((getFloorId() == null) ? 0 : getFloorId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dormitoryId=").append(dormitoryId);
        sb.append(", dormitoryName=").append(dormitoryName);
        sb.append(", floorId=").append(floorId);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}