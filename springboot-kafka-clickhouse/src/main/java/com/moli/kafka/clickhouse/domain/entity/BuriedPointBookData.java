package com.moli.kafka.clickhouse.domain.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class BuriedPointBookData implements Serializable {
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 用户渠道
     */
    private String channelName;
    /**
     * 用户IP
     */
    private String ip;
    /**
     * 设备ID
     */
    private String deviceId;
    /**
     * 应用ID
     */
    private String applicationId;
    /**
     * 操作系统
     */
    private String osVersion;

    /**
     * 品牌
     */
    private String brand;
    /**
     * 设备型号
     */
    private String deviceModel;
    /**
     * 网络类型(wifi、4G)
     */
    private String networkType;
    /**
     * 版本号
     */
    private String versionCode;
    /**
     * 版本名称
     */
    private String verisonName;
    /**
     * 产品类型 (1:书山, 2:书路)
     */
    private Integer productType;
    /**
     * 动作发生后展示的页面
     */
    private String currentPage;
    /**
     * 当前行为类型
     */
    private String currentAction;
    /**
     * 书籍ID
     */
    private Integer bookId;
    /**
     * 章节ID
     */
    private String chapterId;


    private Integer bookChapterId;
    /**
     * 阅读时间
     */
    private String readTime;

    /**
     * 启动APP时间戳
     */
    private String timestamp;

    /**
     * 书籍详情页面来源
     */
    private String pageId;


    private String pageIndex;

    private String totalPages;

    private String textSize;

    private String userIds;

    private String userSources;

    /**
     * 1 系统默认打开
     * 2 广告投放打开
     * 3 推送投放打开
     * 4 微信投放打开
     */
    private Integer fromAction;

    private String times;



}
