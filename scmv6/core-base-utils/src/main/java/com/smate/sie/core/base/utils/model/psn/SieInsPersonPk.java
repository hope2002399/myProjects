package com.smate.sie.core.base.utils.model.psn;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author lichangwen
 * 
 */
@Embeddable
public class SieInsPersonPk implements Serializable {

  private static final long serialVersionUID = 5609609162130630424L;
  /** 人员Id. */
  private Long psnId;
  /** 单位Id. */
  private Long insId;

  public SieInsPersonPk() {
    super();

  }

  public SieInsPersonPk(Long psnId, Long insId) {
    super();
    this.psnId = psnId;
    this.insId = insId;
  }

  /**
   * @return psnId
   */
  @Column(name = "PSN_ID")
  public Long getPsnId() {
    return psnId;
  }

  /**
   * @param psnId
   */
  public void setPsnId(Long psnId) {
    this.psnId = psnId;
  }

  /**
   * @return insId
   */
  @Column(name = "INS_ID")
  public Long getInsId() {
    return insId;
  }

  /**
   * @param insId
   */
  public void setInsId(Long insId) {
    this.insId = insId;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((insId == null) ? 0 : insId.hashCode());
    result = prime * result + ((psnId == null) ? 0 : psnId.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    SieInsPersonPk other = (SieInsPersonPk) obj;
    if (insId == null) {
      if (other.insId != null)
        return false;
    } else if (!insId.equals(other.insId))
      return false;
    if (psnId == null) {
      if (other.psnId != null)
        return false;
    } else if (!psnId.equals(other.psnId))
      return false;
    return true;
  }

}
