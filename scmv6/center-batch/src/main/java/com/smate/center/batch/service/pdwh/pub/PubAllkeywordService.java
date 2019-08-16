package com.smate.center.batch.service.pdwh.pub;

import java.util.List;

import com.smate.center.batch.exception.pub.ServiceException;
import com.smate.center.batch.model.pdwh.pub.PubAllkeyword;

/**
 * 成果关键词服务
 * 
 * @author warrior
 * 
 */
public interface PubAllkeywordService {

  /**
   * 保存关键词拆分
   * 
   * @param pubId
   * @param dbid
   * @param keywords
   * @param type
   * @throws ServiceException
   */
  void savePubAllKeyword(Long publAllId, String keywords, Integer type, Integer pubYear) throws ServiceException;

  /**
   * 给人员推荐基准文献，关键词匹配
   * 
   * @param kwHashList
   * @return
   * @throws ServiceException
   */
  List<PubAllkeyword> findPubAllByKwHash(List<Long> kwHashList) throws ServiceException;

  /**
   * 获取成果关键词
   * 
   * @param puballId
   * @return
   * @throws ServiceException
   */
  List<String> getPubAllKwsById(Long puballId) throws ServiceException;
}
