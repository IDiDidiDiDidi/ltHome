package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.LdStepBeat;

/**
 * 吃什么——步揍Service接口
 * 
 * @author ruoyi
 * @date 2022-09-23
 */
public interface ILdStepBeatService 
{
    /**
     * 查询吃什么——步揍
     * 
     * @param id 吃什么——步揍主键
     * @return 吃什么——步揍
     */
    public LdStepBeat selectLdStepBeatById(Long id);

    /**
     * 查询吃什么——步揍列表
     * 
     * @param ldStepBeat 吃什么——步揍
     * @return 吃什么——步揍集合
     */
    public List<LdStepBeat> selectLdStepBeatList(LdStepBeat ldStepBeat);

    /**
     * 新增吃什么——步揍
     * 
     * @param ldStepBeat 吃什么——步揍
     * @return 结果
     */
    public int insertLdStepBeat(LdStepBeat ldStepBeat);

    /**
     * 修改吃什么——步揍
     * 
     * @param ldStepBeat 吃什么——步揍
     * @return 结果
     */
    public int updateLdStepBeat(LdStepBeat ldStepBeat);

    /**
     * 批量删除吃什么——步揍
     * 
     * @param ids 需要删除的吃什么——步揍主键集合
     * @return 结果
     */
    public int deleteLdStepBeatByIds(Long[] ids);

    /**
     * 删除吃什么——步揍信息
     * 
     * @param id 吃什么——步揍主键
     * @return 结果
     */
    public int deleteLdStepBeatById(Long id);
}
