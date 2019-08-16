package com.smate.sie.core.base.utils.model.statistics;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 单位分析，访客数
 * 
 * @author ztg
 *
 */
@Entity
@Table(name = "KPI_IMPACT_EXTEND_VIEW_IP")
public class KpiImpactExtendViewIP implements Serializable {



  /**
   * 
   */
  private static final long serialVersionUID = 5882624141866072003L;
  // 主键
  private Long id;
  // 统计日期，YYYYMM
  private String stMonth;
  // 统计月份情况
  private Integer stBatch;

  // 统计类型（1国家，2省份，3城市，4单位，5研究领域，6职称，7日期）
  private Integer stType;
  // 统计类型对应的item名称
  private String stName;
  // 统计类型对应的item code
  private Long stCode;
  // 总数
  private Long cnt;
  // 单位主键
  private Long insId;
  // 数据类型：1项目2论文3专利
  private Integer keyType;


  public KpiImpactExtendViewIP() {
    super();
  }


  public KpiImpactExtendViewIP(String stMonth, Integer stBatch, Integer stType, String stName, Long stCode, Long cnt,
      Long insId, Integer keyType) {
    super();
    this.stMonth = stMonth;
    this.stBatch = stBatch;
    this.stType = stType;
    this.stName = stName;
    this.stCode = stCode;
    this.cnt = cnt;
    this.insId = insId;
    this.keyType = keyType;
  }



  @Id
  @Column(name = "ID")
  @SequenceGenerator(name = "SEQ_STORE", sequenceName = "SEQ_KPI_IMPACT_EXTEND_VIEW_IP", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_STORE")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Column(name = "ST_MONTH")
  public String getStMonth() {
    return stMonth;
  }


  public void setStMonth(String stMonth) {
    this.stMonth = stMonth;
  }

  @Column(name = "ST_BATCH")
  public Integer getStBatch() {
    return stBatch;
  }

  public void setStBatch(Integer stBatch) {
    this.stBatch = stBatch;
  }



  @Column(name = "ST_TYPE")
  public Integer getStType() {
    return stType;
  }

  public void setStType(Integer stType) {
    this.stType = stType;
  }

  @Column(name = "ST_NAME")
  public String getStName() {
    return stName;
  }

  public void setStName(String stName) {
    this.stName = stName;
  }

  @Column(name = "ST_CODE")
  public Long getStCode() {
    return stCode;
  }

  public void setStCode(Long stCode) {
    this.stCode = stCode;
  }

  @Column(name = "CNT")
  public Long getCnt() {
    return cnt;
  }

  public void setCnt(Long cnt) {
    this.cnt = cnt;
  }

  @Column(name = "INS_ID")
  public Long getInsId() {
    return insId;
  }

  public void setInsId(Long insId) {
    this.insId = insId;
  }

  @Column(name = "KEY_TYPE")
  public Integer getKeyType() {
    return keyType;
  }

  public void setKeyType(Integer keyType) {
    this.keyType = keyType;
  }


}
