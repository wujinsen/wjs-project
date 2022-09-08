package com.moli.kafka.clickhouse.domain.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class BuriedPointBookInfoVo implements Serializable {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 操作系统版本
     */
    private String osversion;

    /**
     * 设备型号
     */
    private String model;

    /**
     * 网络状态
     */
    private String isWifi;

    /**
     * 设备ID
     */
    private String deviceId;

    /**
     * 应用ID
     */
    private String appId;

    /**
     * 版本号
     */
    private String versionCode;

    /**
     * 当前APP版本
     */
    private String versionName;

    /**
     * 用户当前所在IP
     */
    private String userIp;

    /**
     * 当前动作
     */
    private String currentAction;

    /**
     * 动作发生后展示的页面（同落地页面一个意思）
     */
    private String currentPage;

    /**
     * 用户来源渠道
     */
    private String channelName;

    /**
     * 品牌
     */
    private String brand;


    /**
     * 产品类型（1，书山；2 书路）
     */
    private Integer productType;
}
