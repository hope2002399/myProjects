package com.smate.center.task.service.sns.psn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smate.center.task.dao.sns.psn.PsnRefPsnRecScoreDao;
import com.smate.center.task.exception.ServiceException;
import com.smate.center.task.model.sns.psn.PsnRefPsnRecScore;


/**
 * 
 * @author lichangwen
 * 
 */
@Service("psnRefPsnRecScoreService")
@Transactional(rollbackFor = Exception.class)
public class PsnRefPsnRecScoreServiceImpl implements PsnRefPsnRecScoreService {

  private final Logger logger = LoggerFactory.getLogger(getClass());
  @Autowired
  private PsnRefPsnRecScoreDao psnRefPsnRecScoreDao;

  @Override
  public void truncatePsnRefRecommendScore() throws ServiceException {
    psnRefPsnRecScoreDao.truncatePsnRefPsnRecScore();
  }

  @Override
  public void psnRefDegrees(Long psnId) throws ServiceException {
    psnRefPsnRecScoreDao.updateScore(psnId);
  }

  @Override
  public void save(PsnRefPsnRecScore psnRefRecScore) throws ServiceException {
    psnRefPsnRecScoreDao.save(psnRefRecScore);
  }

  @Override
  public List<PsnRefPsnRecScore> getDescRefList(Long psnId, int language, int size) throws ServiceException {
    return psnRefPsnRecScoreDao.getDescRefList(psnId, language, size);
  }

}
