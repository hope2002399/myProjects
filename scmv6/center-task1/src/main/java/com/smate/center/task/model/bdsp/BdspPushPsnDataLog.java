package com.smate.center.task.model.bdsp;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BDSP_PUSH_PSN_DATA_LOG")
public class BdspPushPsnDataLog implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "PSN_ID")
  private Long psnId;
  // 推送状态 1=推送成功 2=推送失败
  @Column(name = "PUSH_STATUS")
  private Integer pushStatus;
  @Column(name = "PUSH_MSG")
  private String pushMsg;
  @Column(name = "UPDATE_DATE")
  private Date updateDate;
  @Column(name = "CREATE_DATE")
  private Date createDate;

  public Long getPsnId() {
    return psnId;
  }

  public void setPsnId(Long psnId) {
    this.psnId = psnId;
  }

  public Integer getPushStatus() {
    return pushStatus;
  }

  public void setPushStatus(Integer pushStatus) {
    this.pushStatus = pushStatus;
  }

  public String getPushMsg() {
    return pushMsg;
  }

  public void setPushMsg(String pushMsg) {
    this.pushMsg = pushMsg;
  }

  public Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

}
