package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.LdEat;

/**
 * 吃什么Mapper接口
 * 
 * @author ruoyi
 * @date 2022-09-23
 */
public interface LdEatMapper 
{
    /**
     * 查询吃什么
     * 
     * @param id 吃什么主键
     * @return 吃什么
     */
    public LdEat selectLdEatById(Long id);

    /**
     * 查询吃什么列表
     * 
     * @param ldEat 吃什么
     * @return 吃什么集合
     */
    public List<LdEat> selectLdEatList(LdEat ldEat);

    /**
     * 新增吃什么
     * 
     * @param ldEat 吃什么
     * @return 结果
     */
    public int insertLdEat(LdEat ldEat);

    /**
     * 修改吃什么
     * 
     * @param ldEat 吃什么
     * @return 结果
     */
    public int updateLdEat(LdEat ldEat);

    /**
     * 删除吃什么
     * 
     * @param id 吃什么主键
     * @return 结果
     */
    public int deleteLdEatById(Long id);

    /**
     * 批量删除吃什么
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLdEatByIds(Long[] ids);
}
