package com.sunjinke.messageconvert.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_system_api")
public class SystemApi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "api_desc")
    private String apiDesc;

    @Column(name = "content_type")
    private String contentType;

    @Column(name = "request_type")
    private String requestType;

    @Column(name = "service_id")
    private String serviceId;

    @Column(name = "rep_content_type")
    private String repContentType;

    @Column(name = "appId")
    private String appid;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return api_desc
     */
    public String getApiDesc() {
        return apiDesc;
    }

    /**
     * @param apiDesc
     */
    public void setApiDesc(String apiDesc) {
        this.apiDesc = apiDesc;
    }

    /**
     * @return content_type
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * @param contentType
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * @return request_type
     */
    public String getRequestType() {
        return requestType;
    }

    /**
     * @param requestType
     */
    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    /**
     * @return service_id
     */
    public String getServiceId() {
        return serviceId;
    }

    /**
     * @param serviceId
     */
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    /**
     * @return rep_content_type
     */
    public String getRepContentType() {
        return repContentType;
    }

    /**
     * @param repContentType
     */
    public void setRepContentType(String repContentType) {
        this.repContentType = repContentType;
    }

    /**
     * @return appId
     */
    public String getAppid() {
        return appid;
    }

    /**
     * @param appid
     */
    public void setAppid(String appid) {
        this.appid = appid;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}