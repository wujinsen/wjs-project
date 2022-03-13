package cn.wjs.domain;

import lombok.Data;

@Data
public class Stock {

    private static final long serialVersionUID = 1L;

    /**
     * 用产品id,设置为库存id
     */
    private Long id;

    private Long skuId;

    /**
     * 库存数量
     */
    private Integer stockNum;

}
