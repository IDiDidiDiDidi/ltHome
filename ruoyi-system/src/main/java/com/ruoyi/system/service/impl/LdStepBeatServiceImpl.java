package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.LdStepBeatMapper;
import com.ruoyi.system.domain.LdStepBeat;
import com.ruoyi.system.service.ILdStepBeatService;

/**
 * 吃什么——步揍Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-23
 */
@Service
public class LdStepBeatServiceImpl implements ILdStepBeatService 
{
    @Autowired
    private LdStepBeatMapper ldStepBeatMapper;

    /**
     * 查询吃什么——步揍
     * 
     * @param id 吃什么——步揍主键
     * @return 吃什么——步揍
     */
    @Override
    public LdStepBeat selectLdStepBeatById(Long id)
    {
        return ldStepBeatMapper.selectLdStepBeatById(id);
    }

    /**
     * 查询吃什么——步揍列表
     * 
     * @param ldStepBeat 吃什么——步揍
     * @return 吃什么——步揍
     */
    @Override
    public List<LdStepBeat> selectLdStepBeatList(LdStepBeat ldStepBeat)
    {
        return ldStepBeatMapper.selectLdStepBeatList(ldStepBeat);
    }

    /**
     * 新增吃什么——步揍
     * 
     * @param ldStepBeat 吃什么——步揍
     * @return 结果
     */
    @Override
    public int insertLdStepBeat(LdStepBeat ldStepBeat)
    {
        ldStepBeat.setCreateTime(DateUtils.getNowDate());
        return ldStepBeatMapper.insertLdStepBeat(ldStepBeat);
    }

    /**
     * 修改吃什么——步揍
     * 
     * @param ldStepBeat 吃什么——步揍
     * @return 结果
     */
    @Override
    public int updateLdStepBeat(LdStepBeat ldStepBeat)
    {
        ldStepBeat.setUpdateTime(DateUtils.getNowDate());
        return ldStepBeatMapper.updateLdStepBeat(ldStepBeat);
    }

    /**
     * 批量删除吃什么——步揍
     * 
     * @param ids 需要删除的吃什么——步揍主键
     * @return 结果
     */
    @Override
    public int deleteLdStepBeatByIds(Long[] ids)
    {
        return ldStepBeatMapper.deleteLdStepBeatByIds(ids);
    }

    /**
     * 删除吃什么——步揍信息
     * 
     * @param id 吃什么——步揍主键
     * @return 结果
     */
    @Override
    public int deleteLdStepBeatById(Long id)
    {
        return ldStepBeatMapper.deleteLdStepBeatById(id);
    }
}
