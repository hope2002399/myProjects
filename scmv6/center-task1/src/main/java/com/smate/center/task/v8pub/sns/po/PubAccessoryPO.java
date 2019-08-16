package com.smate.center.task.v8pub.sns.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 成果附件表
 * 
 * @author aijiangbin
 * @date 2018年5月31日
 */

@Entity
@Table(name = "V_PUB_ACCESSORY")
public class PubAccessoryPO implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 2677545924398176684L;

  @Id
  @SequenceGenerator(name = "SEQ_PUB_ACCESSORY_ID", sequenceName = "SEQ_PUB_ACCESSORY_ID", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PUB_ACCESSORY_ID")
  @Column(name = "ID")
  private Long id; // 主键

  @Column(name = "PUB_ID")
  private Long pubId; // 成果id

  @Column(name = "FILE_ID")
  private Long fileId; // 文件id

  @Column(name = "FILE_NAME")
  private String fileName; // 文件名

  @Column(name = "FILE_DESC")
  private String fileDesc; // 文件描述

  @Column(name = "PERMISSION")
  private Integer permission = 0; // 文件 权限 0=所有人；2=仅本人

  @Column(name = "GMT_CREATE")
  private Date gmtCreate; // 创建时间

  @Column(name = "GMT_MODIFIED")
  private Date gmtModified; // 更新时间


  public PubAccessoryPO() {
    super();
  }


  public Long getId() {
    return id;
  }


  public void setId(Long id) {
    this.id = id;
  }


  public Long getPubId() {
    return pubId;
  }


  public void setPubId(Long pubId) {
    this.pubId = pubId;
  }


  public Long getFileId() {
    return fileId;
  }


  public void setFileId(Long fileId) {
    this.fileId = fileId;
  }


  public String getFileName() {
    return fileName;
  }


  public void setFileName(String fileName) {
    this.fileName = fileName;
  }


  public String getFileDesc() {
    return fileDesc;
  }


  public void setFileDesc(String fileDesc) {
    this.fileDesc = fileDesc;
  }


  public Integer getPermission() {
    return permission;
  }


  public void setPermission(Integer permission) {
    this.permission = permission;
  }


  public Date getGmtCreate() {
    return gmtCreate;
  }


  public void setGmtCreate(Date gmtCreate) {
    this.gmtCreate = gmtCreate;
  }


  public Date getGmtModified() {
    return gmtModified;
  }


  public void setGmtModified(Date gmtModified) {
    this.gmtModified = gmtModified;
  }



}
