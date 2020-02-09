/**
 * Copyright (C), 2009-2020, JoeyZhou个人所有
 * FileName: IndicatorResult
 * Author:   Joey
 * Date:     1/7/2020 10:53 PM
 * Description: Excel对象
 * History:
 * <author>          <time>          <version>          <desc>
 * Joey       1/7/2020 10:53 PM        1.0          Excel对象
 */
package com.joey.auto.test.po.excelobject;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * 〈功能简述〉<br>
 * 〈Excel对象〉
 *
 * @author Joey
 * @create 1/7/2020
 * @since 1.0.0
 */
public class IndicatorResult {
    @Excel(name = "顶部菜单名称", width = 30)
    private String topbarMenuName;

    @Excel(name = "左侧一级菜单名称", width = 30)
    private String leftMenuName;

    @Excel(name = "左侧二级菜单名称", width = 30)
    private String leftMidMenuName;

    @Excel(name = "菜单标题名称", width = 30)
    private String menuTitleName;

    @Excel(name = "指标名称", width = 30)
    private String indicatorLinkName;

    public String getTopbarMenuName() {
        return topbarMenuName;
    }

    public void setTopbarMenuName(String topbarMenuName) {
        this.topbarMenuName = topbarMenuName;
    }

    public String getLeftMenuName() {
        return leftMenuName;
    }

    public void setLeftMenuName(String leftMenuName) {
        this.leftMenuName = leftMenuName;
    }

    public String getLeftMidMenuName() {
        return leftMidMenuName;
    }

    public void setLeftMidMenuName(String leftMidMenuName) {
        this.leftMidMenuName = leftMidMenuName;
    }

    public String getMenuTitleName() {
        return menuTitleName;
    }

    public void setMenuTitleName(String menuTitleName) {
        this.menuTitleName = menuTitleName;
    }

    public String getIndicatorLinkName() {
        return indicatorLinkName;
    }

    public void setIndicatorLinkName(String indicatorLinkName) {
        this.indicatorLinkName = indicatorLinkName;
    }

}