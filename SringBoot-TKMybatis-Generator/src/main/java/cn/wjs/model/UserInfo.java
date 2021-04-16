package cn.wjs.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_info")
public class UserInfo {
    /**
     * 主键
     */
    @Id
    @Column(name = "user_info_id")
    private Long userInfoId;

    /**
     * 用户中心编号
     */
    @Column(name = "user_center_id")
    private Long userCenterId;

    /**
     * 用户服务编号
     */
    @Column(name = "user_service_id")
    private String userServiceId;

    /**
     * 服务费率（%）
     */
    @Column(name = "service_rate")
    private BigDecimal serviceRate;

    /**
     * 累计订单
     */
    @Column(name = "cumulative_order")
    private Integer cumulativeOrder;

    /**
     * 当月金额
     */
    @Column(name = "month_amount")
    private BigDecimal monthAmount;

    /**
     * 累计金额
     */
    @Column(name = "accumulated_amount")
    private BigDecimal accumulatedAmount;

    /**
     * 最近成单时间
     */
    @Column(name = "last_order_time")
    private Date lastOrderTime;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取主键
     *
     * @return user_info_id - 主键
     */
    public Long getUserInfoId() {
        return userInfoId;
    }

    /**
     * 设置主键
     *
     * @param userInfoId 主键
     */
    public void setUserInfoId(Long userInfoId) {
        this.userInfoId = userInfoId;
    }

    /**
     * 获取用户中心编号
     *
     * @return user_center_id - 用户中心编号
     */
    public Long getUserCenterId() {
        return userCenterId;
    }

    /**
     * 设置用户中心编号
     *
     * @param userCenterId 用户中心编号
     */
    public void setUserCenterId(Long userCenterId) {
        this.userCenterId = userCenterId;
    }

    /**
     * 获取用户服务编号
     *
     * @return user_service_id - 用户服务编号
     */
    public String getUserServiceId() {
        return userServiceId;
    }

    /**
     * 设置用户服务编号
     *
     * @param userServiceId 用户服务编号
     */
    public void setUserServiceId(String userServiceId) {
        this.userServiceId = userServiceId;
    }

    /**
     * 获取服务费率（%）
     *
     * @return service_rate - 服务费率（%）
     */
    public BigDecimal getServiceRate() {
        return serviceRate;
    }

    /**
     * 设置服务费率（%）
     *
     * @param serviceRate 服务费率（%）
     */
    public void setServiceRate(BigDecimal serviceRate) {
        this.serviceRate = serviceRate;
    }

    /**
     * 获取累计订单
     *
     * @return cumulative_order - 累计订单
     */
    public Integer getCumulativeOrder() {
        return cumulativeOrder;
    }

    /**
     * 设置累计订单
     *
     * @param cumulativeOrder 累计订单
     */
    public void setCumulativeOrder(Integer cumulativeOrder) {
        this.cumulativeOrder = cumulativeOrder;
    }

    /**
     * 获取当月金额
     *
     * @return month_amount - 当月金额
     */
    public BigDecimal getMonthAmount() {
        return monthAmount;
    }

    /**
     * 设置当月金额
     *
     * @param monthAmount 当月金额
     */
    public void setMonthAmount(BigDecimal monthAmount) {
        this.monthAmount = monthAmount;
    }

    /**
     * 获取累计金额
     *
     * @return accumulated_amount - 累计金额
     */
    public BigDecimal getAccumulatedAmount() {
        return accumulatedAmount;
    }

    /**
     * 设置累计金额
     *
     * @param accumulatedAmount 累计金额
     */
    public void setAccumulatedAmount(BigDecimal accumulatedAmount) {
        this.accumulatedAmount = accumulatedAmount;
    }

    /**
     * 获取最近成单时间
     *
     * @return last_order_time - 最近成单时间
     */
    public Date getLastOrderTime() {
        return lastOrderTime;
    }

    /**
     * 设置最近成单时间
     *
     * @param lastOrderTime 最近成单时间
     */
    public void setLastOrderTime(Date lastOrderTime) {
        this.lastOrderTime = lastOrderTime;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}