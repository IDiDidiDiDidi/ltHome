package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.system.domain.LdEat;
import com.ruoyi.system.domain.vo.LdEatVo;

/**
 * 吃什么Service接口
 *
 * @author ruoyi
 * @date 2022-09-23
 */
public interface ILdEatService {
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
     * 批量删除吃什么
     *
     * @param ids 需要删除的吃什么主键集合
     * @return 结果
     */
    public int deleteLdEatByIds(Long[] ids);

    /**
     * 删除吃什么信息
     *
     * @param id 吃什么主键
     * @return 结果
     */
    public int deleteLdEatById(Long id);

    LdEatVo getDetail(Long id);
}
