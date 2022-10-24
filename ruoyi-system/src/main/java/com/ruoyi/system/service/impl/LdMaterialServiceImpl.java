package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.LdMaterialMapper;
import com.ruoyi.system.domain.LdMaterial;
import com.ruoyi.system.service.ILdMaterialService;

/**
 * 吃什么——用料Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-23
 */
@Service
public class LdMaterialServiceImpl implements ILdMaterialService 
{
    @Autowired
    private LdMaterialMapper ldMaterialMapper;

    /**
     * 查询吃什么——用料
     * 
     * @param id 吃什么——用料主键
     * @return 吃什么——用料
     */
    @Override
    public LdMaterial selectLdMaterialById(Long id)
    {
        return ldMaterialMapper.selectLdMaterialById(id);
    }

    /**
     * 查询吃什么——用料列表
     * 
     * @param ldMaterial 吃什么——用料
     * @return 吃什么——用料
     */
    @Override
    public List<LdMaterial> selectLdMaterialList(LdMaterial ldMaterial)
    {
        return ldMaterialMapper.selectLdMaterialList(ldMaterial);
    }

    /**
     * 新增吃什么——用料
     * 
     * @param ldMaterial 吃什么——用料
     * @return 结果
     */
    @Override
    public int insertLdMaterial(LdMaterial ldMaterial)
    {
        ldMaterial.setCreateTime(DateUtils.getNowDate());
        return ldMaterialMapper.insertLdMaterial(ldMaterial);
    }

    /**
     * 修改吃什么——用料
     * 
     * @param ldMaterial 吃什么——用料
     * @return 结果
     */
    @Override
    public int updateLdMaterial(LdMaterial ldMaterial)
    {
        ldMaterial.setUpdateTime(DateUtils.getNowDate());
        return ldMaterialMapper.updateLdMaterial(ldMaterial);
    }

    /**
     * 批量删除吃什么——用料
     * 
     * @param ids 需要删除的吃什么——用料主键
     * @return 结果
     */
    @Override
    public int deleteLdMaterialByIds(Long[] ids)
    {
        return ldMaterialMapper.deleteLdMaterialByIds(ids);
    }

    /**
     * 删除吃什么——用料信息
     * 
     * @param id 吃什么——用料主键
     * @return 结果
     */
    @Override
    public int deleteLdMaterialById(Long id)
    {
        return ldMaterialMapper.deleteLdMaterialById(id);
    }
}
