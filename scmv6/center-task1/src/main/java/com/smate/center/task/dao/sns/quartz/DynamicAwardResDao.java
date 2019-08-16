package com.smate.center.task.dao.sns.quartz;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Repository;
import com.smate.center.task.model.sns.quartz.DynamicAwardRes;
import com.smate.core.base.utils.data.SnsHibernateDao;



/**
 * 资源赞记录Dao.
 * 
 * @author chenxiangrong
 * 
 */
@Repository
public class DynamicAwardResDao extends SnsHibernateDao<DynamicAwardRes, Long> {

  /**
   * 查询资源赞信息.
   * 
   * @param resId
   * @param resType
   * @param resNode
   * @return
   * @throws DaoException
   */
  public DynamicAwardRes getDynamicAwardResByResId(Long resId, int resType, int resNode) {
    StringBuffer hql = new StringBuffer();
    List<Object> params = new ArrayList<Object>();
    hql.append(
        "select new DynamicAwardRes(t.awardId,t.awardTimes) from DynamicAwardRes t where t.resId=? and t.resType=?");
    params.add(resId);
    params.add(resType);
    if (resNode != 0) {
      hql.append(" and resNode=?");
      params.add(resNode);
    }
    return (DynamicAwardRes) super.createQuery(hql.toString(), params.toArray()).setMaxResults(1).uniqueResult();
  }

  public DynamicAwardRes getDynamicAwardRes(Long resId, int resType, int resNode) {
    StringBuffer hql = new StringBuffer();
    List<Object> params = new ArrayList<Object>();
    hql.append("from DynamicAwardRes t where t.resId=:resId and t.resType=:resType");
    params.add(resId);
    params.add(resType);
    if (resNode != 0) {
      hql.append(" and resNode=:resNode");
      params.add(resNode);
    }
    List<DynamicAwardRes> list = super.createQuery(hql.toString()).setParameter("resId", resId)
        .setParameter("resType", resType).setParameter("resNode", resNode).list();
    if (CollectionUtils.isNotEmpty(list)) {
      return list.get(0);
    }
    return null;
  }

  /**
   * 获取成果资源的赞资源信息
   * 
   * @param pubId
   * @return
   */
  public DynamicAwardRes getPubAwardResByResId(Long pubId) {
    String hql = "FROM DynamicAwardRes t where t.resId =:pubId and t.resNode = 1 and t.resType = 1";
    List list = this.createQuery(hql).setParameter("pubId", pubId).list();
    if (list != null && list.size() > 0) {
      return (DynamicAwardRes) list.get(0);
    }
    return null;
  }

}
