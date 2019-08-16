package com.smate.sie.center.task.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 成果日志.
 * 
 * @author jszhou
 */
@Entity
@Table(name = "LOG_PAT")
public class SiePatentLog implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -6147487188524629014L;

  private Long id;
  private Long patId;
  private Long opPsnId;
  private Date opDate;
  private String opAction;
  private String opDetail;
  private Long insId;

  /** @return the id */
  @Id
  @Column(name = "LOG_ID")
  @SequenceGenerator(name = "SEQ_STORE", sequenceName = "SEQ_LOG_PAT", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_STORE")
  public Long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  /** @return the patId */
  @Column(name = "PAT_ID")
  public Long getPatId() {
    return patId;
  }

  /**
   * @param patId the patId to set
   */
  public void setPatId(Long patId) {
    this.patId = patId;
  }

  /** @return the opPsnId */
  @Column(name = "OP_PSN_ID")
  public Long getOpPsnId() {
    return opPsnId;
  }

  /**
   * @param opPsnId the opPsnId to set
   */
  public void setOpPsnId(Long opPsnId) {
    this.opPsnId = opPsnId;
  }

  /** @return the opDate */
  @Column(name = "OP_DATE")
  public Date getOpDate() {
    return opDate;
  }

  /**
   * @param opDate the opDate to set
   */
  public void setOpDate(Date opDate) {
    this.opDate = opDate;
  }

  /** @return the opAction */
  @Column(name = "OP_ACTION")
  public String getOpAction() {
    return opAction;
  }

  /**
   * @param opAction the opAction to set
   */
  public void setOpAction(String opAction) {
    this.opAction = opAction;
  }

  /** @return the opDetail */
  @Column(name = "OP_DETAIL")
  public String getOpDetail() {
    return opDetail;
  }

  /**
   * @param opDetail the opDetail to set
   */
  public void setOpDetail(String opDetail) {
    this.opDetail = opDetail;
  }

  /** @return the insId */
  @Column(name = "INS_ID")
  public Long getInsId() {
    return insId;
  }

  /**
   * @param insId the insId to set
   */
  public void setInsId(Long insId) {
    this.insId = insId;
  }
}
