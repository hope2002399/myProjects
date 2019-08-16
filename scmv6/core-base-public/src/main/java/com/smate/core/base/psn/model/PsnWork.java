package com.smate.core.base.psn.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 节点所在个人工作表.
 * 
 * 
 */
@Entity
@Table(name = "PSN_WORK_HISTORY")
public class PsnWork implements Serializable {
  private static final long serialVersionUID = 794932313676771245L;

  private Long workId;
  private Long psnId;
  private Long insId;
  private String insName;

  @Id
  @Column(name = "WORK_ID")
  public Long getWorkId() {
    return workId;
  }

  public void setWorkId(Long workId) {
    this.workId = workId;
  }

  @Column(name = "PSN_ID")
  public Long getPsnId() {
    return psnId;
  }

  public void setPsnId(Long psnId) {
    this.psnId = psnId;
  }

  @Column(name = "INS_ID")
  public Long getInsId() {
    return insId;
  }

  public void setInsId(Long insId) {
    this.insId = insId;
  }

  @Column(name = "INS_NAME")
  public String getInsName() {
    return insName;
  }

  public void setInsName(String insName) {
    this.insName = insName;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}
