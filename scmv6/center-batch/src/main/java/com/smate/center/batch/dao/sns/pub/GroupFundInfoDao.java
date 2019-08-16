package com.smate.center.batch.dao.sns.pub;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.smate.center.batch.model.sns.pub.GroupFundInfo;
import com.smate.core.base.utils.data.SnsHibernateDao;

/**
 * 群组待处理成果Dao.
 * 
 * yanmingzhuang
 */
@Repository
public class GroupFundInfoDao extends SnsHibernateDao<GroupFundInfo, Long> {
  @SuppressWarnings("unchecked")
  public List<GroupFundInfo> getToHandleList(Integer size, Long startGroupId, Long endGroupId) {
    String hql =
        "from GroupFundInfo t where t.groupId >:startGroupId and t.groupId <=:endGroupId and t.status = 0 order by t.groupId asc";
    return super.createQuery(hql).setParameter("startGroupId", startGroupId).setParameter("endGroupId", endGroupId)
        .setMaxResults(size).list();
  }
}
