




CREATE TABLE buried_point_book_data(
                                            `id` Int32,
                                            `user_id` Int32  COMMENT '用户id',
                                            `channel_name` String  COMMENT '用户渠道',
                                            `ip` String COMMENT '用户IP',
                                            `device_id` String  COMMENT '设备ID',
                                            `application_id` String  COMMENT '应用ID',
                                            `os_version` String  COMMENT '操作系统',
                                            `brand` String  COMMENT '品牌',
                                            `device_model` String  COMMENT '设备型号',
                                            `network_type` String  COMMENT '网络类型(wifi、4G)',
                                            `version_code` String  COMMENT '版本号',
                                            `verison_name` String  COMMENT '版本名称',
                                            `product_type` Int8 COMMENT '产品类型 (1:书山, 2:书路)',
                                            `current_page` String  COMMENT '动作发生后展示的页面',
                                            `current_action` String  COMMENT '当前行为类型',
                                            `book_id` Int32  COMMENT '书籍ID',
                                            `chapter_id` text COMMENT '章节ID',
                                            `book_chapter_id` Int32  COMMENT '章节id',
                                            `read_time` String  COMMENT '阅读时间',
                                            `timestamp` String ,
                                            `page_id` String,
                                            `page_index` String,
                                            `total_pages` String,
                                            `from_action` Int8  COMMENT '打开方式1 系统默认打开2 广告投放打开3 推送投放打开4 微信投放打开',
                                            `text_size` String ,
                                            `create_time` DateTime,
                                            `update_time` Datetime   COMMENT '最后修改时间',
                                            `times` String  COMMENT '次数'
)
    ENGINE = MergeTree
PARTITION BY toYYYYMMDD(create_time)
PRIMARY KEY id
ORDER BY (id)
