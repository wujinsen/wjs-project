package cn.wjs.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

@Data
public class OrderM {
    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 下单用户id
     */
    private Long userId;

    /**
     * 产品id
     */
    private Long skuId;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

}
