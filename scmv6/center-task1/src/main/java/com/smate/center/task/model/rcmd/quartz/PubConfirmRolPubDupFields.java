package com.smate.center.task.model.rcmd.quartz;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;

/**
 * rol成果确认用于查重的信息.
 * 
 * @author zjh
 * 
 */
@Entity
@Table(name = "PUB_CONFIRM_ROLPUB_DUP_FIELDS")
public class PubConfirmRolPubDupFields implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -8277871901081008536L;
  // 主键
  private Long id;
  // 成果id
  private Long rolPubId;
  // 人员ID
  private Long ownerId;
  // 成果对应的外部数据库 refrence to const_ref_db
  private Integer sourceDbId;
  // 成果类型 CONST_PUB_type
  private Integer pubType;
  // 文献发表年份
  private Integer pubYear;
  // isi的source_id
  private String isiId;
  // isi的source_id字符串hash
  private Long isiHash;
  // scopus的source_id
  private String spsId;
  // scopus的source_id字符串hash
  private Long spsHash;
  // ei的source_id
  private String eiId;
  // ei的source_id字符串hash
  private Long eiHash;
  // 文献库doi
  private String doi;
  // 文献库doi字符串hash
  private Long doiHash;
  // 成果所属 期刊ID
  private Long jid;
  // isbn
  private String isbn;
  // volume of the journal or book, i.e. 13
  private String volume;
  // issue no. of journal or book
  private String issue;
  // issue no. 字符串hash
  private Long issueHash;
  // 起始页码
  private String startPage;
  // articleNum
  private String articleNo;
  // 中文标题hash_code，查重时使用，统一调用PublicationHash.titleCode(title)取得hash_code
  private Long zhTitleHash;
  // 英文标题hash_code，查重时使用 统一调用PublicationHash.titleCode(title) 取得hash_code
  private Long enTitleHash;
  // 期刊jid + volume + issue + article_no的字符串hash
  private Long jaFingerPrint;
  // 期刊jid + volume + issue + start_page 的字符串hash
  private Long jpFingerPrint;
  // 会议论文Isbn +start_page的字符串hash
  private Long cpFingerPrint;
  // 专利号
  private String patentNo;
  // 专利号HASH
  private Long patentHash;
  // 专利公开号
  private String patentOpenNo;
  // 专利公开号hash
  private Long patentOpenNoHash;
  // 作者名hash
  private Long auNameHash;
  // 会议名称hash
  private Long confnHash;
  private String issn;
  // 会议论文Isbn + article_no的字符串hash
  private Long caFingerPrint;
  // 会议论文issn + volume + article_no 的字符串hash
  private Long cvaFingerPrint;
  // 会议论文issn + volume +start_page的字符串hash
  private Long cvpFingerPrint;
  // jname+issn
  private Long jfingerPrint;

  public PubConfirmRolPubDupFields() {
    super();
  }

  public PubConfirmRolPubDupFields(Long rolPubId, PubDupFields dupFields) {
    this.rolPubId = rolPubId;
    this.articleNo = dupFields.getArticleNo();
    this.cpFingerPrint = dupFields.getCpFingerPrint();
    this.doi = dupFields.getDoi();
    this.doiHash = dupFields.getDoiHash();
    this.enTitleHash = dupFields.getEnTitleHash();
    this.isbn = dupFields.getIsbn();
    this.isiHash = dupFields.getIsiHash();
    this.isiId = dupFields.getIsiId();
    this.issue = dupFields.getIssue();
    this.jaFingerPrint = dupFields.getJaFingerPrint();
    this.jid = dupFields.getJid();
    this.jpFingerPrint = dupFields.getJpFingerPrint();
    this.ownerId = dupFields.getOwnerId();
    this.pubType = dupFields.getPubType();
    this.pubYear = dupFields.getPubYear();
    this.sourceDbId = dupFields.getSourceDbId();
    this.startPage = dupFields.getStartPage();
    this.volume = dupFields.getVolume();
    this.zhTitleHash = dupFields.getZhTitleHash();
    this.spsHash = dupFields.getSpsHash();
    this.spsId = dupFields.getSpsId();
    this.eiHash = dupFields.getEiHash();
    this.eiId = dupFields.getEiId();
    this.issueHash = dupFields.getIssueHash();
    this.patentNo = dupFields.getPatentNo();
    this.patentHash = dupFields.getPatentHash();
    this.patentOpenNo = dupFields.getPatentOpenNo();
    this.patentOpenNoHash = dupFields.getPatentOpenNoHash();
    this.auNameHash = dupFields.getAuNameHash();
    this.confnHash = dupFields.getConfnHash();
    this.issn = dupFields.getIssn();
    this.caFingerPrint = dupFields.getCaFingerPrint();
    this.cvaFingerPrint = dupFields.getCvaFingerPrint();
    this.cvpFingerPrint = dupFields.getCvpFingerPrint();
    this.jfingerPrint = dupFields.getJfingerPrint();
  }

  /**
   * 获取封装的PubDupFields对象.
   * 
   * @return
   */
  public PubDupFields wrapPubDupFields() {
    PubDupFields dupFields = new PubDupFields();
    dupFields.setArticleNo(this.articleNo);
    dupFields.setCpFingerPrint(this.cpFingerPrint);
    dupFields.setDoi(this.doi);
    dupFields.setDoiHash(this.doiHash);
    dupFields.setEnTitleHash(this.enTitleHash);
    dupFields.setIsbn(this.isbn);
    dupFields.setIsiHash(this.isiHash);
    dupFields.setIsiId(this.isiId);
    dupFields.setIssue(this.issue);
    dupFields.setJaFingerPrint(this.jaFingerPrint);
    dupFields.setJid(this.jid);
    dupFields.setJpFingerPrint(this.jpFingerPrint);
    dupFields.setOwnerId(this.ownerId);
    dupFields.setPubType(this.pubType);
    dupFields.setPubYear(this.pubYear);
    dupFields.setSourceDbId(this.sourceDbId);
    dupFields.setStartPage(this.startPage);
    dupFields.setVolume(this.volume);
    dupFields.setZhTitleHash(this.zhTitleHash);
    dupFields.setSpsHash(this.spsHash);
    dupFields.setSpsId(this.spsId);
    dupFields.setEiHash(this.eiHash);
    dupFields.setEiId(this.eiId);
    dupFields.setIssueHash(this.issueHash);
    dupFields.setPatentNo(this.patentNo);
    dupFields.setPatentHash(this.patentHash);
    dupFields.setPatentOpenNo(this.patentOpenNo);
    dupFields.setPatentOpenNoHash(this.patentOpenNoHash);
    dupFields.setAuNameHash(this.auNameHash);
    dupFields.setConfnHash(this.confnHash);
    dupFields.setIssn(StringUtils.substring(this.issn, 0, 40));
    dupFields.setCaFingerPrint(this.caFingerPrint);
    dupFields.setCvaFingerPrint(this.cvaFingerPrint);
    dupFields.setCvpFingerPrint(this.cvpFingerPrint);
    dupFields.setJfingerPrint(this.jfingerPrint);
    return dupFields;
  }

  @Id
  @Column(name = "ID")
  @SequenceGenerator(name = "SEQ_STORE", sequenceName = "SEQ_CONFIRM_ROLPUB_DUP_FIELDS", allocationSize = 1)
  @GeneratedValue(generator = "SEQ_STORE", strategy = GenerationType.SEQUENCE)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Column(name = "ROLPUB_ID")
  public Long getRolPubId() {
    return rolPubId;
  }

  public void setRolPubId(Long rolPubId) {
    this.rolPubId = rolPubId;
  }

  @Column(name = "OWNER_ID")
  public Long getOwnerId() {
    return ownerId;
  }

  @Column(name = "SOURCE_DB_ID")
  public Integer getSourceDbId() {
    return sourceDbId;
  }

  @Column(name = "PUB_TYPE")
  public Integer getPubType() {
    return pubType;
  }

  @Column(name = "PUB_YEAR")
  public Integer getPubYear() {
    return pubYear;
  }

  @Column(name = "ISI_ID")
  public String getIsiId() {
    return isiId;
  }

  @Column(name = "ISI_ID_HASH")
  public Long getIsiHash() {
    return isiHash;
  }

  @Column(name = "DOI")
  public String getDoi() {
    return doi;
  }

  @Column(name = "DOI_HASH")
  public Long getDoiHash() {
    return doiHash;
  }

  @Column(name = "JID")
  public Long getJid() {
    return jid;
  }

  @Column(name = "ISBN")
  public String getIsbn() {
    return isbn;
  }

  @Column(name = "VOLUME")
  public String getVolume() {
    return volume;
  }

  @Column(name = "ISSUE")
  public String getIssue() {
    return issue;
  }

  @Column(name = "START_PAGE")
  public String getStartPage() {
    return startPage;
  }

  @Column(name = "ARTICLE_NO")
  public String getArticleNo() {
    return articleNo;
  }

  public void setArticleNo(String articleNo) {
    this.articleNo = articleNo;
  }

  @Column(name = "ZH_TITLE_HASH")
  public Long getZhTitleHash() {
    return zhTitleHash;
  }

  @Column(name = "EN_TITLE_HASH")
  public Long getEnTitleHash() {
    return enTitleHash;
  }

  @Column(name = "JAFINGER_PRINT")
  public Long getJaFingerPrint() {
    return jaFingerPrint;
  }

  @Column(name = "JPFINGER_PRINT")
  public Long getJpFingerPrint() {
    return jpFingerPrint;
  }

  @Column(name = "CPFINGER_PRINT")
  public Long getCpFingerPrint() {
    return cpFingerPrint;
  }

  @Column(name = "SPS_ID")
  public String getSpsId() {
    return spsId;
  }

  @Column(name = "SPS_ID_HASH")
  public Long getSpsHash() {
    return spsHash;
  }

  @Column(name = "EI_ID")
  public String getEiId() {
    return eiId;
  }

  @Column(name = "EI_ID_HASH")
  public Long getEiHash() {
    return eiHash;
  }

  @Column(name = "ISSN")
  public String getIssn() {
    return issn;
  }

  @Column(name = "CAFINGER_PRINT")
  public Long getCaFingerPrint() {
    return caFingerPrint;
  }

  @Column(name = "CVAFINGER_PRINT")
  public Long getCvaFingerPrint() {
    return cvaFingerPrint;
  }

  @Column(name = "CVPFINGER_PRINT")
  public Long getCvpFingerPrint() {
    return cvpFingerPrint;
  }

  @Column(name = "JFINGERPRINT")
  public Long getJfingerPrint() {
    return jfingerPrint;
  }

  @Column(name = "PATENT_OPEN_NO")
  public String getPatentOpenNo() {
    return patentOpenNo;
  }

  @Column(name = "PATENT_OPEN_HASH")
  public Long getPatentOpenNoHash() {
    return patentOpenNoHash;
  }

  public void setPatentOpenNo(String patentOpenNo) {
    this.patentOpenNo = patentOpenNo;
  }

  public void setPatentOpenNoHash(Long patentOpenNoHash) {
    this.patentOpenNoHash = patentOpenNoHash;
  }

  public void setJfingerPrint(Long jfingerPrint) {
    this.jfingerPrint = jfingerPrint;
  }

  public void setIssn(String issn) {
    this.issn = issn;
  }

  public void setCaFingerPrint(Long caFingerPrint) {
    this.caFingerPrint = caFingerPrint;
  }

  public void setCvaFingerPrint(Long cvaFingerPrint) {
    this.cvaFingerPrint = cvaFingerPrint;
  }

  public void setCvpFingerPrint(Long cvpFingerPrint) {
    this.cvpFingerPrint = cvpFingerPrint;
  }

  public void setSpsId(String spsId) {
    this.spsId = spsId;
  }

  public void setSpsHash(Long spsHash) {
    this.spsHash = spsHash;
  }

  public void setEiId(String eiId) {
    this.eiId = eiId;
  }

  public void setEiHash(Long eiHash) {
    this.eiHash = eiHash;
  }

  public void setOwnerId(Long ownerId) {
    this.ownerId = ownerId;
  }

  public void setSourceDbId(Integer sourceDbId) {
    this.sourceDbId = sourceDbId;
  }

  public void setPubType(Integer pubType) {
    this.pubType = pubType;
  }

  public void setPubYear(Integer pubYear) {
    this.pubYear = pubYear;
  }

  public void setIsiId(String isiId) {
    this.isiId = isiId;
  }

  public void setIsiHash(Long isiHash) {
    this.isiHash = isiHash;
  }

  public void setDoi(String doi) {
    this.doi = doi;
  }

  public void setDoiHash(Long doiHash) {
    this.doiHash = doiHash;
  }

  public void setJid(Long jid) {
    this.jid = jid;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public void setVolume(String volume) {
    this.volume = volume;
  }

  public void setIssue(String issue) {
    this.issue = issue;
  }

  public void setStartPage(String startPage) {
    this.startPage = startPage;
  }

  public void setZhTitleHash(Long zhTitleHash) {
    this.zhTitleHash = zhTitleHash;
  }

  public void setEnTitleHash(Long enTitleHash) {
    this.enTitleHash = enTitleHash;
  }

  public void setJaFingerPrint(Long jaFingerPrint) {
    this.jaFingerPrint = jaFingerPrint;
  }

  public void setJpFingerPrint(Long jpFingerPrint) {
    this.jpFingerPrint = jpFingerPrint;
  }

  public void setCpFingerPrint(Long cpFingerPrint) {
    this.cpFingerPrint = cpFingerPrint;
  }

  @Column(name = "PATENT_NO")
  public String getPatentNo() {
    return patentNo;
  }

  @Column(name = "PATENT_HASH")
  public Long getPatentHash() {
    return patentHash;
  }

  @Column(name = "AUNAME_HASH")
  public Long getAuNameHash() {
    return auNameHash;
  }

  @Column(name = "ISSUE_HASH")
  public Long getIssueHash() {
    return issueHash;
  }

  @Column(name = "CONFN_HASH")
  public Long getConfnHash() {
    return confnHash;
  }

  public void setConfnHash(Long confnHash) {
    this.confnHash = confnHash;
  }

  public void setIssueHash(Long issueHash) {
    this.issueHash = issueHash;
  }

  public void setPatentNo(String patentNo) {
    this.patentNo = patentNo;
  }

  public void setPatentHash(Long patentHash) {
    this.patentHash = patentHash;
  }

  public void setAuNameHash(Long auNameHash) {
    this.auNameHash = auNameHash;
  }
}
