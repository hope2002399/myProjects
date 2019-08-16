package com.smate.center.batch.model.pdwh.pub;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.smate.core.base.utils.string.JnlFormateUtils;

/**
 * cwli基础期刊title表.
 */
@Entity
@Table(name = "BASE_JOURNAL_TITLE")
public class BaseJournalTitle implements Serializable {


  /**
   * 
   */
  private static final long serialVersionUID = 1467843840590682545L;

  private Long jouTitleId;

  private BaseJournal journal;

  private Long dbId;

  private String titleXx;

  private String titleEn;

  private String titleAbbr;

  private String pissn;

  private String eissn;

  private String dbCode;

  private String cn;

  private Integer titleStatus;

  private String titleXxAlias;
  private String titleEnAlias;
  private String titleAbbrAlias;

  @Id
  @Column(name = "JOU_TITLE_ID")
  @SequenceGenerator(name = "SEQ_STORE", sequenceName = "SEQ_BASE_JOU_TITLE", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_STORE")
  public Long getJouTitleId() {
    return jouTitleId;
  }

  public void setJouTitleId(Long jouTitleId) {
    this.jouTitleId = jouTitleId;
  }

  @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
  @JoinColumn(name = "JNL_ID", insertable = true, updatable = true)
  public BaseJournal getJournal() {
    return journal;
  }

  public void setJournal(BaseJournal journal) {
    this.journal = journal;
  }

  @Column(name = "DBID")
  public Long getDbId() {
    return dbId;
  }

  public void setDbId(Long dbId) {
    this.dbId = dbId;
  }

  @Column(name = "TITLE_XX")
  public String getTitleXx() {
    return titleXx;
  }

  public void setTitleXx(String titleXx) {
    this.titleXx = titleXx;
  }

  @Column(name = "TITLE_EN")
  public String getTitleEn() {
    return titleEn;
  }

  public void setTitleEn(String titleEn) {
    this.titleEn = titleEn;
  }

  @Column(name = "TITLE_ABBR")
  public String getTitleAbbr() {
    return titleAbbr;
  }

  public void setTitleAbbr(String titleAbbr) {
    this.titleAbbr = titleAbbr;
  }

  @Column(name = "PISSN")
  public String getPissn() {
    return pissn;
  }

  public void setPissn(String pissn) {
    this.pissn = pissn;
  }

  @Column(name = "EISSN")
  public String getEissn() {
    return eissn;
  }

  public void setEissn(String eissn) {
    this.eissn = eissn;
  }

  @Column(name = "CN")
  public String getCn() {
    return cn;
  }

  public void setCn(String cn) {
    this.cn = cn;
  }

  @Transient
  public String getDbCode() {
    return dbCode;
  }

  public void setDbCode(String dbCode) {
    this.dbCode = dbCode;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

  @Column(name = "TITLE_STATUS")
  public Integer getTitleStatus() {
    return titleStatus;
  }

  public void setTitleStatus(Integer titleStatus) {
    this.titleStatus = titleStatus;
  }

  @Column(name = "TITLE_XX_ALIAS")
  public String getTitleXxAlias() {
    if (StringUtils.isNotBlank(this.titleXx))
      titleXxAlias = JnlFormateUtils.getStrAlias(this.titleXx);
    return titleXxAlias;
  }

  public void setTitleXxAlias(String titleXxAlias) {
    this.titleXxAlias = titleXxAlias;
  }

  @Column(name = "TITLE_EN_ALIAS")
  public String getTitleEnAlias() {
    if (StringUtils.isNotBlank(this.titleEn))
      titleEnAlias = JnlFormateUtils.getStrAlias(this.titleEn);
    return titleEnAlias;
  }

  public void setTitleEnAlias(String titleEnAlias) {
    this.titleEnAlias = titleEnAlias;
  }

  @Column(name = "TITLE_ABBR_ALIAS")
  public String getTitleAbbrAlias() {
    if (StringUtils.isNotBlank(this.titleAbbr))
      titleAbbrAlias = JnlFormateUtils.getStrAlias(this.titleAbbr);
    return titleAbbrAlias;
  }

  public void setTitleAbbrAlias(String titleAbbrAlias) {
    this.titleAbbrAlias = titleAbbrAlias;
  }

}
