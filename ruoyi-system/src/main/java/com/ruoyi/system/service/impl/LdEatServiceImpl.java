package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.Objects;

import cn.hutool.core.bean.BeanUtil;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.LdMaterial;
import com.ruoyi.system.domain.LdStepBeat;
import com.ruoyi.system.domain.vo.LdEatVo;
import com.ruoyi.system.mapper.LdMaterialMapper;
import com.ruoyi.system.mapper.LdStepBeatMapper;
import com.ruoyi.system.mapper.SysDictDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.LdEatMapper;
import com.ruoyi.system.domain.LdEat;
import com.ruoyi.system.service.ILdEatService;

/**
 * 吃什么Service业务层处理
 *
 * @author ruoyi
 * @date 2022-09-23
 */
@Service
public class LdEatServiceImpl implements ILdEatService {
    @Autowired
    private LdEatMapper ldEatMapper;

    @Autowired
    private LdMaterialMapper materialMapper;

    @Autowired
    private LdStepBeatMapper stepBeatMapper;

    @Autowired
    private SysDictDataMapper dictDataMapper;


    /**
     * 查询吃什么
     *
     * @param id 吃什么主键
     * @return 吃什么
     */
    @Override
    public LdEat selectLdEatById(Long id) {
        return ldEatMapper.selectLdEatById(id);
    }

    /**
     * 查询吃什么列表
     *
     * @param ldEat 吃什么
     * @return 吃什么
     */
    @Override
    public List<LdEat> selectLdEatList(LdEat ldEat) {
        List<LdEat> ldEats = ldEatMapper.selectLdEatList(ldEat);
        ldEats.forEach(e -> {
            String tag = e.getTag();
            if (StringUtils.isNotBlank(tag)){
                String[] split = tag.split(",");
                List<String> tagNameList = dictDataMapper.getDictLabel(split);
                if (tagNameList != null && tagNameList.size() > 0) {
                    e.setTagName(tagNameList.toString().replace("[", "").replace("]", ""));
                }
            }
        });

        return ldEats;
    }

    /**
     * 新增吃什么
     *
     * @param ldEat 吃什么
     * @return 结果
     */
    @Override
    public int insertLdEat(LdEat ldEat) {
        ldEat.setCreateTime(DateUtils.getNowDate());
        return ldEatMapper.insertLdEat(ldEat);
    }

    /**
     * 修改吃什么
     *
     * @param ldEat 吃什么
     * @return 结果
     */
    @Override
    public int updateLdEat(LdEat ldEat) {
        ldEat.setUpdateTime(DateUtils.getNowDate());
        return ldEatMapper.updateLdEat(ldEat);
    }

    /**
     * 批量删除吃什么
     *
     * @param ids 需要删除的吃什么主键
     * @return 结果
     */
    @Override
    public int deleteLdEatByIds(Long[] ids) {
        return ldEatMapper.deleteLdEatByIds(ids);
    }

    /**
     * 删除吃什么信息
     *
     * @param id 吃什么主键
     * @return 结果
     */
    @Override
    public int deleteLdEatById(Long id) {
        return ldEatMapper.deleteLdEatById(id);
    }

    @Override
    public LdEatVo getDetail(Long id) {
        LdEat ldEat = ldEatMapper.selectLdEatById(id);
        // material
        List<LdMaterial> materials = materialMapper.getEatMaterial(id);
        // step beat
        List<LdStepBeat> stepBeats = stepBeatMapper.getEatStepBeat(id);
        LdEatVo ldEatVo = BeanUtil.copyProperties(ldEat, LdEatVo.class);
        ldEatVo.setLdMaterials(materials);
        ldEatVo.setLdStepBeats(stepBeats);
        return ldEatVo;
    }
}
