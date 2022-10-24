package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.LdStepBeat;

/**
 * 吃什么——步揍Mapper接口
 * 
 * @author ruoyi
 * @date 2022-09-23
 */
public interface LdStepBeatMapper 
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
     * 删除吃什么——步揍
     * 
     * @param id 吃什么——步揍主键
     * @return 结果
     */
    public int deleteLdStepBeatById(Long id);

    /**
     * 批量删除吃什么——步揍
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLdStepBeatByIds(Long[] ids);

    /**
     * eat 步揍
     * @param id
     * @return
     */
    List<LdStepBeat> getEatStepBeat(Long id);
}
