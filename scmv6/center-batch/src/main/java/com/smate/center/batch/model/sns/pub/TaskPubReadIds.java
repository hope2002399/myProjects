package com.smate.center.batch.model.sns.pub;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 成果读者推荐任务ID表.
 * 
 * @author lichangwen
 * 
 */
@Entity
@Table(name = "TASK_PUB_READER_IDS")
public class TaskPubReadIds implements Serializable {


  /**
   * 
   */
  private static final long serialVersionUID = -1272870194078289544L;
  @Id
  @Column(name = "PUB_ID")
  private Long pubId;
  @Column(name = "STATUS")
  private Integer status;

  public Long getPubId() {
    return pubId;
  }

  public void setPubId(Long pubId) {
    this.pubId = pubId;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }



}
