package com.moli.kafka.clickhouse.domain.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class BuriedPointBookInfoVo implements Serializable {

    /**
     * 书籍ID
     */
    private String bookId;

    /**
     * 章节ID
     */
    private String chapterId;

    /**
     * 阅读时间
     */
    private String time;

    private String timestamp;

    private String pageId;

    private String pageIndex;

    private String totalPages;

    private String textSize;

    private String times;

}
