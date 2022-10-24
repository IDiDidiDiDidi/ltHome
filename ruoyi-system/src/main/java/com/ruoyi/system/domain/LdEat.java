package com.ruoyi.system.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 吃什么对象 ld_eat
 *
 * @author ruoyi
 * @date 2022-09-23
 */
@Data
public class LdEat extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 菜名
     */
    @Excel(name = "菜名")
    private String name;

    /**
     * 标签baseId（甜口、辣口）
     */
    @Excel(name = "标签baseId", readConverterExp = "甜=口、辣口")
    private String tag;

    /**
     * tagName
     */
    @Excel(name = "tagName")
    private String tagName;

    /**
     * 次数
     */
    @Excel(name = "次数")
    private Long doItNum;

    /**
     * 用料baseId
     */
    @Excel(name = "用料baseId")
    private Long materialId;

    /**
     * 步揍baseId
     */
    @Excel(name = "步揍baseId")
    private Long stepBeatId;

    /**
     * 描述
     */
    @Excel(name = "描述")
    private String description;

    /**
     * 展示图
     */
    @Excel(name = "展示图")
    private String displayPicture;

    /**
     * 小贴士
     */
    @Excel(name = "小贴士")
    private String tips;

    /**
     * 评分5分制
     */
    @Excel(name = "评分5分制")
    private Long grade;

    /**
     * 点赞
     */
    @Excel(name = "点赞")
    private Long zan;

    /**
     * 状态（0正常 1停用）
     */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;
}
