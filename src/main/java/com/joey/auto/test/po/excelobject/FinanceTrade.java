/**
 * Copyright (C), 2009-2020, JoeyZhou个人所有
 * FileName: FinanceTrade
 * Author:   Joey
 * Date:     1/7/2020 11:02 PM
 * Description: 测试用的模板类
 * History:
 * <author>          <time>          <version>          <desc>
 * Joey       1/7/2020 11:02 PM        1.0          测试用的模板类
 */
package com.joey.auto.test.po.excelobject;

import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

/**
 * 〈功能简述〉<br>
 * 〈测试用的模板类〉
 *
 * @author Joey
 * @create 1/7/2020
 * @since 1.0.0
 */
@ExcelTarget("FinanceTrade")
/*
@TableName("rms_finance_trade")
*/
public class FinanceTrade /*extends Model<FinanceTrade>*/ {

   /* private static final long serialVersionUID = 1L;

    @TableId("trade_no")
    private String tradeNo;

    @Excel(name="订单号")
    @TableField("order_no")
    private String orderNo;
    *//**
     * 用户id
     *//*
    @TableField("user_id")
    private String userId;
    *//**
     * 交易创建时间
     *//*
    @Excel(name="创建时间",width=30)
    @TableField("create_time")
    private String createTime;
    *//**
     * 实际支付金额
     *//*
    @Excel(name="实际支付金额")
    private BigDecimal amount;
    *//**
     * 交易状态支付成功转入退款未支付已关闭已撤销支付失败
     *//*
    private String status;
    *//**
     * 流水标题
     *//*
    private String subject;

    @TableField("finish_time")
    private String finishTime;
    *//**
     * 类型：余额支付balance、微信支付wx
     *//*
    private String type;
    *//**
     * 资金流向：1：收入 ；0：支出
     *//*
    private String flows;
    *//**
     * 备注
     *//*
    private String remarks;


    *//**
     * 支付类型：余额，微信，混合支付等
     *//*
    @TableField(exist=false)
    @Excel(name="支付类型")
    private String payType;

    *//**
     * 费用名称
     *//*
    @TableField(exist=false)
    @Excel(name="费用名称")
    private String amountType;

    @TableField(exist=false)
    private String leafNode;

    @TableField(exist=false)
    private String address;

    @TableField(exist=false)
    private String node;

    @TableField(exist=false)
    private String subNode;

    @TableField(exist=false)
    @Excel(name="账户",width=30)
    public String loginCode;

    @TableField(exist=false)
    @Excel(name="支付人")
    public String userName;




    *//**
     * 公司编码
     * @return
     *//*
    @TableField(value="company_code")
    private String companyCode;

    *//**
     * 用户
     *//*
    @TableField(exist=false)
    List<SysUser> sysUser;

    *//**
     * 订单
     *//*
    @TableField(exist=false)
    List<FinanceOrder> order;

    public String getLoginCode() {
        return loginCode;
    }

    public void setLoginCode(String loginCode) {
        this.loginCode = loginCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLeafNode() {
        return leafNode;
    }

    public void setLeafNode(String leafNode) {
        this.leafNode = leafNode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getSubNode() {
        return subNode;
    }

    public void setSubNode(String subNode) {
        this.subNode = subNode;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getAmountType() {
        return amountType;
    }

    public void setAmountType(String amountType) {
        this.amountType = amountType;
    }


    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFlows() {
        return flows;
    }

    public void setFlows(String flows) {
        this.flows = flows;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    protected Serializable pkVal() {
        return this.tradeNo;
    }

    public List<SysUser> getSysUser() {
        return sysUser;
    }

    public void setSysUser(List<SysUser> sysUser) {
        this.sysUser = sysUser;
    }

    public List<FinanceOrder> getOrder() {
        return order;
    }

    public void setOrder(List<FinanceOrder> order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "FinanceTrade [tradeNo=" + tradeNo + ", orderNo=" + orderNo + ", userId=" + userId + ", createTime="
                + createTime + ", amount=" + amount + ", status=" + status + ", subject=" + subject + ", finishTime="
                + finishTime + ", type=" + type + ", flows=" + flows + ", remarks=" + remarks
                + ", payType=" + payType + ", amountType=" + amountType + ", leafNode=" + leafNode + ", address="
                + address + ", node=" + node + ", subNode=" + subNode + ", companyCode=" + companyCode + "]";
    }*/
}