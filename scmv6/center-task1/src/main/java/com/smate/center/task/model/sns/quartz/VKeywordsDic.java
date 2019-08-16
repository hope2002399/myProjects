package com.smate.center.task.model.sns.quartz;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 关键词字典，用于拆分成果标题、摘要等使用.
 * 
 * @author LIJUN
 *
 */
@Entity
@Table(name = "V_KEYWORDS_DIC")
public class VKeywordsDic implements Serializable {

  private static final long serialVersionUID = 8430091086477801404L;
  private Long id;
  private Long applicationId;// 申请号
  private Integer year;// 申请年份
  private String applicationCode1;// 申请代码1
  private String applicationCode2;// 申请代码2

  // 关键词
  private String keyword;
  // 关键词格式后的
  private String kwtxt;
  // 连接特征字符
  private String fturesWd;
  // 连接特征字符hashcode
  private Long fturesHash;
  // 关键词hashcode
  private Long kwhash;
  // 关键词反序hashcode
  private Long kwRhash;
  // 英文1，中文2
  private Integer type;
  // 关键词单词个数
  private Integer wlen;

  private String scmCategoryId;

  public VKeywordsDic() {
    super();
  }

  @Id
  @Column(name = "ID")
  @SequenceGenerator(name = "SEQ_STORE", sequenceName = "SEQ_V_KEYWORDS_DIC", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_STORE")
  public Long getId() {
    return id;
  }

  @Column(name = "KEYWORD")
  public String getKeyword() {
    return keyword;
  }

  @Column(name = "KEYWORD_TEXT")
  public String getKwtxt() {
    return kwtxt;
  }

  @Column(name = "SCM_CATEGORY_ID")
  public String getScmCategoryId() {
    return scmCategoryId;
  }

  public void setScmCategoryId(String scmCategoryId) {
    this.scmCategoryId = scmCategoryId;
  }

  @Column(name = "FTURES_WORD")
  public String getFturesWd() {
    return fturesWd;
  }

  @Column(name = "FTURES_HASH")
  public Long getFturesHash() {
    return fturesHash;
  }

  @Column(name = "KW_HASH")
  public Long getKwhash() {
    return kwhash;
  }

  @Column(name = "KW_RHASH")
  public Long getKwRhash() {
    return kwRhash;
  }

  @Column(name = "TYPE")
  public Integer getType() {
    return type;
  }

  @Column(name = "WORD_LEN")
  public Integer getWlen() {
    return wlen;
  }

  @Column(name = "APPLICATION_ID")
  public Long getApplicationId() {
    return applicationId;
  }

  public void setApplicationId(Long applicationId) {
    this.applicationId = applicationId;
  }

  @Column(name = "YEAR")
  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  @Column(name = "APPLICATION_CODE1")
  public String getApplicationCode1() {
    return applicationCode1;
  }

  public void setApplicationCode1(String applicationCode1) {
    this.applicationCode1 = applicationCode1;
  }

  @Column(name = "APPLICATION_CODE2")
  public String getApplicationCode2() {
    return applicationCode2;
  }

  public void setApplicationCode2(String applicationCode2) {
    this.applicationCode2 = applicationCode2;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public void setWlen(Integer wlen) {
    this.wlen = wlen;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }

  public void setKwtxt(String kwtxt) {
    this.kwtxt = kwtxt;
  }

  public void setFturesWd(String fturesWd) {
    this.fturesWd = fturesWd;
  }

  public void setFturesHash(Long fturesHash) {
    this.fturesHash = fturesHash;
  }

  public void setKwhash(Long kwhash) {
    this.kwhash = kwhash;
  }

  public void setKwRhash(Long kwRhash) {
    this.kwRhash = kwRhash;
  }

}
