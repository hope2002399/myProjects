package com.smate.center.task.dao.open;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.smate.center.task.exception.DaoException;
import com.smate.core.base.utils.constant.DBSessionEnum;
import com.smate.core.base.utils.data.HibernateDao;
import com.smate.core.base.utils.model.wechat.OpenUserUnion;

/**
 * 第三方系统与SNS关联表Dao
 * 
 * 
 */
@Repository
public class OpenUserUnionDao extends HibernateDao<OpenUserUnion, Long> {
  @Override
  public DBSessionEnum getDbSession() {
    return DBSessionEnum.SNS;
  }

  protected Logger logger = LoggerFactory.getLogger(getClass());

  /**
   * 通过psnId获取第一条记录的openId
   * 
   * @Parameter psnId
   */
  @SuppressWarnings("unchecked")
  public Long getOpenIdByPsnId(Long psnId) throws DaoException {
    try {
      String hql = "select t.openId from OpenUserUnion t where t.psnId = :psnId";
      List<Long> openIdList = new ArrayList<Long>();
      openIdList = super.createQuery(hql).setParameter("psnId", psnId).list();
      if (CollectionUtils.isEmpty(openIdList)) {
        return null;
      } else {
        return openIdList.get(0);
      }
    } catch (Exception e) {
      logger.error("根据psnId从数据库获取openId异常! psnId=" + psnId);
      throw new DaoException(e);
    }
  }

  /**
   * 通过openId查询第一条记录
   * 
   * @Parameter openId
   */
  @SuppressWarnings("unchecked")
  public OpenUserUnion getOpenUserUnionByOpenId(Long openId) throws DaoException {
    try {
      String hql = "from OpenUserUnion t where t.openId = :openId";
      List<OpenUserUnion> openUserUnionList = new ArrayList<OpenUserUnion>();
      openUserUnionList = super.createQuery(hql).setParameter("openId", openId).list();

      if (CollectionUtils.isEmpty(openUserUnionList)) {
        return null;
      } else {
        return openUserUnionList.get(0);
      }
    } catch (Exception e) {
      logger.error("根据openId从数据库获取open人员关联对象异常! openId=" + openId);
      throw new DaoException(e);
    }

  }

  /**
   * 保存OpenUserUnion类
   * 
   * @Parameter openUserUnion
   */
  public void saveOpenUserUnion(OpenUserUnion openUserUnion) throws DaoException {
    try {
      super.save(openUserUnion);
    } catch (Exception e) {
      logger.error("保存openId与用户的关联关系异常 " + openUserUnion.toString());
      throw new DaoException(e);
    }
  }

  /**
   * 通过openId，token查询唯一记录
   * 
   * @Parameter openId，token
   */
  public OpenUserUnion getOpenUserUnion(Long openId, String token) throws DaoException {

    try {
      String hql = "from OpenUserUnion t where t.openId = ? and t.token = ?";
      return super.findUnique(hql, openId, token);
    } catch (Exception e) {
      logger.error("根据openId,token从数据库获取open人员关联对象异常! openId=" + openId + ";token=" + token);
      throw new DaoException(e);
    }
  }

  public boolean ifRegisteredInTheIns(Long psnId, String token) {
    String hql = "select count(1) from OpenUserUnion t where t.psnId =:psnId and t.token =:token";
    Long counts =
        (Long) super.createQuery(hql).setParameter("psnId", psnId).setParameter("token", token).uniqueResult();
    if (counts > 0) {
      return true;
    }
    return false;
  }

  public Long getUserOpenId(Long psnId, String token) {
    String hql = "select t.openId from OpenUserUnion t where t.psnId =:psnId and t.token =:token";
    return (Long) super.createQuery(hql).setParameter("psnId", psnId).setParameter("token", token).list().get(0);
  }

  @SuppressWarnings("unchecked")
  public List<OpenUserUnion> getOpenUserUnion(Long psnId) {
    String hql = "from OpenUserUnion t where t.psnId =:psnId  and t.token not in ('00000000','11111111')";
    return super.createQuery(hql).setParameter("psnId", psnId).list();
  }

  @SuppressWarnings("unchecked")
  public List<Long> getUnionPsnId() {
    String hql =
        "select t.psnId from OpenUserUnion t where t.token not in ('00000000','11111111') and not exists(select 1 from UserUnionLoginLog f where t.psnId=f.psnId)";
    return super.createQuery(hql).setMaxResults(1000).list();
  }

}
