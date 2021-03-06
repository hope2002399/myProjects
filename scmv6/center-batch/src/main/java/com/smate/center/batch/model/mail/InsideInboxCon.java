package com.smate.center.batch.model.mail;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 站内收件箱内容表_SCM-5910.
 * 
 * @author mjg
 * 
 */
@Entity
@Table(name = "INSIDE_INBOX_CON")
public class InsideInboxCon implements Serializable {


  /**
   * 
   */
  private static final long serialVersionUID = -2460732858026397010L;
  @Id
  @Column(name = "ID")
  @SequenceGenerator(name = "SEQ_STORE", sequenceName = "SEQ_INSIDE_INBOX_CON", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_STORE")
  private Long id;
  @Column(name = "INBOX_ID")
  private Long inboxId;// 收件箱ID.
  @Column(name = "TITLE_ZH")
  private String titleZh;// 中文标题.
  @Column(name = "TITLE_EN")
  private String titleEn;// 英文标题.
  @Column(name = "EXT_OTHER_INFO")
  private String extOtherInfo;// 扩展信息.
  @Column(name = "CONTENT")
  private String content;// 收件内容.

  public InsideInboxCon() {
    super();
  }

  public InsideInboxCon(Long id, Long inboxId, String titleZh, String titleEn, String extOtherInfo, String content) {
    super();
    this.id = id;
    this.inboxId = inboxId;
    this.titleZh = titleZh;
    this.titleEn = titleEn;
    this.extOtherInfo = extOtherInfo;
    this.content = content;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getInboxId() {
    return inboxId;
  }

  public void setInboxId(Long inboxId) {
    this.inboxId = inboxId;
  }

  public String getTitleZh() {
    return titleZh;
  }

  public void setTitleZh(String titleZh) {
    this.titleZh = titleZh;
  }

  public String getTitleEn() {
    return titleEn;
  }

  public void setTitleEn(String titleEn) {
    this.titleEn = titleEn;
  }

  public String getExtOtherInfo() {
    return extOtherInfo;
  }

  public void setExtOtherInfo(String extOtherInfo) {
    this.extOtherInfo = extOtherInfo;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

}
