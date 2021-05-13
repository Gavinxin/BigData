package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 cluster_history
 * 
 * @author ruoyi
 * @date 2021-05-12
 */
public class ClusterHistory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${经度}", readConverterExp = "$column.readConverterExp()")
    private Double lat;

    /** $column.columnComment */
    @Excel(name = "${纬度}", readConverterExp = "$column.readConverterExp()")
    private Double lon;

    /** $column.columnComment */
    @Excel(name = "${拥挤指数}", readConverterExp = "$column.readConverterExp()")
    private Long cnt;

    /** $column.columnComment */
    @Excel(name = "${时间}", readConverterExp = "$column.readConverterExp()")
    private Date time;

    /** $column.columnComment */
    @Excel(name = "${道路名称}", readConverterExp = "$column.readConverterExp()")
    private String name;

    private Date startTime;
    private Date endTime;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setLat(Double lat)
    {
        this.lat = lat;
    }

    public Double getLat()
    {
        return lat;
    }
    public void setLon(Double lon)
    {
        this.lon = lon;
    }


    public Double getLon()
    {
        return lon;
    }
    public void setCnt(Long cnt) 
    {
        this.cnt = cnt;
    }

    public Long getCnt() 
    {
        return cnt;
    }
    public void setTime(Date time) 
    {
        this.time = time;
    }

    public Date getTime() 
    {
        return time;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("lat", getLat())
            .append("lon", getLon())
            .append("cnt", getCnt())
            .append("time", getTime())
            .append("name", getName())
            .toString();
    }

}
