package com.smate.center.task.model.rcmd.quartz;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 成果基准库id.
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "PUB_CONFIRM_ROLPUB_PDWH")
public class PubConfirmRolPubPdwh implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -269989560379113859L;
  private Long rolPubId;
  // 基准库isi_id
  private Long isiId;
  // 基准库ei_id
  private Long eiId;
  // 基准库scopus_id
  private Long spsId;
  // 基准库cnki_id
  private Long cnkiId;
  // 基准库wanfang_id
  private Long wfId;
  // 基准库cnipr_id
  private Long cniprId;
  // 基准库pubmed_id
  private Long pubmedId;
  // 基准库ieeexp_id
  private Long ieeeXpId;
  // 基准库ScienceDirect id
  private Long scdId;
  // 基准库Baidu专利 id
  private Long baiduId;
  // 基准库CNKI专利
  private Long cnkiPatId;

  public PubConfirmRolPubPdwh() {
    super();
  }

  public PubConfirmRolPubPdwh(Long rolPubId) {
    super();
    this.rolPubId = rolPubId;
  }

  public PubConfirmRolPubPdwh(Long rolPubId, Long isiId, Long eiId, Long spsId, Long cnkiId, Long wfId, Long cniprId,
      Long pubmedId, Long ieeeXpId, Long scdId, Long baiduId, Long cnkiPatId) {
    super();
    this.rolPubId = rolPubId;
    this.isiId = isiId;
    this.eiId = eiId;
    this.spsId = spsId;
    this.cnkiId = cnkiId;
    this.wfId = wfId;
    this.cniprId = cniprId;
    this.pubmedId = pubmedId;
    this.ieeeXpId = ieeeXpId;
    this.scdId = scdId;
    this.baiduId = baiduId;
    this.cnkiPatId = cnkiPatId;
  }

  @Id
  @Column(name = "ROL_PUB_ID")
  public Long getRolPubId() {
    return rolPubId;
  }

  @Column(name = "PDWH_ISI_ID")
  public Long getIsiId() {
    return isiId;
  }

  @Column(name = "PDWH_EI_ID")
  public Long getEiId() {
    return eiId;
  }

  @Column(name = "PDWH_SPS_ID")
  public Long getSpsId() {
    return spsId;
  }

  @Column(name = "PDWH_CNKI_ID")
  public Long getCnkiId() {
    return cnkiId;
  }

  @Column(name = "PDWH_WF_ID")
  public Long getWfId() {
    return wfId;
  }

  @Column(name = "PDWH_CNIPR_ID")
  public Long getCniprId() {
    return cniprId;
  }

  @Column(name = "PDWH_PUBMED_ID")
  public Long getPubmedId() {
    return pubmedId;
  }

  @Column(name = "PDWH_IEEEXP_ID")
  public Long getIeeeXpId() {
    return ieeeXpId;
  }

  @Column(name = "PDWH_SCD_ID")
  public Long getScdId() {
    return scdId;
  }

  @Column(name = "PDWH_BAIDU_ID")
  public Long getBaiduId() {
    return baiduId;
  }

  @Column(name = "PDWH_CNKIPAT_ID")
  public Long getCnkiPatId() {
    return cnkiPatId;
  }

  public void setCnkiPatId(Long cnkiPatId) {
    this.cnkiPatId = cnkiPatId;
  }

  public void setBaiduId(Long baiduId) {
    this.baiduId = baiduId;
  }

  public void setScdId(Long scdId) {
    this.scdId = scdId;
  }

  public void setIeeeXpId(Long ieeeXpId) {
    this.ieeeXpId = ieeeXpId;
  }

  public void setPubmedId(Long pubmedId) {
    this.pubmedId = pubmedId;
  }

  public void setRolPubId(Long rolPubId) {
    this.rolPubId = rolPubId;
  }

  public void setIsiId(Long isiId) {
    this.isiId = isiId;
  }

  public void setEiId(Long eiId) {
    this.eiId = eiId;
  }

  public void setSpsId(Long spsId) {
    this.spsId = spsId;
  }

  public void setCnkiId(Long cnkiId) {
    this.cnkiId = cnkiId;
  }

  public void setWfId(Long wfId) {
    this.wfId = wfId;
  }

  public void setCniprId(Long cniprId) {
    this.cniprId = cniprId;
  }

}
