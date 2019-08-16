package com.smate.center.batch.service.pub;

import java.util.List;

import com.smate.center.batch.exception.pub.ServiceException;
import com.smate.center.batch.model.sns.pub.GrantRule;

/**
 * 业务类别申请书成果填报规则
 * 
 * @author scy
 * 
 */
public interface GrantRuleService {

  /**
   * 根据业务ID和年份查找业务规则
   * 
   * @param codeId
   * @return
   * @throws ServiceException
   */
  public GrantRule getGrantRule(Long codeId, Integer year) throws ServiceException;

  /**
   * 根据业务ID查找业务规则
   * 
   * @param codeId
   * @return
   * @throws ServiceException
   */
  public GrantRule getGrantRule(Long codeId) throws ServiceException;

  /**
   * 查询所有的业务类别
   * 
   * @return
   * @throws ServiceException
   */
  public List<GrantRule> getAll() throws ServiceException;
}
