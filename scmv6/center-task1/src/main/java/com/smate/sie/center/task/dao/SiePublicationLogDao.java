package com.smate.sie.center.task.dao;

import com.smate.center.task.exception.DaoException;
import com.smate.core.base.utils.data.SieHibernateDao;
import com.smate.sie.center.task.model.SiePublicationLog;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 成果日志Dao.
 * 
 * @author jszhou
 *
 */
@Repository
public class SiePublicationLogDao extends SieHibernateDao<SiePublicationLog, Long> {

  /**
   * @param pubId 成果ID
   * @param opPsnId 操作人
   * @param insId 单位ID
   * @param op 操作枚举
   * @param opDetail 操作详细
   * @param versionNo 成果版本号
   * @throws DaoException
   */
  public void logOp(long pubId, long opPsnId, Long insId, String op, String opDetail) throws DaoException {
    SiePublicationLog publog = new SiePublicationLog();
    publog.setOpPsnId(opPsnId);
    publog.setOpAction(op);
    publog.setOpDate(new Date());
    publog.setOpDetail(opDetail);
    publog.setPubId(pubId);
    publog.setInsId(insId);
    super.save(publog);
  }

  /**
   * 查询成果对应的日志记录.
   * 
   * @param pubId
   * @return
   * @throws DaoException
   */
  @SuppressWarnings("unchecked")
  public List<SiePublicationLog> queryPubLogByPubId(Long pubId) throws DaoException {
    return super.createQuery("from SiePublicationLog t where t.pubId=?", new Object[] {pubId}).list();
  }

  @SuppressWarnings("unchecked")
  public List<SiePublicationLog> queryPubLogByPsnId(Long psnId) throws DaoException {
    return super.createQuery("from SiePublicationLog t where t.opPsnId=?", new Object[] {psnId}).list();
  }

  public void deletePubLogById(Long id) throws DaoException {
    super.createQuery("delete from SiePublicationLog t where t.id=?", id).executeUpdate();
  }
}
