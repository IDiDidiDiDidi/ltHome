package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.LdMaterial;

/**
 * 吃什么——用料Mapper接口
 *
 * @author ruoyi
 * @date 2022-09-23
 */
public interface LdMaterialMapper {
    /**
     * 查询吃什么——用料
     *
     * @param id 吃什么——用料主键
     * @return 吃什么——用料
     */
    public LdMaterial selectLdMaterialById(Long id);

    /**
     * 查询吃什么——用料列表
     *
     * @param ldMaterial 吃什么——用料
     * @return 吃什么——用料集合
     */
    public List<LdMaterial> selectLdMaterialList(LdMaterial ldMaterial);

    /**
     * 新增吃什么——用料
     *
     * @param ldMaterial 吃什么——用料
     * @return 结果
     */
    public int insertLdMaterial(LdMaterial ldMaterial);

    /**
     * 修改吃什么——用料
     *
     * @param ldMaterial 吃什么——用料
     * @return 结果
     */
    public int updateLdMaterial(LdMaterial ldMaterial);

    /**
     * 删除吃什么——用料
     *
     * @param id 吃什么——用料主键
     * @return 结果
     */
    public int deleteLdMaterialById(Long id);

    /**
     * 批量删除吃什么——用料
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLdMaterialByIds(Long[] ids);

    /**
     * eat 用料
     * @param id
     * @return
     */
    List<LdMaterial> getEatMaterial(Long id);
}
