package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ClusterHistory;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2021-05-12
 */
public interface IClusterHistoryService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ClusterHistory selectClusterHistoryById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param clusterHistory 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ClusterHistory> selectClusterHistoryList(ClusterHistory clusterHistory);

    /**
     * 新增【请填写功能名称】
     * 
     * @param clusterHistory 【请填写功能名称】
     * @return 结果
     */
    public int insertClusterHistory(ClusterHistory clusterHistory);

    /**
     * 修改【请填写功能名称】
     * 
     * @param clusterHistory 【请填写功能名称】
     * @return 结果
     */
    public int updateClusterHistory(ClusterHistory clusterHistory);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteClusterHistoryByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteClusterHistoryById(Long id);
}
