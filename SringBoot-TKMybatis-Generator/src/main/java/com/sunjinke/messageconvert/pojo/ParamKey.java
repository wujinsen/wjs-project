package com.sunjinke.messageconvert.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_param_key")
public class ParamKey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "system_api_id")
    private String systemApiId;

    @Column(name = "out_param_key")
    private String outParamKey;

    @Column(name = "param_data_type")
    private String paramDataType;

    @Column(name = "param_desc")
    private String paramDesc;

    @Column(name = "out_param_node")
    private Integer outParamNode;

    @Column(name = "out_parent_key")
    private String outParentKey;

    @Column(name = "in_param_key")
    private String inParamKey;

    @Column(name = "in_param_node")
    private Integer inParamNode;

    @Column(name = "in_parent_key")
    private String inParentKey;

    private String type;

    @Column(name = "is_parent")
    private Integer isParent;

    @Column(name = "array_size")
    private Integer arraySize;

    @Column(name = "param_type")
    private String paramType;

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
     * @return system_api_id
     */
    public String getSystemApiId() {
        return systemApiId;
    }

    /**
     * @param systemApiId
     */
    public void setSystemApiId(String systemApiId) {
        this.systemApiId = systemApiId;
    }

    /**
     * @return out_param_key
     */
    public String getOutParamKey() {
        return outParamKey;
    }

    /**
     * @param outParamKey
     */
    public void setOutParamKey(String outParamKey) {
        this.outParamKey = outParamKey;
    }

    /**
     * @return param_data_type
     */
    public String getParamDataType() {
        return paramDataType;
    }

    /**
     * @param paramDataType
     */
    public void setParamDataType(String paramDataType) {
        this.paramDataType = paramDataType;
    }

    /**
     * @return param_desc
     */
    public String getParamDesc() {
        return paramDesc;
    }

    /**
     * @param paramDesc
     */
    public void setParamDesc(String paramDesc) {
        this.paramDesc = paramDesc;
    }

    /**
     * @return out_param_node
     */
    public Integer getOutParamNode() {
        return outParamNode;
    }

    /**
     * @param outParamNode
     */
    public void setOutParamNode(Integer outParamNode) {
        this.outParamNode = outParamNode;
    }

    /**
     * @return out_parent_key
     */
    public String getOutParentKey() {
        return outParentKey;
    }

    /**
     * @param outParentKey
     */
    public void setOutParentKey(String outParentKey) {
        this.outParentKey = outParentKey;
    }

    /**
     * @return in_param_key
     */
    public String getInParamKey() {
        return inParamKey;
    }

    /**
     * @param inParamKey
     */
    public void setInParamKey(String inParamKey) {
        this.inParamKey = inParamKey;
    }

    /**
     * @return in_param_node
     */
    public Integer getInParamNode() {
        return inParamNode;
    }

    /**
     * @param inParamNode
     */
    public void setInParamNode(Integer inParamNode) {
        this.inParamNode = inParamNode;
    }

    /**
     * @return in_parent_key
     */
    public String getInParentKey() {
        return inParentKey;
    }

    /**
     * @param inParentKey
     */
    public void setInParentKey(String inParentKey) {
        this.inParentKey = inParentKey;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return is_parent
     */
    public Integer getIsParent() {
        return isParent;
    }

    /**
     * @param isParent
     */
    public void setIsParent(Integer isParent) {
        this.isParent = isParent;
    }

    /**
     * @return array_size
     */
    public Integer getArraySize() {
        return arraySize;
    }

    /**
     * @param arraySize
     */
    public void setArraySize(Integer arraySize) {
        this.arraySize = arraySize;
    }

    /**
     * @return param_type
     */
    public String getParamType() {
        return paramType;
    }

    /**
     * @param paramType
     */
    public void setParamType(String paramType) {
        this.paramType = paramType;
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