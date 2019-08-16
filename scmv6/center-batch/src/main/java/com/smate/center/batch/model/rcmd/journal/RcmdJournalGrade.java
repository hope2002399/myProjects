package com.smate.center.batch.model.rcmd.journal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 期刊等级.
 * 
 * @author liqinghua
 * 
 */
@Entity
@Table(name = "JOURNAL_GRADE")
public class RcmdJournalGrade implements Serializable {


  /**
   * 
   */
  private static final long serialVersionUID = 6689791993034034706L;
  private Long id;
  // 期刊ISSN
  private String issn;
  // 期刊等级
  private Integer grade;

  @Id
  @Column(name = "ID")
  public Long getId() {
    return id;
  }

  @Column(name = "ISSN")
  public String getIssn() {
    return issn;
  }

  @Column(name = "GRADE")
  public Integer getGrade() {
    return grade;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setIssn(String issn) {
    this.issn = issn;
  }

  public void setGrade(Integer grade) {
    this.grade = grade;
  }

}
