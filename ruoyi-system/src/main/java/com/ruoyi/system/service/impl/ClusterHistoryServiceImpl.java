package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ClusterHistoryMapper;
import com.ruoyi.system.domain.ClusterHistory;
import com.ruoyi.system.service.IClusterHistoryService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-12
 */
@Service
public class ClusterHistoryServiceImpl implements IClusterHistoryService 
{
    @Autowired
    private ClusterHistoryMapper clusterHistoryMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ClusterHistory selectClusterHistoryById(Long id)
    {
        return clusterHistoryMapper.selectClusterHistoryById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param clusterHistory 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ClusterHistory> selectClusterHistoryList(ClusterHistory clusterHistory)
    {
        return clusterHistoryMapper.selectClusterHistoryList(clusterHistory);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param clusterHistory 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertClusterHistory(ClusterHistory clusterHistory)
    {
        return clusterHistoryMapper.insertClusterHistory(clusterHistory);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param clusterHistory 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateClusterHistory(ClusterHistory clusterHistory)
    {
        return clusterHistoryMapper.updateClusterHistory(clusterHistory);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteClusterHistoryByIds(String ids)
    {
        return clusterHistoryMapper.deleteClusterHistoryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteClusterHistoryById(Long id)
    {
        return clusterHistoryMapper.deleteClusterHistoryById(id);
    }
}
