package com.ruoyi.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.ClusterHistory;
import com.ruoyi.system.service.IClusterHistoryService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2021-05-12
 */
@Controller
@RequestMapping("/system/history")
public class ClusterHistoryController extends BaseController
{
    private String prefix = "system/history";

    @Autowired
    private IClusterHistoryService clusterHistoryService;

    @GetMapping()
    public String history()
    {
        return prefix + "/history";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ClusterHistory clusterHistory)
    {
        startPage();
        List<ClusterHistory> list = clusterHistoryService.selectClusterHistoryList(clusterHistory);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @Log(title = "选中数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ClusterHistory clusterHistory)
    {
        List<ClusterHistory> list = clusterHistoryService.selectClusterHistoryList(clusterHistory);
        ExcelUtil<ClusterHistory> util = new ExcelUtil<ClusterHistory>(ClusterHistory.class);
        return util.exportExcel(list, "选中的历史数据");
    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ClusterHistory clusterHistory)
    {
        return toAjax(clusterHistoryService.insertClusterHistory(clusterHistory));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ClusterHistory clusterHistory = clusterHistoryService.selectClusterHistoryById(id);
        mmap.put("clusterHistory", clusterHistory);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ClusterHistory clusterHistory)
    {
        return toAjax(clusterHistoryService.updateClusterHistory(clusterHistory));
    }

    /**
     * 删除【请填写功能名称】
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(clusterHistoryService.deleteClusterHistoryByIds(ids));
    }
}
