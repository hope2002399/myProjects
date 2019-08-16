package com.smate.web.v8pub.po.repeatpub;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 单项重复成果记录信息表
 * 
 * @author YJ
 * @createTime 2018年1月2日 下午14:00:00
 */

@Entity
@Table(name = "V_PUB_SAME_ITEM")
public class PubSameItemPO implements Serializable {


  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "ID")
  @SequenceGenerator(name = "SEQ_STORE", sequenceName = "SEQ_V_PUB_SAME_ITEM", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_STORE")
  private Long id; // 主键id
  @Column(name = "RECORD_ID")
  private Long recordId; // 分组id
  @Column(name = "PSN_ID")
  private Long psnId; // 人员id
  @Column(name = "PUB_ID")
  private Long pubId; // 成果id
  @Column(name = "DEAL_STATUS")
  private Integer dealStatus; // 0=未处理；1=保留；2=删除
  @Column(name = "CREATE_DATE")
  private Date createDate; // 创建时间
  @Column(name = "UPDATE_DATE")
  private Date updateDate; // 更新时间

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getRecordId() {
    return recordId;
  }

  public void setRecordId(Long recordId) {
    this.recordId = recordId;
  }

  public Long getPsnId() {
    return psnId;
  }

  public void setPsnId(Long psnId) {
    this.psnId = psnId;
  }

  public Long getPubId() {
    return pubId;
  }

  public void setPubId(Long pubId) {
    this.pubId = pubId;
  }

  public Integer getDealStatus() {
    return dealStatus;
  }

  public void setDealStatus(Integer dealStatus) {
    this.dealStatus = dealStatus;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }


}
