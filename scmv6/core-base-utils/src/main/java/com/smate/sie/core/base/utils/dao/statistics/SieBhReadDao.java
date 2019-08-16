package com.smate.sie.core.base.utils.dao.statistics;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.smate.core.base.utils.data.SieHibernateDao;
import com.smate.core.base.utils.model.Page;
import com.smate.sie.core.base.utils.model.statistics.SieBhRead;

/**
 * 阅读记录表
 * 
 * @author hd
 *
 */
@Repository
public class SieBhReadDao extends SieHibernateDao<SieBhRead, Long> {

  public void deleteByPubIdAndType(Long pubId, Integer type) {
    String hql = "delete from SieBhRead where keyId =:pubId and type=:type";
    this.createQuery(hql).setParameter("pubId", pubId).setParameter("type", type).executeUpdate();

  }

  public Long countRead(Long keyId, Integer type) {
    String hql = "select count(1) from SieBhRead t where t.keyId=:keyId and t.type=:type";
    return (Long) super.createQuery(hql).setParameter("keyId", keyId).setParameter("type", type).uniqueResult();
  }

  @SuppressWarnings("unchecked")
  public List<SieBhRead> getByPubIdAndType(Long pubId, Integer type) {
    String hql = "from SieBhRead where keyId =:pubId and type=:type";
    return this.createQuery(hql).setParameter("pubId", pubId).setParameter("type", type).list();

  }

  /**
   * 批量获取记录
   * 
   * @param insId
   * @param page
   * @return
   */
  @SuppressWarnings("unchecked")
  public Page<SieBhRead> findByTypeAndKeyIds(Long keyId, String types, Date beginTime, Date endTime,
      Page<SieBhRead> page) {
    StringBuilder hql = new StringBuilder();
    hql.append("from SieBhRead where keyId =? and  creDate>=? and creDate<?");
    if (StringUtils.isNotBlank(types)) {
      hql.append(" and type in(" + types + ") ");
    }
    Object[] objects = new Object[] {keyId, beginTime, endTime};
    Query q = createQuery(hql.toString(), objects);
    if (page.isAutoCount()) {
      long totalCount = countHqlResult(hql.toString(), objects);
      page.setTotalCount(totalCount);
    }
    setPageParameter(q, page);
    List<SieBhRead> result = q.list();
    page.setResult(result);
    return page;
  }
}
